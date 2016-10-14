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


;;;;;;;;;;;;;;;;;;;;;; FACTORIAL ;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

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

;;;;;;;;;;;;;;;;;;; EXPONENTIAL ;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


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


;;;;;;;;;;;;;;; SUM-MULTIPLY-DIVISION ;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn sum
  [args]
  (reduce + args))

(defn mult
  [args]
  (reduce * args))

(defn div
  [args]
  (reduce / args))

;;;;;;;;;;;;;;;;;;;;; GCD ;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn gcd
  [a b]
  (loop [a (abs a)
        b (abs b)]
    (if (= b 0)
      a
      (recur b (mod a b)))))

;;;;;;;;;;;;;;;;;;;; Average-of-N-numbers ;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn avg
  [numbers]
  (/ (reduce + numbers) 
     (double (count numbers))))

;;;;;;;;;;;;;;;;;;;;; fibonacci number ;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn fib
  [n]
  (if (< n 2)
    n
    (+ (fib (- n 1))
       (fib (- n 2)))))
