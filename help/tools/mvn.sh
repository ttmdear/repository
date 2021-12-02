# Tworzenie projektu
mvn archetype:generate -DgroupId=com.httpio.app -DartifactId=httpio -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn archetype:generate -DgroupId=learn.java -DartifactId=modules -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn archetype:generate -DgroupId=repo.java.concurrency.blockingqueu -DartifactId=java-concurrency-blockingqueu -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn archetype:generate -DgroupId=repo.java.enum -DartifactId=repo-java-enum-overwritemethod -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

## Run all the unit test classes.
$ mvn test

## Run a single test class.
$ mvn -Dtest=TestApp1 test

## Run multiple test classes.
$ mvn -Dtest=TestApp1,TestApp2 test

## Run a single test method from a test class.
$ mvn -Dtest=TestApp1#methodname test

## Run all test methods that match pattern 'testHello*' from a test class.
$ mvn -Dtest=TestApp1#testHello* test

## Run all test methods match pattern 'testHello*' and 'testMagic*' from a test class.
$ mvn -Dtest=TestApp1#testHello*+testMagic* test
