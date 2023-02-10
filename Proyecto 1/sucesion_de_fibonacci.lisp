;pedir un dato, cuantas veces se repetirá la sucesion
(print "ingrese un número")
(setq n (read))
(print "")
(print "numero original")
(setq b 1)
(print b)
(print "numero ingresado")
(print n)
(print "")
;ciclo que suma
(setq c 0)
(setq a 0)
(loop :repeat n :do (print b) (setq c(+ a b)) (setq a (+ b)) (setq b (+ c)) )