(ns monauth.models.db
  (:require [korma.db :refer :all]
            [korma.core :refer :all]
            [buddy.hashers :as hs]
            [environ.core :refer [env]]))

(defdb db (mysql {:db (env :db-name)
                  :user (env :db-user)
                  :password (env :db-password)
                  :host (env :db-host)}))

(declare users roles applications)

(defentity roles
  (pk :id)
  (table :roles)
  (many-to-many users :users_roles)
  (belongs-to applications))

(defentity users
  (pk :id)
  (table :users)
  (many-to-many roles :users_roles))

(defentity applications
  (pk :id)
  (table :applications)
  (has-many roles))

;; TODO on windows encrypt is not working
(defn add-user! [username password]
  (insert users {:username username 
                 :password (hs/encrypt password)}))
