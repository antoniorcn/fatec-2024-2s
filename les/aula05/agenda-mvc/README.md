gradle-war
=================

The intent of gradle-war is to build out a skeleton Gradle based WAR project
leveraging Servlet 3.1, Gradle and SLF4J on Logback.

To build the project execute the gradle wrapper ```gradlew``` on *nix,
```gradlew.bat``` on Windows.  The default tasks are 'clean', 'build'.

```
$ ./gradlew
:clean
:compileJava
:processResources
...
BUILD SUCCESSFUL

Total time: 12.764 secs
```