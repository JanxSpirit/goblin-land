(ns goblin-land.events
    (:require [re-frame.core :as re-frame :refer [reg-event-db]]
              [goblin-land.db :as db :refer [rooms default-db]]))

(reg-event-db
 :initialize-db
 (fn  [_ _]
   default-db))

(reg-event-db
 :move
 (fn [db [_ direction]]
   (let [current-exits (get-in db [:current-room :exits])
         destination (get current-exits (keyword direction))] 
     (assoc db 
            :move-direction direction
            :current-room (get rooms destination)))))

(reg-event-db 
:process-command
(fn [db [_ command]]
  db))
