(ns rf-mater.db
  (:require [cljs.reader]
            [cljs.spec.alpha :as s]
            [re-frame.core :as re-frame]))

(s/def ::id int?)


(def default-db
  {:passenger (sorted-map)})



{:auto {:id
        :name
        :color
        :capacity
        :events
        :passengers}}

{:event {:id
         :main?
         :destination
         :day-of-week
         :data
         :distance
         :road-duration
         :start-time
         :on-slope-duration
         :back-road-time}}

{:passanger {:id
             :name
             :status}}
