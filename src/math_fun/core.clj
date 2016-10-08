(ns math-fun.core
  (:require
    ;; [math-fun.sqrt :refer [sqrt]]
    ;; [math-fun.cube_root :refer [cube-root]]
    ;; [math-fun.is_prime :refer [prime?]]
    [math-fun.basic_math :refer [sqrt cube-root prime?]]
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
  [["-n" "--number NUMBER"  :default false]])

(def exp-cli-options
  [["-b" "--base BASE"  :default false]
   ["-p" "--power POWER"  :default false]])

(defn missing-argument
  []
  (println "ERROR: Missing arguments") (help) (System/exit 1))

(defn error-msg
  [msg]
  (println "ERROR:" msg) (help) (System/exit 1))

(defn sum
  [args]
  (reduce + args))

(defn mult
  [args]
  (reduce * args))

(defn div
  [args]
  (reduce / args))

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

(defn -main
  [& args]
  (let [[command & arg] args]

    (cond (nil? command) (error-msg "Give command")

          (and (not= command "-h") (not= command "--help") 
               (not= command "-v") (not= command "--version") 
               (empty? arg)) (error-msg "pass arguments value")

          :else

          (case command
            "sum" (println (sum arg))

            "multiply" (let [{:keys [arguments]} (parse-opts arg [])
                             arg (map read-string arguments)
                             ]
                         (println (mult arg)))

            ;; "factorial" (let [{:keys [number]} (get (parse-opts arg fact-cli-options) :options)]
            ;;               (println (fact (read-string number))))

            "factorial" (let [{:keys [options arguments]} (parse-opts arg common-cli-options)
                              {:keys [number]} options
                              data (map read-string (cons number arguments))]
                          (apply println (map fact data)))

            "divide" (let [{:keys [options arguments]} (parse-opts arg common-cli-options)
                              {:keys [number]} options
                              data (map read-string (cons number arguments))
                              ]
                       (println (div data)))

            "square-root" (let [{:keys [options arguments]} (parse-opts arg common-cli-options)
                                {:keys [number]} options
                                data (map read-string (cons number arguments))]
                            (println (map sqrt data)))

            "cube-root" (let [{:keys [options arguments]} (parse-opts arg common-cli-options)
                                {:keys [number]} options
                                data (map read-string (cons number arguments))]
                            (println (map cube-root data)))

            "exp" (let [{:keys [options]} (parse-opts arg exp-cli-options)
                                {:keys [base power]} options
                                base (read-string base)
                                power (read-string power)]
                            (println (exp base power)))

            "isprime" (let [{:keys [options arguments]} (parse-opts arg common-cli-options)
                                {:keys [number]} options
                                data (map read-string (cons number arguments))]
                            (println (map prime? data)))

            ("-h" "--help") (help)

            ("-v" "--version") (println "math 0.1")

            (error-msg "Unknown Command")
            ))))
