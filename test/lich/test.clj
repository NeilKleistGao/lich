(ns lich.test
  (:require clojure.test)
  (:require clojure.string)
  (:require lich.touch))

(defn- test-touch [filename]
  (println (str "test `lich " filename "`..."))
  (lich.touch/touch-with-license 
   (clojure.string/join "/" ["test" "diff" filename])))

(clojure.test/deftest diff-test
  (test-touch "foo.cpp"))

(clojure.test/run-tests 'lich.test)
