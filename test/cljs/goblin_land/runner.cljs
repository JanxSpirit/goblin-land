(ns goblin-land.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [goblin-land.core-test]))

(doo-tests 'goblin-land.core-test)
