(ns rf-mater.db
 (:require [cljs.reader]
  [cljs.spec.alpha :as s]
  [re-frame.core :as re-frame]
  [clojure.string :as str]))

#_(shadow.cljs.devtools.api/nrepl-select :app)
;; (s/def ::string (s/and string? (complement str/blank?)))
;; (s/def :person/name ::string)


(def default-db
  {:events #:events
            {:event-e001 #:event-e001
                        {:id "e001"
                         :event-ovner "u003"
                         :data "25-01-2018"
                         :place "Jańskie Łaźni"
                         :start-time   "6:00"
                         :start-place  "McD Factory"
                         :finish-time  "20:00"
                         :finish-place "McD Factory"
                         :road-time "2,5h"
                         :distance "150km"
                         :on-place-time "8h"
                         :contact-person-id "u003"
                         :car-id "car001"
                         :driver-id "u003"
                         :passengers-ids #:passengers-ids
                                           {:passenger-id-01 "u003"
                                            :passenger-id-02 "u007"
                                            :passenger-id-03 "u013"
                                            :passenger-id-04 "u040"}
                         :passengers-status #:passengers-status
                                           {:passenger-id-01 "5"   ;;potwierdzono
                                            :passenger-id-02 "5"   ;;potwierdzono
                                            :passenger-id-03 "3"   ;;nie potwierdzono
                                            :passenger-id-04 "1"}}};;zaproszono

   ;;:passengers
   :users #:users
           {:user-003 #:user-003
                       {:id "u003"
                        :name "Jacek"
                        :car "car001"
                        :contact-data "email,telefon,adres"
                        :his-ovn-events #:his-ovn-events
                                         {:event-001 "e001"}
                        :events-participant #:events-participant
                                         {:event-001 "e001"}}
            :user-007 #:user-007
                       {:id "u007"
                        :name "Zofia"
                        :car "car020"
                        :contact-data "email,telefon,adres"
                        :his-ovn-events #:his-ovn-events
                                         {}
                        :events-participant #:events-participant
                                         {:event-001 "e001"}}
            :user-013 #:user-013
                       {:id "u013"
                        :name "Hania"
                        :car ""
                        :contact-data "email,telefon,adres"
                        :his-ovn-events #:his-ovn-events
                                         {}
                        :events-participant #:events-participant
                                         {:event-001 "e001"}}
            :user-040 #:user-040
                       {:id "u040"
                        :name "Olek"
                        :car ""
                        :contact-data "email,telefon,adres"
                        :his-ovn-events #:his-ovn-events
                                         {}
                        :events-participant #:events-participant
                                         {:event-001 "e001"}}}
    :cars #:cars
           {:car-001 #:car-001
                      {:id "car001"
                       :name "VW T4 transporter"
                       :sits 5
                       :color "cerwony"
                       :description "cos o twoim aucie"}}})
