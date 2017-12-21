(ns sevenrepl.ex4
  (:require [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.json :refer [wrap-json-response]]
            [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]))

(defn json [body]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body body})

(defn json-request [req]
  (json {:foo "bar" :baz "zap" :hello ((:query-params req) "name" "Unknown User")}))

(defroutes myroutes
           (GET "/" [] "hello world")
           (GET "/bazzap" [] "testing")
           (GET "/json" [] json-request))

(def app
  (-> myroutes
      (wrap-defaults site-defaults)
      (wrap-json-response)
      ))

(defn start []
  (run-server #'app {:port 8888}))