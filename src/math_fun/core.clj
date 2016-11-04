(ns math-fun.core
  (:require
    [math-fun.basic_math :refer [sqrt cube-root prime? fact exp sum mult div gcd avg fib]]
    [math-fun.nth_root :refer [nth-root]]
    [math-fun.fn_handler :refer :all]
    [math-fun.help :refer :all]
    [math-fun.complex_no :refer :all]
    ;; [math-fun.series_sum :refer :all]
    [clojure.tools.cli :refer [parse-opts]]
    )
  (:gen-class))

(defn display-complex
  [z]
  (println (list (first z) '+ (str (last z) "i"))))

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

        "series-sum"  (println (series-handler arg))

        "complex"  (let [[sub-command & sub-arg] arg]

                     (if (nil? sub-command) 
                       (error-msg "Give sub-command")

                       (case sub-command
                         "add" (display-complex (add-complex-handler sub-arg))

                         "subtract" (display-complex (sub-complex-handler sub-arg))

                         "multiply" (display-complex (mul-complex-handler sub-arg))

                         "divide" (display-complex (div-complex-handler sub-arg))

                         (error-msg "Unknown sub command"))))


        ("-h" "--help") (help)

        ("-v" "--version") (println "math 0.1")

        (error-msg "Unknown Command")))))
