(ns math-fun.core-test
  (:require [clojure.test :refer :all]
            [math-fun.basic_math :refer [sqrt cube-root prime? fact exp sum mult div gcd avg fib]]
            [math-fun.series_sum :refer :all]
            [math-fun.core :refer :all]))

(deftest exp-test
  (testing "exponential procedure"
    (is (= (exp 2 5) 32))))

(deftest gcd-test
  (testing "gcd procedure"
    (is (= (gcd 104 20) 4))))

(deftest isprime-test
  (testing "isprime procedure"
    (is (= (prime? 1) false))))

(deftest multiple-test
  (testing "square root procedure"
    (is (= (sqrt 5) 2.2360688956433634)))
  (testing "cube root procedure"
    (is (= (cube-root 5) 1.7099768958229076)))
  (testing "factorial procedure"
    (is (= (fact 5) 120)))
  (testing "sum procedure"
    (is (= (sum '(1 2 3)) 6)))
  (testing "multiply procedure"
    (is (= (mult '(1 2 3)) 6)))
  (testing "division procedure"
    (is (= (div '(1 2 3)) (/ 1 6))))
  (testing "average procedure"
    (is (= (avg '(1 2 3)) 2.0)))
  (testing "fibnocci procedure"
    (is (= (fib 5) 5))))


(deftest series-test
  (testing "series sum procedure"
    (is (= (add 3 1 inc 5) 225))))
