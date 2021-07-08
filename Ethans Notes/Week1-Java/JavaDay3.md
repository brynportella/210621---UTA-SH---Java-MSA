# POJO vs Bean

A POJO is a Plain Old Java Object

-   We have been creating these all week

A Java Bean is Special POJO with specific rules

-   All Java Beans are POJO's, however not all POJO's are Beans
-   They must be serializable, i.e. implement the Serializable interface
-   All fields should be private
-   There should be a no-args constructor
-   Fields are only accessed by constructors or getters/setters

# Serialization

Serialization is the process of writing the state of an object to a byte stream, the reverse is called deserialization

-   In order for an object to be serialized, it must implement the Serializable interface

Marker Interfaces:

-   An interface with no methods, its purpose is to provide metadata to the compiler
-   Serializable is a marker, that tells the compiler we can write the state of the object to a file

# File I/O

"I/O" refers to how data is accessed, either via reading or writing. In Java I/O objects fall into two categories

-   Streams: reading or writing bytes
-   Reader/Writer: reading or writing individual characters

Common File I/O classes:

-   FileInputStream - reads raw bytes from a file
-   FileOutStream - writes raw bytes to a file
-   FileReader - reads characters from a file
-   FileWriter - writes characters to a file
-   BufferedReader - reads a file line by line, needs an instance of a FileReader with a path to the resource to be read
-   BufferedWriter - writes to a file line by line, needs an instance of a FileWriter with a path to the resource to be written
-   Scanner - can read from InputStream, useful for character reading

Character files are read line by line, the new lines are indicated by a new line character (\n) or a carraige return (\r)

You always want to close your resources when you are done reading/writing

The way you serialize data, is with a FileOutputStream, and an ObjectOutputStream

The way you deserialize is with a FileInputStream, and an ObjectInputStream

# Scanner

The scanner class can be used to read user input from the command line

# Try with resources

Java 7 implemented a new use for the try catch block, try with resources, it allows you to add a resource to the try block, and java will automatically close the resource for you when you are finished with it

The only catch, is that the object you are trying to use try with resources with, must implement the AutoCloseable interface

# Threads and Concurency

Concurency refers to breaking up a task into different parts that can be executed independent of one another, in any order, without affecting the final outcome

Example of this is an operating system, you can run multiple programs at the same time

Multi-core processing, is common in most modern day CPU's. This allows the CPU to physically run different applications on different cores, allowing for true parallelization, which is the key benefit of threads

Threads:

A thread is a subset of a process that is also a independent sequence of execution

-   Threads of the main process will run in the same memory space, but they are managed by the scheduler

Every thread has its own call stack where it stores local variable references, but since they share the same heap memory multiple threads can access the same objects in memory

Mulit-threading is the idea of using multiple threads in applications to achieve parallelism

-   Each thread can perform its own task increasing effiency

In Java we achieve multi-threading with the Thread class or the Runnable interface

In general it is best practice to not attempt to implement multi-threading yourself, because it can lead to issues we will speak about soon

-   You are encouraged to use frameworks and api's to implement this for you

# States of Threads

Threads follow a lifecycle with six different states

1. New: newly created thread that has not started executing
2. Runnable: either running, or it waiting to be executed due to resource allocation
3. Blocked: waiting to acquire a monitor lock to enter or re-enter a synchronized block/method
4. Waiting: waiting for some other thread to perform an action, this has no time limit
5. Timed Waiting: waiting for some other thread to perform an action for a specified amount of time
6. Terminated: the thread has finished execution

