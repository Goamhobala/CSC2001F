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

CLASSES = UserInterface.java\
		  KnowledgeBase.java KnowledgeBaseArray.java KnowledgeBaseBinarySearchTree.java\
	   	  Entry.java	

default: classes

classes: $(CLASSES:.java=.class)

# moveClass:
# 	mv *.class ./bin

run: 
	$(JAVA) $(MAIN)

clear: 
	rm *.class

