(ns math-fun.fn_handler
  (:require
    [math-fun.basic_math :refer [sqrt cube-root prime? fact exp sum mult div gcd avg fib]]
    [math-fun.nth_root :refer [nth-root]]
    [math-fun.help :refer :all]
    [math-fun.series_sum :refer :all]
    [clojure.tools.cli :refer [parse-opts]]
    )
  )

(def common-cli-options
  [["-n" "--numbers NUMBERS"  :default false]])

(def exp-cli-options
  [["-b" "--base BASE"  :default false]
   ["-p" "--power POWER"  :default false]])

(def gcd-cli-options
  [["-a" "--number1 FIRST-NUMBER"  :default false]
   ["-b" "--number2 SECOND-NUMBER"  :default false]])

(def series-cli-options
  [["-s" "--start STARTING-NUMBER"  :default false]
   ["-e" "--end ENDING-NUMBER"  :default false]
   ["-p" "--exponent EXPONENT"  :default false]])

(def nth-cli-options
  [["-n" "--number NUMBER"  :default false]
   ["-r" "--root NTH-ROOT"  :default false]])

(defn arg-1-binding
  [arg]
  (let [{:keys [options arguments]} (parse-opts arg common-cli-options)
        {:keys [numbers]} options
        data (map read-string (cons numbers arguments))]
    data))

(defn exp-binding
  [arg]
  (let[{:keys [options]} (parse-opts arg exp-cli-options)
       {:keys [base power]} options
       base (read-string base)
       power (read-string power)]
    (list base power)))

(defn gcd-binding
  [arg]
  (let[{:keys [options]} (parse-opts arg gcd-cli-options)
       {:keys [number1 number2]} options
       number1 (read-string number1)
       number2 (read-string number2)]
    (list number1 number2)))

(defn series-binding
  [arg]
  (let[{:keys [options]} (parse-opts arg series-cli-options)
       {:keys [start end exponent]} options
       start (read-string start)
       end (read-string end)
       exponent (read-string exponent)]
    (list start end exponent)))

(defn nth-binding
  [arg]
  (let[{:keys [options]} (parse-opts arg nth-cli-options)
       {:keys [number root]} options
       number (read-string number)
       root (read-string root)]
    (list number root)))

(defn sum-handler
  [args]
  (try (let [data (arg-1-binding args)]
         (sum data))
    (catch ClassCastException e (missing-argument))))

(defn mult-handler
  [args]
  (try (let [data (arg-1-binding args)]
         (mult data))
    (catch ClassCastException e (missing-argument))))

(defn div-handler
  [args]
  (try (let [data (arg-1-binding args)]
         (div data))
    (catch ClassCastException e (missing-argument))))

(defn avg-handler
  [args]
  (try (let [data (arg-1-binding args)]
         (avg data))
    (catch ClassCastException e (missing-argument))))

(defn fib-handler
[args]
(try (let [data (arg-1-binding args)]
       (map fib data))
  (catch ClassCastException e (missing-argument))))

(defn fact-handler
  [args]
  (let [data (arg-1-binding args)]
    (map fact data)))

(defn sqrt-handler
  [args]
  (let [data (arg-1-binding args)]
    (map sqrt data)))

(defn cuberoot-handler
  [args]
  (let [data (arg-1-binding args)]
    (map cube-root data)))

(defn prime-handler
  [args]
  (let [data (arg-1-binding args)]
    (map prime? data)))

(defn exp-handler
  [args]
  (try (let [[base  power] (exp-binding args)]
    (exp base power))
    (catch ClassCastException e (missing-argument))
    (catch NumberFormatException e (.getMessage e))))    ;; $ lein run exp --base 3--power 4

(defn gcd-handler
  [args]
  (try (let [[number1 number2] (gcd-binding args)]
    (gcd number1 number2))
    (catch ClassCastException e (missing-argument))
    (catch NumberFormatException e (.getMessage e))))

(defn series-handler
  [args]
  (try (let [[start end exponent] (series-binding args)]
    (add exponent start inc end))
    (catch ClassCastException e (missing-argument))
    (catch NumberFormatException e (.getMessage e))))

(defn nth-handler
  [args]
  (try (let [[number root] (nth-binding args)]
    (nth-root number root))
    (catch ClassCastException e (missing-argument))
    (catch NumberFormatException e (.getMessage e))))
