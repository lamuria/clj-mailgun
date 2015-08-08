(ns clj-mailgun.core-test
  (:require [clojure.test :refer :all]
            [clj-mailgun.core :as core]))

(def credentials {:api-key "pubkey-501jygdalut926-6mb1ozo8ay9crlc28"
                  :domain "sandbox3676e99a03e54cb79ea9fff0ea9e0956.mailgun.org"})

(def input-params
  {:from "Excited User <excited@samples.mailgun.org>"
   :to "zemanel.enterprises@gmail.com"
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


(deftest validate-email-url-test
  (let [email "bubu@mail.com"
        result (core/validate-email-url email)]
    (is (= (str core/api-base-url "/address/validate?address=" email)
           result))))

(deftest validate-email-test
  (let [email "bubu@mail.com"
        response (core/validate-email credentials email)
        body (:body response)]
    (is (= 200 (:status response)))))
