FILES=(
	../src/almonds/DeleteCallback.java
	../src/almonds/FindCallback.java
	../src/almonds/GetCallback.java
	../src/almonds/Parse.java
	../src/almonds/ParseException.java
	../src/almonds/ParseObject.java
	../src/almonds/ParsePointer.java
	../src/almonds/ParseQuery.java
	../src/almonds/ParseResponse.java
	../src/almonds/SaveCallback.java
);

javac -classpath :../libs/json.jar:../libs/httpcore-4.1.4.jar:../libs/httpclient-4.1.3.jar:../libs/commons-logging-1.1.1.jar -d ../bin/ ${FILES[*]}
