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
        PhysicsElement.java \
        PhysicsLab.java 
		
MAIN = PhysicsLab

default: classes

classes: $(CLASSES:.java=.class)

run: 
	@read -p "Ingrese delta: " TDELTA; \
        read -p "Ingrese tiempo a simular: " TTOTAL; \
        read -p "Ingrese tiempo entre escrituras en la salida del estado del sistema: " TMUESTREO; \	
	$(MAIN) $$TDELTA $$TTOTAL $$TMUESTREO

clean:
	$(RM) *.class
