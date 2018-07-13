(ns rf-mater.db
 (:require [cljs.reader]
           [cljs.spec.alpha :as s]
           [re-frame.core :as re-frame]))

#_(shadow.cljs.devtools.api/nrepl-select :app)
;; (s/def ::string (s/and string? (complement str/blank?)))
;; (s/def :person/name ::string)


(def default-db
  {:travels
   {"travel001"
    #:travel{:id "travel001"
             :travel-owner-id "user003"
             :data "25-01-2018"
             :place "Jańskie Łaźni"
             :start-time   "6:00"
             :start-place  "McD Factory"
             :finish-time  "20:00"
             :finish-place "McD Factory"
             :road-time "2,5h"
             :distance "150km"
             :on-place-time "8h"
             :contact-passenger-id "passenger001"
             :car-id "car001"
             :driver-id "passenger001"
             :passengers {"passenger002" true
                          "passenger003" true
                          "passenger004" true}}}
   :passengers
   {"passenger001"
     #:passenger{:user "user003"
                 :travel "travel001"
                 :status 5}   ;;potwierdzono 5; nie potwierdzono 4 ...
    "passenger002"
     #:passenger{:user "user007"
                 :travel "travel001"
                 :status 5}
    "passenger003"
     #:passenger{:user "user013"
                 :travel "travel001"
                 :status 4}
    "passenger004"
     #:passenger{:user "user040"
                 :travel "travel001"
                 :status 1}}   ;;potwierdzono 5; nie potwierdzono 4 ...
   :users
   {"user003"
     #:user{:id "user003"
             :name "Jacek"
             :car "car001"
             :contact-data "email,telefon,adres"
             :created-travels {"travel001" true}
             :travels {"travel001" true}}
    "user007"
     #:user{:id "user007"
            :name "Zofia"
            :car "car020"
            :contact-data "email,telefon,adres"
            :created-travels {}
            :travels {"travel001" true}}
    "user013"
     #:user{:id "user013"
            :name "Hania"
            :car ""
            :contact-data "email,telefon,adres"
            :created-travels {}
            :travels {"travel001" true}}
    "user040"
     #:user{:id "user040"
            :name "Olek"
            :car ""
            :contact-data "email,telefon,adres"
            :created-travels {}
            :travels {"travel001" true}}}
   :cars
   {"car001"
    #:car{:id "car001"
          :name "VW T4 transporter"
          :sits 5
          :color "cerwony"
          :description "cos o twoim aucie"}}})

(defn rdb []
  (def db default-db))

(defn gtr []
 (get-in db [:travel/by-id "travel001"]))
