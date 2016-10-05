(ns math-fun.is_prime)

(defn sqr [x] (* x x))

(defn divides?    ;; is "a" divided by "b"
  [a b]
  (= (mod a b) 0))

(defn find-divisor
  [n test-divisor]
  (cond (> (sqr test-divisor) n) n
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
