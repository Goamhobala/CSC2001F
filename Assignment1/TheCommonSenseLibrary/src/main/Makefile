# compiler and flags
JAVAC = javac
JFLAGS = -g

# intepreter and flags
JAVA = java
# JVMFLAGS = -cp ./lib/javafx-sdk-17.0.10/lib/*

MAIN = UserInterFaceApp.java


# Remove default target location for compiled classes
.SUFFIXES: .java .class

.java.class: 
	$(JAVAC) $(JFLAGS) $*.java

CLASSES = $(MAIN).java

default: classes

classes: $(CLASSES:.java=.class)

run: 
	$(JAVA) $(MAIN)

clean:
	rm *.class

