(defun ConvertirCAF()
    (print "Ingrese la temp")
    (setq tempC read)
    (setq tempF  (+ (/ (* 9.0 tempC) 5.0) 32))
    (print "La temperatura en Farenheit es:")
    (print tempF)
)
    

(ConvertirCAF)