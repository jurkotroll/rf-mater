(ns rf-mater.events
  (:require [re-frame.core :as re-frame]
            [rf-mater.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
   :add-passenger
  (fn [db [_ pas-name]]
   (update-in db [:auto :passengers]
              #(conj % {:name pas-name}))))
   ; (let [passengers (get-in db [:auto :passengers])
   ;       passengers (conj passengers {:name pas-name})]
   ;   (assoc-in db [:auto :passengers] passengers))))
