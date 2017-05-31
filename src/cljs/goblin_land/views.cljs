(ns goblin-land.views
    (:require [re-frame.core :as re-frame :refer [subscribe dispatch]]))

(defn direction-link [room-exits direction]
  (if (some #(= (keyword direction) %) room-exits)
    [:a {:href "#" :on-click #(dispatch [:move direction])} direction]
    direction))

(defn main-panel []
  (let [room-description (subscribe [:room-description])
        room-exits (subscribe [:room-exits])
        move-direction (subscribe [:move-direction])
        npcs (subscribe [:npcs])]
    (fn []
      (let [room-exit-directions (keys @room-exits)]
        [:div [:h1 "The Game of GoblinLand!"]
         [:p @room-description]
         [:p "room occupants: "]
         [:ul (for [npc @npcs]
                [:li {:key npc} npc])]
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
                                                               (dispatch [:process-command (-> e .-target .-value)])))}]]]))))
