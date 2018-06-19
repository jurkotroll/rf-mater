(ns rf-mater.db
  (:require [cljs.reader]
            [cljs.spec.alpha :as s]
            [re-frame.core :as re-frame]
            [clojure.string :as str]))


;; (s/def ::string (s/and string? (complement str/blank?)))
;; (s/def :person/name ::string)


(def default-db
  {:auto {:name "VW T4"
          :driver {:name "Jurek"}
          :passengers []}
   :name "re-frame"})
