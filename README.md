maven-java-template
===================

This is the base for all standard standalone java based application.

How to use ?
=====================

- Clone this repository.
- Change the artifactId in your pom.xml with the project name.
- Run mvn test, you should get "BUILD SUCCESS".
- Import the project to eclipse 
*    File -> Import -> Maven -> Existing Maven Project)
- Add all your packages and class files into directory 
*    src/main/java
- Add the source code for test into 
-    src/test/java
- To run any specific goal from eclipse. 
-    {project} -> Right click -> Run As -> Maven Build -> <Provide the goal you need to run>
- To execute the application directly from eclipse, specify the goal value as
-    compile exec:java -Dexec.mainClass="com.example.Class"
