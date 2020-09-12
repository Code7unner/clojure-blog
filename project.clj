(defproject cljblog "0.1.0"
  :description "Blog written on Clojure"
  :url "http://localhost:3000/"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [com.novemberain/monger "3.5.0"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler cljblog.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
