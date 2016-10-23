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
```
