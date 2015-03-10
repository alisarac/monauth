(defproject monauth "0.1.0-SNAPSHOT"
  :description "Authentication service"
  :url "https://github.com/alisarac/monauth"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [buddy "0.4.1"]
                 [mysql/mysql-connector-java "5.1.34"]
                 [korma "0.4.0"]
                 [environ "1.0.0"]]
  :plugins [[lein-ring "0.8.13"]
            [lein-environ "1.0.0"]]
  :ring {:handler monauth.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
