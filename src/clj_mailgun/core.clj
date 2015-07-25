(ns clj-mailgun.core
  (:require [clj-http.client :as client]
            [clojure.walk :as walk]))

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

(defn validate-email-url
  [email]
  (str api-base-url "/address/validate?address=" email))

(defn validate-email
  [credentials email]
  (let [url (validate-email-url email)
        body (body-builder credentials nil)
        result (client/get url body)
        sym-result (walk/keywordize-keys result)]
    sym-result))
