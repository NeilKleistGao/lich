(ns lich.helper
  (:require clojure.java.io
            [clojure.string :as strs])
  (:require clojure.pprint)
  (:require [clojure.java.shell :as shell]))

(defmacro does-not-exist? [filename]
  `(not (.exists (clojure.java.io/file ~filename))))

(defmacro ^:private sh [cmd & args]
  `(shell/sh ~cmd ~@args))

(defn- get-git-root [] ; TODO: check the directory
  (try
    (sh "git" "rev-parse" "--show-toplevel")
    (catch Exception e (.getMessage e)))) ; use current dir as the git root

(defn get-license []
  (let [path (get (get-git-root) :out ".") file (str (strs/replace path #"\n" "") "/LICENSE")]
    (if (does-not-exist? file)
      ""
      (slurp file)))) ; TODO: get the file
