(ns lich.touch
  (:require clojure.java.io))

(defn- does-not-exist [filename]
  (not (.exists (clojure.java.io/file filename))))

(defn touch-with-license [filename]
  (if (does-not-exist filename)
    (spit filename "") ;; TODO: output license
    ())) ;; TODO: support existed files
