(ns math-fun.core
  (:require
    [math-fun.sqrt :refer [sqrt]]
    [math-fun.cube_root :refer [cube-root]]
    [math-fun.is_prime :refer [prime?]]
    )
  (:gen-class))

(defn help
  []
  (println "Usage:
math sum <args>
math multiply <args>
math factorial <arg>
math square-root <arg>
math cube-root <arg>
math exp <args>

options:
-h --help    show help
-v --version show version"))

(defn error-msg
  []
  (println "ERROR: Missing arguments") (help))

(defn sum
  [args]
  (reduce + args))

(defn mult
  [args]
  (reduce * args))

(defn div
  [args]
  (reduce / args))

(defn fact
  [n]
  (if (= n 1)
    1
    (* n (fact (- n 1)))))

;; (defn fact-iter [n]
;;   (defn iter [counter result]
;;     (if (> counter n)
;;       result
;;       (iter (+ counter 1) (* counter result))))
;;   (iter 1 1))

(defn exp
  [b n]
  (if (= n 0)
    1
    (* b (exp b (- n 1)))))

;; (defn exp-iter [b n]
;;   (defn iter [counter result]
;;     (if (= counter 0)
;;       result
;;       (iter (- counter 1) (* b result))))
;;   (iter n 1))

(defn -main
  [& args]
  (let [[command & arg] args
        arg (map read-string arg)]
    (if (empty? arg)
      (error-msg)
      (case command
        "sum" (println (sum arg))

        "multiply" (println (mult arg))

        "factorial" (println (fact (first arg)))

        "divide" (println (div arg))

        "square-root" (println (sqrt (first arg)))

        "cube-root" (println (cube-root (first arg)))

        "exp" (println (exp (first arg) (first (rest arg))))

        "isprime" (println (prime? (first arg)))

        (do (println "ERROR: Unknown command") (help))
        ))))
