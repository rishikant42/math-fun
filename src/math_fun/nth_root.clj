(ns math-fun.nth_root
  (:require
    [math-fun.basic_math :refer [exp average abs]]))

(def tolerance 0.00001)

;; (defn abs [n] (if (< n 0) (- n) n))
;; 
;; (defn average 
;;   [a b] 
;;   (/ (+ a b) 2.0))
;; 
;; (defn exp 
;;   [b n]
;;   (if (= n 0)
;;     1
;;     (* b (exp b (- n 1)))))

(defn close-enough? 
  [a b]
  (< (abs (- a b)) tolerance))

(defn fixed-point [f first-guess]
  (defn tri [guess]
    (let [nxt (f guess)]
      (if (close-enough? guess nxt)
        nxt
        (tri nxt))))
  (tri first-guess))

(defn average-damping [f]
  (fn [x] (average x (f x))))

;; (defn sqrt [x]
;;   (fixed-point (fn [y] (average y (/ x y))) 1.0))


(defn compose [f g]
  (fn [x] (f (g x))))

;; (println ((compose (fn [x] (* x x)) (fn [x] (+ x 10))) 10))

(defn repeated [f n]
  (if (= n 1)
    f
    (compose f (repeated f (- n 1)))))

;; (println ((repeated (fn [x] (* x x)) (int 2.0)) 3))

(defn logB [n b]
  (/ (Math/log n) (Math/log b)))

(defn nth-root [x n]
  (let [counter (Math/floor (logB n 2))]
    (if (= counter 0)
      x
    (fixed-point ((repeated average-damping (int counter)) (fn [y] (/ x (exp y (- n 1))))) 
                 1.0))))

;; (println (nth-root 1024 10))
