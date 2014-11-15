JFLAGS = -g
JC = javac
JARPATH = lib/*
MAIN = ccs.neu.edu.andang.JPAExample
CP = -classpath

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) -classpath "${CLASSPATH}:lib/*" $*.java

CLASSES = \
        ./ccs/neu/edu/andang/JPAExample.java


default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) ./ccs/neu/edu/andang/*.class

run: $(CLASSES)
	sudo java $(CP) .:$(JARPATH) $(MAIN)

