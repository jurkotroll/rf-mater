(ns rf-mater.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [rf-mater.events :as events]
            [rf-mater.routes :as routes]
            [rf-mater.views :as views]
            [rf-mater.config :as config]
            [day8.re-frame.http-fx]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
   (re-frame/dispatch [::events/fetch-data])
  (dev-setup)
  (mount-root))
