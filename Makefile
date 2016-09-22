make:
	javac src/lib/listProcessor/ListData.java
	javac src/lib/listProcessor/InputList.java
	javac Example.java
	java Example
	rm -rf *.class