gradle-war
=================

The intent of gradle-war is to build out a skeleton Gradle based WAR project
leveraging Servlet 3.1, Gradle, TestNG, and SLF4J on Logback.

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

To run the WAR through the Gretty plug-in:

```
$ ./gradlew appRun
:prepareInplaceWebAppFolder UP-TO-DATE
:createInplaceWebAppFolder UP-TO-DATE
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:prepareInplaceWebAppClasses UP-TO-DATE
:prepareInplaceWebApp UP-TO-DATE
:appRun
14:00:30 INFO  Jetty 9.2.22.v20170606 started and listening on port 8080
14:00:30 INFO  gradle-war runs at:
14:00:30 INFO    http://localhost:8080/gradle-war
Press any key to stop the server.
```
