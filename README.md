#MATH-FUN

`math` command line tool for mathematical calculation.

Install instructions for lein users:

```
$ git clone https://github.com/rishikant42/math-fun
$ cd math-fun
$ make
$ make install
```

Uninstall instruction:

```
$ make uninstall
```
Install instructions for non-lein users:

Download tar-file: https://github.com/rishikant42/math-fun/blob/master/math-0.1.tar.gz

```
$ tar -xzf math-0.1.tar.gz
$ cd math-fun
$ chmod a+x install.sh
$ ./install.sh
```

Example

```
$ math sum --numbers  1 2 3 4 5
15

$ math multiply --numbers 1 2 3 4 5
120

$ math divide --numbers 1 2 3.0
0.16666666666666666

$ math square-root --numbers 1 2 3
1.0
1.4142156862745097
1.7320508100147274

$ math cube-root --numbers 1 2 3
1.0
1.259919956636514
1.4422484562392204

$ math factorial --numbers 1 2 3 
1
2
6

$ math exp --base 2 --power 10
1024

$ math isprime --numbers 1 2 3 
false
true
true

$ math nth-root --number 1024 --root  10
2.000001183010332

$ math fibonacci --numbers 4 5 6
3
5
8

$ math gcd --number1 104 --number2 20
4

$ math series-sum --start 1 --end 5 --exponent 3
225

$ lein run complex sum --real1 4 --imag1 5 --real2 2 --imag2 3
(6 + 8i)

$ lein run complex subtract --real1 4 --imag1 5 --real2 2 --imag2 3
(2 + 2i)

$ lein run complex multiply --real1 4 --imag1 5 --real2 2 --imag2 3
(-6.999999999999996 + 22.0i)

rishi@rishi-Vostro-3558:~/math-fun$ lein run complex divide --real1 4 --imag1 5 --real2 2 --imag2 3
(1.7692307692307692 + -0.15384615384615388i)
```
