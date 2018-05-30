(ns rf-mater.db
  (:require [cljs.reader]
            [cljs.spec.alpha :as s]
            [re-frame.core :as re-frame]))

(s/def ::id int?)


(def default-db
  {:auto {:name "VW T4"
          :driver {:name "Jurek"}
          :passengers []}})
