(ns math-fun.complex_no)

(defn make-from-real-imag
  [x y]
  (list x y))

(defn make-from-mag-ang
  [r a]
  (list (* r (Math/cos a)) (* r (Math/sin a))))

(defn square [x] (* x x))

(defn real-part
  [z]
  (first z))

(defn imag-part
  [z]
  (last z))

(defn magnitude
  [z]
  (Math/sqrt (+ (square (real-part z)) (square (imag-part z)))))

(defn angle
  [z]
  (Math/atan (/ (imag-part z) (real-part z))))

(defn add-complex
  [z1 z2]
  (make-from-real-imag (+ (real-part z1) (real-part z2))
                       (+ (imag-part z1) (imag-part z2))))
(defn sub-complex
  [z1 z2]
  (make-from-real-imag (- (real-part z1) (real-part z2))
                       (- (imag-part z1) (imag-part z2))))

(defn mul-complex
  [z1 z2]
  (make-from-mag-ang (* (magnitude z1) (magnitude z2))
                     (+ (angle z1) (angle z2))))

(defn div-complex
  [z1 z2]
  (make-from-mag-ang (/ (magnitude z1) (magnitude z2))
                     (- (angle z1) (angle z2))))
