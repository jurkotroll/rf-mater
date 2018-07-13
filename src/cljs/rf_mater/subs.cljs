(ns rf-mater.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 :sub-event-data
 (fn [db [_ travel-id]]
  (let [travel (travel-id db)]
    travel)))

; (re-frame/reg-sub
;  ::active-panel
;  (fn [db _]
;    (:active-panel db)))


;; (re-frame/reg-sub
;;  :driver
;;  (fn [db _]
;;    (get-in db [:auto :driver])))


;; (re-frame/reg-sub
;;  :passengers
;;  (fn [db _]
;;    (get-in db [:auto :passengers])))
