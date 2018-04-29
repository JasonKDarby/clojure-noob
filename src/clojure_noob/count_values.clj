(ns clojure-noob.count-values
  "A simple exercise in sum lengths of lists within a map")

(defn sum-list-in-list-lengths
  "Takes a list of lists and an initial sum and returns the sum of the lengths
  of the lists within the given list"
  ;; split the list of maps into key-list
  [[[_ list-to-get-length-of] & rest] sum]
  (if (nil? list-to-get-length-of)
    ;; return if there's nothing left to get the length of
    sum
    ;; otherwise add the length to the sum and call this again with the rest
    (sum-list-in-list-lengths rest (+ sum (count list-to-get-length-of)))))

(defn sum-list-in-map-recursive
  "Takes a map of lists then converts it to a seq of key-list pairs before
  passing it to sum-list-in-list-lengths"
  [map-of-lists]
  (sum-list-in-list-lengths (seq map-of-lists) 0))

(defn sum-list-in-map-loop
  "Takes a map of lists then converts it to a seq of key-list pairs before
  recursively counting the lengths of the lists and summing the total"
  [map-of-lists]
  (loop [[[_ value] & rest] (seq map-of-lists) sum 0]
    (if (nil? value)
      sum
      (recur rest (+ sum (count value))))))

(defn sum-list-in-map-map-reduce
  "Takes a map of lists then converts it to a seq of key-list pairs before
  mapping count over it and summing the results"
  [map-of-lists]
  (reduce +
          ;; add counts of map lists together
          (map count
               ;; get the list out of the key-value pairs of the map-of-lists
               (map #(let [[_ value] %] value)
                    ;; turn the map-of-lists into a sequence of key-value pairs
                    (seq map-of-lists)))))