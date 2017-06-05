(ns goblin-land.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame :refer [reg-sub]]))

(reg-sub
 :room-text
 (fn [db]
   (:room-text db)))

(reg-sub
 :move-direction
 (fn [db]
   (:move-direction db)))

(reg-sub
 :room-description
 (fn [db]
   (get-in db [:current-room :description])))

(reg-sub
 :room-exits
 (fn [db]
   (get-in db [:current-room :exits])))

(reg-sub
 :npcs
 (fn [db]
   (keys (get-in db [:current-room :npcs]))))

(reg-sub
 :current-npc-name
 (fn [db]
   (:current-npc-name db)))

(reg-sub
 :current-npc-response
 (fn [db]
   (:current-npc-response db)))

(reg-sub
 :current-player-talk
 (fn [db]
   (:current-player-talk db)))

