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


