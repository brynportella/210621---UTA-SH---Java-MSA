# Creational Design Patterns

Creational design patterns are meant to solve commonly occuring software development problems

# Singleton

Singleton is a design pattern which allows for the creation of an object only once in an application

-   This object is then shared across multiple classes
-   Useful from things like database conections, or othe services

# Factory Pattern

The factory pattern creates objects in which the precise type is not known until runtime

# Annotations

Annotations are special constructs in Java which use the @ symbol followed by the annotation

-   Annotations provide metadata about the source code to the compiler and the JVM

Annotations can be placed over classes, methods, interfaces, and other constructs

-   Some annotations have limitations of where, and what they can be used on

Annotations are often used by libraries to abstract functionality, or enforce some set of rules

-   Annotations are often processed by the Reflections API

Some examples:

-   @Override
-   @Deprecated
-   @SupressWarning
-   @FunctionalInterface

# Intro to TDD and Unit Testing

Test Driven Development (TDD) is the process of writing tests for your code, then implementing the code to pass those tests

-   This helps increase the code coverage

1. Write a unit test
2. Run the test (it will fail)
3. Write code to pass the test
4. Retest, until the test passes
5. Repeat the process

Unit Testing: is the testing of individual software components in isolation from the rest of the system

-   You are essentially testing individual methods to make sure they are functioning properly

It can also be known as white box testing:

-   testing method where the internal design is known to the tester

Unit testing can help find if/where something is going wrong with your code

-   This helps reduce debugging time, because you know where to look in your code for the issue
-   It also increases code coverage, because you should test each individual unit/module of your code
-   It increases confidence in changing and mantaining your code base

It is best practice to include both positive and negative test cases

To perform unit tests in Java we use a tool called JUnit

# JUnit and Mockito

JUnit is a Java framework for testing:

It uses annotations to create tests and setup testing environments

-   `@Test` - declares a method as a test method
-   `@BeforeClass` - declares a setup method that runs once before all other methods in the test class
-   `@Before` - declares a setup method that runs before every test method
-   `@After` - declares a tear-down method that runs after every test method
-   `@AfterClass` - declares a tear-down method that runs once after the entire test class

JUnit also has bultin functions to use in your testing methods to verify the state of the application

-   `assertTrue()`
-   `assertFalse()`
-   `assertEquals()`
-   `assertNotEquals()`
-   `assertThat()`

Mockito is a Java framework that allows us to mock the functionality of other methods

-   This allows for black box testing
    -   Where you don't need to know the functionality of a given item, you only care about the output
-   This is useful for testing methods that rely on other methods
-   You replace the dependency of the other methods with mocks and stubs

A stub is a fake class that comes with preprogrammed return values

A mock is a face class that can be examined after the test is finished, for it interacts with the class under the test

# Overview of Logging

Logging records events that occur during the execution of your program

-   They allow for developers to access information about applications which we do not have direct access
-   Without logs, developers would have no idea what went wrong when an application crashes

We will be using Log4j for logging

-   Log4j is a reliable, fast, and flexible logging framework for Java, supported by apache
-   It is commonly used to record application events, log granular debugging information, and write exceptions to files

Log4j allows us to use various logging levels, and configuarble thresholds that determine which messages will be recored in the applications log file

Log4j Logging Levels:

1. ALL => all levels
2. DEBUG => designates fine gained informational event that are most helpful to debuge a program
3. INFO => informational messsages that highlight the progress of the application at the coarse grained level
4. WARN => designates potentially harmful situations
5. ERROR => designates error events that might still allow the application to continue running
6. FATAL => servere errors, that presumably result in the application crashing
7. OFF => highest possible level, it is intended to turn off logging

# Extras

# ENUM's in Java

ENUM's were added to Java in Java 5

They are a special class used to define constants

You use them similarly to static variables eg. Type.VALUE

They can be used with control flow including if/else and switch statements

There are several helpful methods that come along with ENUM classes implicitly

-   .values() returns a list of the contant values, useful for loops
-   .toString() returns a string value of the given constant
-   .valueOf() returnds a string "value"/index of the given constant
