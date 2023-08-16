(ns lich.test
  (:use [clojure.test :only [deftest is run-tests]]))

(deftest diff-test
  (is (= 42 42)))

(run-tests 'lich.test)
