(ns lich.touch
  (:require clojure.java.io)
  (:require [clojure.string :as strs]))

(defn- does-not-exist? [filename]
  (not (.exists (clojure.java.io/file filename))))

(defmacro format-comment [start-line end-line mid-start mid-end comment]
  `(str ~start-line
        "\n"
        (strs/join "\n" (map #(str ~mid-start % ~mid-end) (strs/split-lines ~comment)))
        "\n"
        ~end-line))

(defn touch-with-license [filename]
  (if (does-not-exist? filename)
    (spit filename (format-comment "/**" " */" " * " "" "foo\nbar\nbaz")) ;; TODO: config
    ())) ;; TODO: support existed files
