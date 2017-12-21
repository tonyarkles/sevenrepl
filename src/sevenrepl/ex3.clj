(ns sevenrepl.ex3
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

;; Goal: read a bunch of lines from a CSV file and create functions from them.

(defn get-pairs-from-file [filename]
  (with-open [reader (io/reader filename)]
    (doall (csv/read-csv reader))))

(defmacro load-functions [filename]
  `(doseq [~'line (get-pairs-from-file ~filename)]
    (make-function (first ~'line) (second ~'line))))

(defn make-function [name output]
  (intern *ns* (symbol (str "test-" name)) (fn [] output)))

(load-functions "test.txt")