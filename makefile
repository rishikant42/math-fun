main:
	lein uberjar

install: main
	cp target/uberjar/math-fun-0.1.0-SNAPSHOT-standalone.jar /usr/local/bin/
	chmod a+x math
	cp math /usr/local/bin/

uninstall:
	rm /usr/local/bin/math
	rm /usr/local/bin/math-fun-0.1.0-SNAPSHOT-standalone.jar
