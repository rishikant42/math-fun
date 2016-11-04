main:
	lein uberjar

install: main
	cp target/uberjar/math-fun-0.1.0-SNAPSHOT-standalone.jar /usr/local/bin/
	cp math_completion /usr/local/etc/bash_completion.d/math
	chmod a+x math
	cp math /usr/local/bin/
	cp math.1 /usr/local/share/man/man1/
	gzip /usr/local/share/man/man1/math.1

uninstall:
	rm /usr/local/share/man/man1/math.1.gz
	rm /usr/local/bin/math
	rm /usr/local/bin/math-fun-0.1.0-SNAPSHOT-standalone.jar
	rm /usr/local/etc/bash_completion.d/math

package: main
	mkdir math-fun
	cp target/uberjar/math-fun-0.1.0-SNAPSHOT-standalone.jar ./math-fun
	cp math.1 math install.sh math_completion ./math-fun
	tar -czf 	math-0.1.tar.gz ./math-fun
	rm -rf math-fun
