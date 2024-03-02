# compiler and flags
JAVAC = javac
JFLAGS = -g

# intepreter and flags
JAVA = java
# JVMFLAGS = -cp ./lib/javafx-sdk-17.0.10/lib/*

MAIN = UserInterface.java


# Remove default target location for compiled classes
.SUFFIXES: .java .class

.java.class: 
	$(JAVAC) $(JFLAGS) $*.java

CLASSES = UserInterface.java

default: classes

classes: $(CLASSES:.java=.class)

run: 
	$(JAVA) $(MAIN)

