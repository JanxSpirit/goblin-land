(ns goblin-land.views
    (:require [re-frame.core :as re-frame :refer [subscribe dispatch]]
              [clojure.string :as str])
)

(defn direction-link [room-exits direction]
  (if (some #(= (keyword direction) %) room-exits)
    [:a {:href "#" :on-click #(dispatch [:move direction])} direction]
    direction))

(defn create-speech-event [cmd prefix speech]
  [cmd (str/trim (last (str/split (str/lower-case speech) prefix)))]
)

(defn speech-event [speech]
  (condp str/starts-with? (str/lower-case speech)
    "look at" (create-speech-event :look-at "look at" speech)
    [:unrecognized-speech]
))

(defn main-panel []
  (let [room-description (subscribe [:room-description])
        room-exits (subscribe [:room-exits])
        move-direction (subscribe [:move-direction])
        npcs (subscribe [:npcs])
        current-npc-response (subscribe [:current-npc-response])
        current-npc-name (subscribe [:current-npc-name])
        current-player-talk (subscribe [:current-player-talk])]
    
    (fn []
      (let [room-exit-directions (keys @room-exits)]
        [:div [:h1 "The Game of GoblinLand!"]
         [:p @room-description]
         [:p "room occupants: "]
         [:ul (for [npc @npcs]
                [:li {:key npc} npc " " [:a {:href "#" :on-click #(dispatch [:talk npc])} "Talk"]])]
         [:p "your last move direction was: " @move-direction]
         [:p "Move:"] 
         [:ul 
          [:li (direction-link room-exit-directions "north")]        
          [:li (direction-link room-exit-directions "south")]        
          [:li (direction-link room-exit-directions "east")]        
          [:li (direction-link room-exit-directions "west")]        
          [:li (direction-link room-exit-directions "up")]        
          [:li (direction-link room-exit-directions "down")]        
          ]
         
         [:p "Enter your command: " [:input {:type "text" 
                                             :on-key-press (fn [e]
                                                             (if (= 13 (.-charCode e))
                                                               (dispatch [:process-command (-> e .-target .-value)])))}]]
         [:p "You: " @current-player-talk]
         [:p @current-npc-name ": " @current-npc-response]]))))
