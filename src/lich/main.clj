(ns lich.main
  (:require lich.touch)
  (:gen-class))

(defn- print-help []
  (println "Usage: lich filename"))

(defn -main [& args]
  (if (seq args)
    (doseq [arg args] (lich.touch/touch-with-license arg)) ;; TODO: full touch arguments
    (print-help)
    ))
