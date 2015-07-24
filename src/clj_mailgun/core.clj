(ns clj-mailgun.core
  (:require [clj-http.client :as client]))

(def api-host "api.mailgun.net")
(def api-base-url (str "https://" api-host "/v3"))

(defn send-email-url
  [credentials]
  (str api-base-url "/" (:domain credentials) "/messages"))

(defn body-builder
  [credentials params]
  {:basic-auth ["api" (:api-key credentials)]
   :form-params params})

(defn send-email
  [credentials input-params]
  (let [url (send-email-url credentials)
        body (body-builder credentials input-params)]
    (client/post url body)))
