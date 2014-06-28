maven-java-template
===================

This is the base for all standard standalone java based application.

How to use ?
=====================

1. Clone this repository.
2. Change the artifactId in your pom.xml with the project name.
3. Run mvn test, you should get "BUILD SUCCESS".
4. Import the project to eclipse 
... File -> Import -> Maven -> Existing Maven Project)
5. Add all your packages and class files into directory 
..*    src/main/java
6. Add the source code for test into 
..*    src/test/java
7. To run any specific goal from eclipse. 
..*    {project} -> Right click -> Run As -> Maven Build -> <Provide the goal you need to run>
8. To execute the application directly from eclipse, specify the goal value as
..*    compile exec:java -Dexec.mainClass="com.example.Class"
