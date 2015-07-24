# clj-mailgun

A Clojure Wrapper to Mailgun API.

Usage
-----
Here's how to send a message using the library:

```
defn example-of-send-email
  []
  (let [credentials {:api-key "YOUR_API_KEY" :domain "YOUR_DOMAIN"}
        params {:from "FROM_EMAIL" :to "TO_EMAIL" :subject "YOUR_SUBJECT" :text "YOUR_TEXT"}]
    (core/send-email credentials params))
```
## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
