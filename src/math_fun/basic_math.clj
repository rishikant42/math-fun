(ns math-fun.basic_math)

(defn square [x] (* x x))

(defn cube [x] (* x x x))

(defn abs [n] (if (< n 0) (- n) n))

(defn average
  [a b]
  (/ (+ a b) 2.0))

;;;;;;;;;;;;;;;; SQUARE ROOT ;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn good-enough-1?
  [guess x]
  (< (abs (- (square guess) x)) 0.00001))

(defn improve-1
  [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter 
  [guess x]
  (if (good-enough-1? guess x)
    guess
    (sqrt-iter (improve-1 guess x)
               x)))

(defn sqrt
  [n]
  (sqrt-iter 1.0 n))

;;;;;;;;;;;;;;;;; CUBE ROOT ;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn good-enough-2?
  [guess x]
  (< (abs (- (cube guess) x)) 0.00001))

(defn improve-2
  [guess x]
  (average guess (/ x (square guess))))

(defn cube-iter 
  [guess x]
  (if (good-enough-2? guess x)
    guess
    (cube-iter (improve-2 guess x)
               x)))

(defn cube-root
  [n]
  (cube-iter 1.0 n))

;;;;;;;;;;;;;;;;;;;;;; IS-PRIME ;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn divides?    ;; is "a" divided by "b"
  [a b]
  (= (mod a b) 0))

(defn find-divisor
  [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? n test-divisor) test-divisor
        :else (find-divisor n (inc test-divisor))))

(defn smallest-divisor
  [n]
  (find-divisor n 2))

(defn prime?
  [n]
  (if (<= n 1)
    false
    (= n (smallest-divisor n))))
