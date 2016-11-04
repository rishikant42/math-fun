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

### Example:

##### Basic maths arithmetic

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
```

##### Factorial
n! = n * (n - 1) * (n - 2) ......... * 1

```
$ math factorial --numbers 1 2 3 
1
2
6
```

##### Exponential
n^m = n * n * n * n ....... m-times

```
$ math exp --base 2 --power 10
1024
```


##### To check given no is prime or not
```
$ math isprime --numbers 1 2 3 
false
true
true
```
##### 1 / nth-power

n ^ 1 / m = z ==> z^m = n

1024 ^ 1 / 10 = 2

```
$ math nth-root --number 1024 --root  10
2.000001183010332
```
##### Fibnocci number
fib(0) = 0                    

fib((1) = 1

fib(n) = fib(n-1) + fib(n-2)
```
$ math fibonacci --numbers 4 5 6
3
5
8
```
##### Greatest common divisor
```
$ math gcd --number1 104 --number2 20
4
```

##### Series sum
1^3 + 2^3 + 3^3 + 4^3 + 5^3 = 225
```
$ math series-sum --start 1 --end 5 --exponent 3
225
```

##### Complex arithmetic

z1 = 4 + 5i

z2 = 2 + 3i

z1 + z2 = 6 + 8i

z1 - z2 = 2 + 2i

z1 * z2 = -7 + 22i

z1 / z2 = 1.77 + -0.15i

```
$ lein run complex sum --real1 4 --imag1 5 --real2 2 --imag2 3
(6 + 8i)

$ lein run complex subtract --real1 4 --imag1 5 --real2 2 --imag2 3
(2 + 2i)

$ lein run complex multiply --real1 4 --imag1 5 --real2 2 --imag2 3
(-6.999999999999996 + 22.0i)

$ lein run complex divide --real1 4 --imag1 5 --real2 2 --imag2 3
(1.7692307692307692 + -0.15384615384615388i)
```
