(ns todo.query_appointments
  (:require [todo.database]
            [korma.core :refer :all]))

(defentity appointments)

(defn get-appointments []
  (select appointments))

(defn add-appointment [observation]
  (insert appointments
          (values {:observation observation})))

(defn delete-appointment [id]
  (delete appointments
          (where {:id [= id]})))

(defn update-appointment [id observation]
  (update appointments
          (set-fields {:observation observation})
          (where {:id [= id]})))

(defn get-appointment [id]
  (first
    (select appointments
          (where {:id [= id]}))))