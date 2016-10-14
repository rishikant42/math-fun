(ns math-fun.core
  (:require
    [math-fun.basic_math :refer [sqrt cube-root prime? fact exp sum mult div gcd avg fib]]
    [math-fun.nth_root :refer [nth-root]]
    [math-fun.fn_handler :refer :all]
    [math-fun.help :refer :all]
    [clojure.tools.cli :refer [parse-opts]]
    )
  (:gen-class))

(defn print-linewise
  [args]
  (doseq [item args]
    (println item)))

(defn -main
  [& args]
  (let [[command & arg] args]

    (if (nil? command) 
      (error-msg "Give command")

      (case command
        "sum" (println (sum-handler arg))
                
        "multiply" (println (mult-handler arg))

        "divide" (println (div-handler arg))

        "factorial" (try (print-linewise (fact-handler arg))
                      (catch ClassCastException e (missing-argument)))

        "square-root" (try (print-linewise (sqrt-handler arg))
                        (catch ClassCastException e (missing-argument)))

        "cube-root" (try (print-linewise (cuberoot-handler arg))
                      (catch ClassCastException e (missing-argument)))

        "exp" (println (exp-handler arg))

        "gcd" (println (gcd-handler arg))

        "average" (println (avg-handler arg))

        "fibonacci" (print-linewise (fib-handler arg))

        "nth-root" (println (nth-handler arg)) 
        
        "isprime" (try (print-linewise (prime-handler arg))
                    (catch ClassCastException e (missing-argument)))

        ("-h" "--help") (help)

        ("-v" "--version") (println "math 0.1")

        (error-msg "Unknown Command")))))
