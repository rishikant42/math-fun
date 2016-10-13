(ns math-fun.core
  (:require
    ;; [math-fun.basic_math :refer :all]
    [math-fun.basic_math :refer [sqrt cube-root prime? fact exp sum mult div gcd avg]]
    [math-fun.nth_root :refer [nth-root]]
    [clojure.tools.cli :refer [parse-opts]]
    )
  (:gen-class))

(defn help
  []
  (println "Usage:
math sum --numbers <args>
math multiply --numbers <args>
math divide --numbers <args>
math factorial --numbers <args>
math square-root --numbers <arg>
math cube-root --numbers <args>
math isprime --numbers <args>
math average --numbers <args>
math gcd --number1 <arg> --number2 <arg>
math exp --base <arg> --power <arg>
math nth-root --number <arg> --root <arg>

options:
-h --help    show help
-v --version show version"))

(def common-cli-options
  [["-n" "--numbers NUMBERS"  :default false]])

(def exp-cli-options
  [["-b" "--base BASE"  :default false]
   ["-p" "--power POWER"  :default false]])

(def gcd-cli-options
  [["-a" "--number1 FIRST-NUMBER"  :default false]
   ["-b" "--number2 SECOND-NUMBER"  :default false]])

(def nth-cli-options
  [["-n" "--number NUMBER"  :default false]
   ["-r" "--root NTH-ROOT"  :default false]])

(defn missing-argument
  []
  (println "ERROR: Missing arguments") (help) (System/exit 1))

(defn error-msg
  [msg]
  (println "ERROR:" msg) (help) (System/exit 1))

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

(defn nth-handler
  [args]
  (try (let [[number root] (nth-binding args)]
    (nth-root number root))
    (catch ClassCastException e (missing-argument))
    (catch NumberFormatException e (.getMessage e))))

(defn -main
  [& args]
  (let [[command & arg] args]

    (if (nil? command) 
      (error-msg "Give command")

      (case command
        "sum" (println (sum-handler arg))
                
        "multiply" (println (mult-handler arg))

        "divide" (println (div-handler arg))

        "factorial" (try (apply println (fact-handler arg))
                      (catch ClassCastException e (missing-argument)))

        "square-root" (try (println (sqrt-handler arg))
                        (catch ClassCastException e (missing-argument)))

        "cube-root" (try (println (cuberoot-handler arg))
                      (catch ClassCastException e (missing-argument)))

        "exp" (println (exp-handler arg))

        "gcd" (println (gcd-handler arg))

        "average" (println (avg-handler arg))

        "nth-root" (println (nth-handler arg)) 
        
        "isprime" (try (println (prime-handler arg))
                    (catch ClassCastException e (missing-argument)))

        ("-h" "--help") (help)

        ("-v" "--version") (println "math 0.1")

        (error-msg "Unknown Command")))))
