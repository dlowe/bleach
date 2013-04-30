(ns bleach.core (:gen-class))

(defn bits
  [x]
  (loop [x (int x)
         bs ()]
    (if (zero? x)
      bs
      (recur (bit-shift-right x 1) (conj bs (bit-and x 0x01))))))

(defn whiten
  [shirt]
  (apply str (mapcat #(str (apply str %) "\n") (map bits (str "(do " shirt ")")))))

(defn unbits
  [bs]
  (loop [x 0
         bs bs]
    (if (empty? bs)
      x
      (let [x (bit-shift-left x 1)]
        (recur (if (pos? (first bs)) (bit-set x 0) x) (rest bs))))))

(defn brighten
  [shirt]
  (read-string (apply str (map char shirt))))

(defn -main [file]
  (spit file (str "(use 'bleach.core) #bleach/ed " (whiten (slurp file)))))
