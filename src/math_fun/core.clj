(ns math-fun.core
  (:gen-class))

(defn sum
  [args]
  (reduce + args))

(defn mult
  [args]
  (reduce * args))

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

(defn div
  [args]
  (reduce / args))

(defn -main
  [& args]
  (let [[command & arg] args
        arg (map read-string arg)]
    (case command
      "sum" (println (sum arg))

      "multiply" (println (mult arg))

      "factorial" (println (fact (first arg)))

      "divide" (println (div arg)))))
