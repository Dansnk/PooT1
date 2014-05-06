JFLAGS = -g
JC = javac
JVM = java
FILE = salida.csv
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Ball.java \
        MyWorld.java \
	Spring.java \
        PhysicsElement.java \
        PhysicsLab.java 
		
MAIN = PhysicsLab

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:
	$(RM) *.class
