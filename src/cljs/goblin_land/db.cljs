(ns goblin-land.db)

(def rooms {:kitchen {:id :kitchen
                      :name "Kitchen"
                      :description "The kitchen of the OrcTown cafe is a filthy place, full of unusual, and in some cases disgusting smells. A constant stream of steams and smokes gives the air a hazy look, and the din and clatter of the cooks is always present.

There is a sink full of crusty, dirty dishes, and greenish water.

On the stove a leg of some unknown beast is sizzling.

Exits: a trapdoor [down], a set of swinging doors [west]."
                      :exits {:down :root-cellar :west :dining-room}
                      :npcs {"Chef" {:responses ["Back to work!!"]}}
                      :interactions {"sink" {:description "The water is hot and swampy green. A film of oily goo covers the surface. It is full of dishes and something gleams in the bottom."
                                             :actions {"wash dishes" "You start to scrub the horrible stack of dishes."
                                                       "examine shiny thing" "It looks like a dirty cheese grater."
                                                       "get cheese grater" "OK. You fish the cheese grater out of the vile water."}}}}
            :root-cellar {:id :root-cellar
                          :name "Root Cellar"
                          :description "The whole room is filled with kegs. They are full of vile, brown, Orc Ale. There is a trapdoor upwards [up] It is bitterly cold, with no heat. You can't believe how orcs survive in this room."
                          :exits {:up :kitchen}
                          :npcs {"Drunk Orc" {:responses ["uuhr you 'posed to be he'h?"]}}}
            :dining-room {:id :dining-room
                          :name "Dining Room"
                          :description "The dining room is filled with creatures of all sorts of species. There are all sorts of disgusting dishes on the tables. The tables are covered with blood-red tablecloths. They are dyed with the blood of the creatures the Chef cooks."
                          :exits {:east :kitchen}
                          :npcs {"waiter" {:responses ["got to get to the Cyclops at table 9!"]}
                                 "Cyclops" {:responses ["Urggghhh"]}}}})

(def default-db
  {:move-direction "you did not move yet"
   :current-room (:kitchen rooms)})
