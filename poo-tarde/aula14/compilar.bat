rmdir /S /Q ".\build\"
mkdir build
javac -d ./build -cp .;./lib/mariadb-java-client-3.5.0.jar ./src/edu/curso/*.java
java -cp .;./build;./lib/mariadb-java-client-3.5.0.jar edu.curso.TesteDB filldb