(ns bleach.core (:gen-class))

(defn whiten
  [shirt]
  (list* (map int (str "(do " shirt ")"))))

(defn brighten
  [shirt]
  (read-string (apply str (map char shirt))))

(defn -main [file]
  (spit file (str "(use 'bleach.core) #bleach/ed " (whiten (slurp file)))))
