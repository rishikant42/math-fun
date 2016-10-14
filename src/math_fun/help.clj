(ns math-fun.help)

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
math fibonacci  --numbers <args>
math gcd --number1 <arg> --number2 <arg>
math exp --base <arg> --power <arg>
math nth-root --number <arg> --root <arg>

options:
-h --help    show help
-v --version show version"))

(defn missing-argument
  []
  (println "ERROR: Missing arguments") (help) (System/exit 1))

(defn error-msg
  [msg]
  (println "ERROR:" msg) (help) (System/exit 1))
