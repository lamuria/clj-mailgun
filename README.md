# Clj Mailgun [![Build Status](https://travis-ci.org/lamuria/clj-mailgun.svg?branch=master)](https://travis-ci.org/lamuria/clj-mailgun)
[![Clojars Project](http://clojars.org/clj-mailgun/latest-version.svg)](http://clojars.org/clj-mailgun)

A Clojure Wrapper to Mailgun API.

Installation
-----

```clj-mailgun``` is available as a Maven artifact from [Clojars](http://clojars.org/clj-mailgun)

With Leiningen/Boot:

```clojure
[clj-mailgun "0.2.0"]
```

Usage
-----
The functionalities are provided by the ```clj-maigun.core``` namespace.

First, require it in the REPL:

```clojure
(require '[clj-mailgun.core :as mailgun])
```

Or in your application:

```clojure
(ns my-app.core
  (:require [clj-mailgun.core :as mailgun]))
```

Here's how to send a message using the library:

```clojure

(defn example-of-send-email
  []
  (let [credentials {:api-key "YOUR_API_KEY" :domain "YOUR_DOMAIN"}
        params {:from "FROM_EMAIL" :to "TO_EMAIL" :subject "YOUR_SUBJECT" :text "YOUR_TEXT"}]
    (mailgun/send-email credentials params)))
```

Here's how to validate emails using the library:

```clojure

(defn example-of-validate-email
  []
  (let [credentials {:api-key "YOUR_API_KEY"}
        email "bubu@gmail.com"]
    (mailgun/validate-email credentials email)))
```

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
