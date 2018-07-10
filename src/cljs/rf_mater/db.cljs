(ns rf-mater.db
  (:require [cljs.reader]
            [cljs.spec.alpha :as s]
            [re-frame.core :as re-frame]
            [clojure.string :as str]))

#_(shadow.cljs.devtools.api/nrepl-select :app)
;; (s/def ::string (s/and string? (complement str/blank?)))
;; (s/def :person/name ::string)


(def default-db
  #:db {:events #:events
                 {:event-01 #:event-01
                             {:id 001
                              :data "25-01-2018"
                              :place "Jańskie Łaźni"
                              :start-time "6:00"
                              :start-place "McD Factory"
                              :finish-time "20:00"} :event-02 #:event-02
                                                               {:id 002}}})
