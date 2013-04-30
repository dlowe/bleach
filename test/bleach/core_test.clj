(ns bleach.core-test
  (:use clojure.test
        bleach.core))

(def whiten-brighten-code
  ["(+ 1 1)"
   "(def foo 123) foo"
   "(ns foo (:require [clojure.set :refer [subset?]])) (subset? #{1} #{1 2})"])

(deftest whiten-brighten
  (doseq [code whiten-brighten-code]
    (let [expected (with-in-str code
                     (last (map eval
                                (take-while #(not= :eof %)
                                            (repeatedly (partial read *in* false :eof))))))]
      (is (= (eval (brighten (whiten code))) expected)))))
