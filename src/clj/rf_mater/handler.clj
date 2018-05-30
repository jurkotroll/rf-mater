(ns rf-mater.handler
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :as route :refer [resources]]
            [ring.util.response :refer [response resource-response]]
            [ring.middleware.json :as middleware]
            [ring.middleware.reload :refer [wrap-reload]]))

(def database
  (atom  {:auto {:name "VW T4"
           :driver {:name "Jurek"}
           :passengers [{:name "Zofia"}
                        {:name "Olek"}
                        {:name "Magda"}]}}))

; (defn command [req]
;   (let [params (:params req)
;         command (:command params)]
;     (if (= command :set-passengers))))
;
; {:command :set-passengers
;  :data {:passengers [{:name ...}]}}
;
; defmulti
; defmethod
;
; (post "/api" {:command :add-person
;               :data {:name ...}})

(defn fetch-data [req]
  (response @database))

(defroutes routes
  (GET "/" [] (resource-response "index.html" {:root "public"}))
  (GET "/initial-data" req (fetch-data req))
;  (POST "/api" req (command req))
  (resources "/")
  (route/not-found "<h1> NOT ZNaleziono!! 404!!! <h1>"))

(def dev-handler (-> #'routes wrap-reload))

(def handler
  (-> routes
      middleware/wrap-json-response))
