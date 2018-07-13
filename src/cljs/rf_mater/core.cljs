(ns rf-mater.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [rf-mater.events :as events]
            [rf-mater.routes :as routes]
            [rf-mater.views :as views]
            [rf-mater.config :as config]
            [oops.core :refer [ocall oget oset!]]))
            ;; [day8.re-frame.http-fx]

(defn on-window-resize []
  (re-frame/dispatch [::events/window-width (oget js/window "innerWidth")]))

(defn dev-setup []
  (when config/debug? (enable-console-print!)
        (println "dev mode")))

(defn render []
  ;(re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  ;; (routes/app-routes)

  ;; (re-frame/dispatch [::events/fetch-data])
  (render)
  (ocall js/window "addEventListener" "resize" on-window-resize))