![Thread lifecycle](https://www.javatpoint.com/images/thread-life-cycle.png)

Threads have priorities which signify which order they should run. The thread class contains a few static variables for priority

-   MIN_PRIORITY = 1
-   NORM_PRIORITY = 5
-   MAX_PRIORITY = 10

# Custom Threads

You can create your own custom threads in one of two ways:

# Thread Class

By creating a thread through the thread class, you will grant the class access to the thread classes methods

-   getters and setters for id, name, and priority
-   interrupt to explicitly interupt the thread
-   isAlive, isTerminated, isDaemon, to test the state of the thread
-   join to wait for the thread to finish executing
-   start which will actually start the logic of the thread

To create a thread this way:

1. Create a class that extends Thread
2. Implement the run() method
3. Use the custom thread with .start() method

# Runnable interface

Creating a thread with the implementing Runnable way, will give you freedom to extend a different class of your choosing

To create a thread this way:

1. Create a class that implements Runnable
2. Implement the run() method
3. To use it you must create a generic thread object, and pass your custom runnable class into the constructor

# Thread Problems

There are issues that can occur if you try to implement multi-threading yourself. One of these is Deadlock

Deadlock occurs when two or more threads are blocked trying to access the same resource, they are essentially waiting on one another. Neither thread can continue execution, so the program halts indefinitely. This is where Synchronization comes in.

Synchronization is the capability to control the access of multiple threads to any shared resource

To do this we use the synchronized keyword. The synchronized keyword enforces that only one thread can access the resource at a given time

Another problem with multi-threaded programs is called the producer consumer problem

# Producer and Consumer Problem

In this problem we have a fixed sized buffer that is shared between the producer and the consumer

-   The producer adds to the buffer
-   The consumer takes from the buffer

The problem is that the data should only be added if the buffer is not full, and data should not be consumed if the buffer is not empty

To solve this issue we can use the synchronized keyword, as well as the .wait() and .notify() methods to communicate across threads

-   .wait() can pause the consumer depending on the amount of data in the buffer
-   .nofity() can send a notifaction to either thread when they can access the buffer

# Java 8 Features

Java 8 implemented many new useful features including:

-   Functional Interfaces
-   Lambda Expressions
-   Stream API
-   Reflections API
-   Date and Time API
-   Optional Class
-   Predicates

# Functional Interfaces

Functional interfaces are interfaces with only one abstract method

These are what lambda expressions are implementing when they are used

You can also explicitly make functional interfaces with lambdas

# Lambdas

Lambdas are possibly the biggest addition to Java 8, they introduce imporant aspects of functional programming

They essentially allow for disembodied methods, aka functions

The basic syntax is parameter(s) -> expression

For multiple parameters the parenthesis are required, for multiple lines of logic in the expression curly are required

The return keyword is optional for single expression lamdas

# Stream API

The Stream API is a functional-style of defining operations on a stream of elements

-   Streams are an abstraction which allow defining operations which do not modify the data source, and are lazily loaded

Streams do not store data, they simply operate on the data, like filtering, mapping, or reducing

Streams are divied into two types:

-   Intermediate, return a new stream and are always lazily loaded, they don't execute until the terminal operation is called
-   Terminal, trigger the execution of the stream pipeline, which allows effiency by performing all operations in a single pass over the data

Reduction operations takes a sequence of elements and combine them into a single result

-   .reduce() and .collect() are implemted by many Stream classes for this purpose

Example:

```java
List<Student> students = new ArrayList<>();
// add students...
List<Double> grades = students.stream()
                          .filter(s -> s.isAttending())
						  .mapToDouble(s -> s.getGrade)
						  .collect(Collectors.toList());
```

Reflections API:

Allows you to modify the behavior of methods and classes at runtime

The required classes are provided under the java.lang.reflect

Gives up information about the class, including method names, method return types, and even which annotations are in the class

-   This is typically used in Frameworks, and in JUnit to detect the @Test annotation

Optional Class:

The optional class was introduced to reduce the need for excessive null value checking

An Optional is a wrapper object which may or may not contain a value, with a few helper methods

They are a useful replacement for null values when returning an empty response from a method

```java
public class OptionalExample {
  public Optional<String> getAmbiguousString(boolean b) {
    if (true) {
	  return Optional.of("awesome string!");
	} else {
	  return Optional.empty();
	}
  }

  public static void main(String[] args) {
    Optional<String> optString = getAmbiguousString(false);
	String theString = optString.orElse(""); // specify a fallback value
	System.out.println(theString);
	// we can use the String without fear of NullPointerException now
  }
}
```

Date and Time API:

Before Java 8, Dates and Times were separate, represented by the java.util.Date and java.util.Calendar, and there were issues with these classes

In Java 8, they introduced a new API through the java.time package

-   LocalDate - only contains date information
-   LocalTime - only contains time information
-   LocalDateTime - which contains Date and time information
-   ZonedDateTime - for working with timezones
-   Period - represents some quantity of time (years, months, days)
-   Duration - represents some quanity of time (seconds, nanoseconds)
-   DateTimeFormatter - for representing dates/times in a give format

Predicate:

A predicate is a functional interface that returns a boolean
