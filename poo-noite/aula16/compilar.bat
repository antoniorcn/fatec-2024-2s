rmdir build /S /Q

mkdir build

javac -cp .;./src;./lib/mariadb-java-client-3.5.1.jar -d ./build ./src/edu/curso/*.java

java -cp .;./build;./lib/mariadb-java-client-3.5.1.jar %1
