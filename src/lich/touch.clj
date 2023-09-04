(ns lich.touch
  (:require clojure.java.io)
  (:require [clojure.string :as strs])
  (:require lich.helper))

(def ^:private max-lines 20)

(defmacro ^:private format-comment [start-line end-line mid-start mid-end get-comment]
  `(str ~start-line
        "\n"
        (strs/join "\n" (map #(str ~mid-start % ~mid-end) (take max-lines (strs/split-lines (~get-comment))))) ; TODO: config
        "\n"
        ~end-line))

(defn touch-with-license [filename]
  (if (lich.helper/does-not-exist? filename)
    (spit filename (format-comment "/**" " */" " * " "" lich.helper/get-license)) ;; TODO: config
    ())) ;; TODO: support existed files
