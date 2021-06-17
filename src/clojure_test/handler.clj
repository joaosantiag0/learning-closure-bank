(ns clojure-test.handler
    (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [clojure-test.query :refer :all]))

(defroutes app-routes
    (POST "/api/account/new" {:keys [params]}
        (let [{:keys [name agency_number agency_code account balance]} params]
            (create-account name agency_number agency_code account balance)
            (response params)))
    (GET "/api/account" {:keys [params]}
        (let [{:keys [agency_number agency_code account]} params]
            (response (get-account agency_number agency_code account))))
    (GET "/api/account/balance" {:keys [params]}
        (let [{:keys [agency_number agency_code account]} params]
            (response (get-balance agency_number agency_code account))))
    (route/resources "/")
    (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))