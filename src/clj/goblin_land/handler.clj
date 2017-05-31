(ns goblin-land.handler
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [resources]]
            [ring.util.response :refer [resource-response content-type]]
            [ring.middleware.reload :refer [wrap-reload]]))

(defroutes routes
  (GET "/" [] (content-type (resource-response "index.html" {:root "public"}) 
                            "text/html; charset=utf-8"))
  (resources "/"))

(def dev-handler (-> #'routes wrap-reload))

(def handler routes)
