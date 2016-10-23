#!/bin/bash
cp math-fun-0.1.0-SNAPSHOT-standalone.jar /usr/local/bin/
cp math_completion /usr/local/etc/bash_completion.d/math
chmod a+x math
cp math /usr/local/bin/
cp math.1 /usr/local/share/man/man1/
gzip /usr/local/share/man/man1/math.1
echo "math successfully installed"
