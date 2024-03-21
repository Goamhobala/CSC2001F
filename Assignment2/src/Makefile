# Compiler and flags
JAVAC = javac
JFlags = -g

# Intepreter
JAVA = java
PY = python

# Remove default target location for compiled classes
.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $*.java

CLASSES = UserInterface.java UIApp.java AutomatedApp.java KnowledgeBaseAppActions.java \
	KnowledgeBase.java KnowledgeBaseTree.java KnowledgeBaseAVLTree.java \
	Entry.java\

default: classes

classes: $(CLASSES:.java=.class)

SOURCE ?= "../data/GenericsKB.txt"

QUERY ?= "../data/GenericsKB-queries.txt"

run:
	$(JAVA) AutomatedApp.java $(SOURCE) $(QUERY)

runUI:
	$(JAVA) UIApp.java

runExperiment:
	$(PY) experiment.py

clear:
	rm *.class
