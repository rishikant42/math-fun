(ns math-fun.core
  (:require
    [math-fun.basic_math :refer :all]
    [clojure.tools.cli :refer [parse-opts]]
    )
  (:gen-class))

(defn help
  []
  (println "Usage:
math sum <args>
math multiply <args>
math factorial <arg>
math square-root <arg>
math cube-root <arg>
math exp <args>

options:
-h --help    show help
-v --version show version"))

(def common-cli-options
  [["-n" "--numbers NUMBERS"  :default false]])

(def exp-cli-options
  [["-b" "--base BASE"  :default false]
   ["-p" "--power POWER"  :default false]])

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

(defn arg-2-binding
  [arg]
  (let[{:keys [options]} (parse-opts arg exp-cli-options)
       {:keys [base power]} options
       base (read-string base)
       power (read-string power)]
    (list base power)))

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
  (try (let [[base  power] (arg-2-binding args)]
    (exp base power))
    (catch ClassCastException e (missing-argument))
    (catch NumberFormatException e (.getMessage e))))    ;; $ lein run exp --base 3--power 4


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

        "exp" (println (exp-handler args))

        "isprime" (try (println (prime-handler arg))
                    (catch ClassCastException e (missing-argument)))

        ("-h" "--help") (help)

        ("-v" "--version") (println "math 0.1")

        (error-msg "Unknown Command")))))
