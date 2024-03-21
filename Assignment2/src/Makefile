# Compiler and flags
JAVAC = javac
JFlags = -g

# Intepreter
JAVA = java
PY = python

# Remove default target location for compiled classes
.SUFFIXES .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $*.java

CLASSES = UserInterface.java KnowledgeBaseAVLTreeApp.java\
	KnowledgeBase.java KnowledgeBaseTree.java KnowledgeBaseTreeAVL.java\
	Entry.java

default: classes

classes: $(CLASSES:.java=.class)

run:
   $(JAVA) KnowledgeBaseAVLTreeApp.java

runExperiment:
   $(PY) experiment.py

clear:
   rm *.class
