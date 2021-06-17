(ns clojure-test.query
    (:require [clojure-test.database]
              [korma.core :refer :all]))

(defentity bankaccount)

(defn create-account [name agency-number agency-code account balance]
    (insert bankaccount
        (values {:customer_name name :agency_number agency-number :agency_code agency-code :account account :balance balance})))


(defn get-account [agency-number agency-code account]
    (first
        (select bankaccount 
            (where {:agency_number agency-number
                    :agency_code agency-code
                    :account account}))))

(defn get-balance [agency-number, agency-code account]
    (first
        (select bankaccount 
            (fields :balance)
            (where {:agency_number agency-number
                    :agency_code agency-code
                    :account account}))))