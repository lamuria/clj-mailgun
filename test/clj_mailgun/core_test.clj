(ns clj-mailgun.core-test
  (:require [clojure.test :refer :all]
            [clj-mailgun.core :as core]))

(def credentials {:api-key "key-3ax6xnjp29jd6fds4gc373sgvjxteol0"
                  :domain "samples.mailgun.org"})

(def input-params
  {:from "Excited User <excited@samples.mailgun.org>"
   :to "devs@mailgun.net"
   :subject "this is a subject"
   :text "this is a email body"})

(deftest api-host-test
  (is (= "api.mailgun.net" core/api-host))
  (is (= (str "https://" core/api-host "/v3") core/api-base-url)))

(deftest body-builder-test
  (let [result (core/body-builder credentials input-params)
        basic-auth (:basic-auth result)]
    (is (= "api" (first basic-auth)))
    (is (= (:api-key credentials) (second basic-auth)))
    (is (= input-params (:form-params result)))))

(deftest send-email-url-test
  (let [result (core/send-email-url credentials)]
    (is (= (str core/api-base-url "/" (:domain credentials) "/messages")
           result))))
