(ns math-fun.sqrt)

(defn square [x] (* x x))

(defn abs [n] (if (< n 0) (- n) n))

(defn good-enough?
  [guess x]
  (< (abs (- (square guess) x)) 0.00001))

(defn average
  [a b]
  (/ (+ a b) 2.0))

(defn improve
  [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter 
  [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn sqrt
  [n]
  (sqrt-iter 1.0 n))
