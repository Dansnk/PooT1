.PHONY:run
JFLAGS = -g
JC = javac
JVM= java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Ball.java \
        MyWorld.java \
        PhysicsElement.java \
	Spring.java \
	FixedHook.java \
	SpringAttachable.java \
        PhysicsLab.java 

MAIN = PhysicsLab

default: classes

classes: $(CLASSES:.java=.class)

run:	
	@read -p "Ingrese delta: " DELTA; \ 
	read -p "Ingrese tiempo a simular: " TOTAL; \ 
	read -p "Ingrese tiempo de muestreo: " SAMPLING; \ 
	javac PhysicsLab
	java PhysicsLab $$DELTA $$TOTAL $$SAMPLING
clean:
	$(RM) *.class
