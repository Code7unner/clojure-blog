(ns cljblog.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cljblog.db :as db]))

(defn index [_]
  (->> (db/list-articles)
       (map #(str "<h2>" (:title %) "</h2>"))
       (apply str "<h1>CljBlog</h1>")))

(defroutes app-routes
  (GET "/" [] index)
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
