#lang racket
(require math/number-theory)

(define (lolmap fn lol)
  (cond ((empty? lol) empty)
        ((cons? lol) (let ((li (first lol)))
                       (cond ((empty? li) (lolmap fn (rest lol)))
                             ((cons? li) (cons (fn (first li))
                                               (lolmap fn (cons (rest li) (rest lol))))))))))

(define (make-maybe-harshad num)
  (let ((num (* num 10)))
    (lambda (x) (+ x num))))

(define (digisum n)
  (cond ((< n 10) n)
        (else (+ (remainder n 10)
                 (digisum (quotient n 10))))))

(define (rt-harshads digits seed)
  (cond ((< digits 2) seed)
        (else (append seed 
                      (rt-harshads (- digits 1)
                                   (lolmap (lambda (num) 
                                             (filter (lambda (num)
                                                       (equal? (remainder num (digisum num)) 0))
                                                     (map (make-maybe-harshad num) (range 0 10)))) seed))))))

(define (problem x)
  (apply + (filter (lambda (each) (< each (expt 10 x)))
                   (lolmap (lambda (x) x) (map (lambda (num)
                                                 (filter prime? (map (make-maybe-harshad num) (range 0 10))))
                                               (filter (lambda (each)
                                                         (prime? (quotient each (digisum each))))
                                                       (lolmap (lambda (x) x) (rt-harshads x (map list (range 1 10))))))))))

(problem 14)
