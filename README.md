This is a skeleton for BoofCV based vision projects. Provides a Gradle script to build and a "Hello World" example.
The build script will download all dependencies automatically.

Recommendations:
- IntelliJ for IDE
- Linux, Windows, or OSX
- Java Development Kit (JDK) version 11 or newer should work

Useful Commands
- './gradlew assemble' to compile the project
- './gradlew HelloWorldJar' to create the HelloWorld jar
- 'java -jar HelloWorld.jar' to launch the jar. Provided so that you can test without an IDE.

# IntelliJ Tips

* Load project as a Gradle project
* Use the project's Gradle Wrapper. That way you know you have a compatible version.
* To speed up building and running tests:
  * File -> Settings
  * Search for Gradle
  * Change "Build and Run Using" from Gradle to IntelliJ
  * Same for "Run Tests Using"
* To run a class from the GUI right click it then select run
