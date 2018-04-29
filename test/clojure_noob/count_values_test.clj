(ns clojure-noob.count-values-test
  (:require [clojure.test :refer :all]
            [clojure-noob.count-values :refer :all]))

(def map-of-lists {:a '(1 398 59 32 51 56)
                   :b '(125 42)
                   :c '(1098 13 92 249)})

(deftest sum-list-in-map-recursive-using-map-of-lists
  (is (= 12 (sum-list-in-map-recursive map-of-lists))))

(deftest sum-list-in-map-functional-using-map-of-lists
  (is (= 12 (sum-list-in-map-map-reduce map-of-lists))))

(deftest sum-list-in-map-loop-using-map-of-lists
  (is (= 12 (sum-list-in-map-loop map-of-lists))))
