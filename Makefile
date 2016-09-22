make:
	rm -rf *.class
	javac src/lib/inputList/ListData.java
	javac src/lib/inputList/InputList.java
	javac Example.java
	java Example
	rm -rf *.class