(ns rf-mater.events
  (:require
   [re-frame.core :as re-frame]
   [rf-mater.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]
   #_[ajax.core :as ajax]))

(def empty-db {:travels {"travel001" {}}
               :users {"user001" {}}})

(re-frame/reg-event-db
 ::add-new-user
 (fn [db [_ id]]
  (assoc-in db [:users id]  {})))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::set-active-panel
 (fn-traced [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 :window-width
 (fn [db [_ window-width]]
   (assoc db :window-width window-width)))

;; (re-frame/reg-event-fx
;;  ::fetch-data
;;  (fn  [_ _]
;;    {:http-xhrio {:method          :get
;;                   :uri             "/initial-data"
;;                   :timeout         8000                                           ;; optional see API docs
;;                   :response-format (ajax/json-response-format {:keywords? true})  ;; IMPORTANT!: You must provide this.
;;                   :on-success      [:load-initial-data]
;;                   :on-failure      [:bad-http-result]}}))



;; (re-frame/reg-event-db
;;   :load-initial-data
;;   (fn [db [_ result]]
;;    (assoc db :auto (:auto result))))

;; (re-frame/reg-event-db
;;   :bad-http-result
;;   (fn [db [_ result]]))

;; (re-frame/reg-event-db
;;    :add-passenger
;;   (fn [db [_ pas-name]]
;;    (update-in db [:auto :passengers]
;;               #(conj % {:name pas-name}))))
;;    ; (let [passengers (get-in db [:auto :passengers])
;;    ;       passengers (conj passengers {:name pas-name})]
;;    ;   (assoc-in db [:auto :passengers] passengers))))
