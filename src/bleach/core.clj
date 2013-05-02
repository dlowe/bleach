(ns bleach.core
  (:require [clojure.string :refer (split-lines)])
  (:gen-class))

(defn bits
  [x & bs]
  (if (zero? x)
    bs
    (recur (bit-shift-right x 1) (conj bs (bit-and x 0x01)))))

(defn whiten
  [shirt]
  (->>
    (str "(do " shirt ")")
    (mapcat (comp #(str (apply str %) "\n") (partial map #(if (= % 0) \space \tab)) bits int))
    (apply str)))

(defn unbits
  [bs]
  (reduce (fn [x bit]
            (let [x (bit-shift-left x 1)]
              (if (pos? bit)
                (bit-set x 0)
                x))) 0 bs))

(defn brighten
  [shirt]
  (->>
    (split-lines shirt)
    (map (comp char unbits (partial map #(if (= % \tab) 1 0))))
    (apply str)
    (read-string)))

(defn -main [file]
  (spit file (str "(use 'bleach.core) #bleach/ed \"" (whiten (slurp file)) "\"")))
