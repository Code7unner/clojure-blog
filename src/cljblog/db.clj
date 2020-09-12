(ns cljblog.db
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

(def db-connection-uri (or (System/getenv "CLJBLOG_MONGO_URI")
                           "mongodb://127.0.0.1/cljblog-test"))

(def db (-> db-connection-uri
            mg/connect-via-uri
            :db))

(def articles-coll "articles")

(defn create-article [title body]
  (mc/insert db articles-coll
             {:title title
              :body body
              :created (new java.util.Date)}))

(defn list-articles []
  (mc/find-maps db articles-coll))