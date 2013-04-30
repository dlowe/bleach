(ns leiningen.bleach
  (:require [bleach.core]))

(defn bleach
  "Whitens unsightly code."
  [project file]
  (bleach.core/-main file))
