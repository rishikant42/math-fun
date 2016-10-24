(ns math-fun.series_sum
  (:require
    [math-fun.basic_math :refer [exp]]))

;; (defn sum-integers
;;   [a b]
;;   (if (> a b)
;;     0
;;     (+ a (sum-integers (inc a) b))))

;; (defn cube [x] (* x x x))

;; (defn sum-cubes
;;   [a b]
;;   (if (> a b)
;;     0
;;     (+ (cube a) (sum-cubes (inc a) b))))

(defn add
  [power a nxt b]
  (if (> a b)
    0
    (+ (exp a power)
       (add power (nxt a) nxt b))))
