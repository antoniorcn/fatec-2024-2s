rmdir build /S /Q

mkdir build

javac -d ./build ./src/edu/curso/*.java

java -cp ./build edu.curso.TesteDB