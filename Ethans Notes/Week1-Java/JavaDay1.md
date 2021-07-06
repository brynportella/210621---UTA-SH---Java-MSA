# Intro to Java

What is Java and why do we use it?

Java is:

- high-leveled
    - Easy to read syntax, auto mem management, garbage
- compiled
    - The program gets converted or "compiled" into machine code, aka Byte Code
- strongly typed
    - We must declare our variables type, and cannot reassign them
    - The type is assigned at runtime
- object oriented
    - The language has constructs of classes and objects built in

The advantages of Java

- Java is platform independent, you can write once run anywhere
- It has widely populare API's and countless libraries
- It is Object Oriented
- It has a simple to learn syntax, this is based on the C language
- Its free, and suported Oracle
- Has automatic mem management and garbage

# JDK, JRE, JVM

Java Development Kit (JDK):

- This contains the JRE
    - Debugger
    - Devtools
    - Compiler

Java Runtime Environment (JRE):
- This contains the JVM, and all neccessary libraries to run Java code
    - The bare minimum

Java Virtual Machine (JVM):

- This is specific to your OS
- Converts Byte Code into machine code for you specific OS/Hardware
- It includs the Classloader
- Runtime data area
- Execution, the heap and stack

# Introduction to Maven

Maven is a dependency manager and build automation tool for Java programs

Maven project configurationa and dependencies are handled in the Project Object Model, or the pom.xml

Project Coordinates, these are how Maven Identifies a project, these are stored in the pom.xml

These include:

-   group-id : for example "com.example"
-   artifact-id : for example "myproject"
-   version : for example "0.0.1-SNAPSHOT"
-   These uniquely identify a specific version of a program

Project Object Model (pom.xml):

- Contains information about the project used to builf the project, this includes dependencies and plugins
- Some important tags:
-   <project> - this is the root tag of the file
    -   <modelVersion> - defining which version of the page object model to be used
    -   <name> - name of the project
    -   <properties> - project-specific settings
    -   <dependencies> - this is where you put your Java dependencies you want to use. Each one needs a <dependency>, which has:
        -   <groupId>
        -   <artifactId>
        -   <version>
    -   <plugins> - for 3rd party plugins that work with Maven

# Maven Repositories

When Maven builds a project, it must search for any dependencies declared in the pom.xml

These are stored locally, and in a central repository

- Locally Maven stores these dependencies at $HOME/.m2/repository
- The cental repository is accessible at https://mvnrepository.com

If Maven cannot find a depenency locally, it will grab it from the central repository

# Maven Lifecycle

When Maven builds a project, it takes takes all the source code, and dependencies and compiles and bundles it into an artifact,
- These can be .jar, .war, .ear
- These can be run directly on your computer, or on a server

There are three built in life cycles for Maven:
- Default: handles project deployment
- Clean: handles project cleaning
- Site: handles the creating of our project documentation

When Maven builds your project, it goes through several steps called **phases**. The default mave lifecycle goes through the following:

1. Validates => project is correct and all necessary information is available
2. Compile => compiles the source code
3. Test => runs all tests
4. Package => packages all compiled code into Jar or War
5. Integration => performs any integration tests on Jar/War
6. Verify => runs checks on the results of the integration tests
7. Install => install the War/Jar to the local repository
8. Deploy => copies the final War/Jar to the remote repositry

# Class vs Object

## Objects in Java

An object is a virtualization of a real world object

There are instances of a Class
- They have state, behaviors, and identity
- properties, methods, names

## Classes in Java

A class is blue print for an object

It will contain all of the properties and methods the object will have

### Modularization

Writing code that is available/resusable in different places

Classes/Objects create modules of code that we can resuse places

This allows us to reduce the complexity of our code

Modularization reducers the complexity of our code

# Methods and Parameters

Methods are blocks of code which only run when called
- These are essentially functions attached to objects
- These are declared inside of classes, they must have a return type, a name, and a parameter list followed by curly braces

Parameters are specified inside of the parenthesis of the method
- We can include as many as we want
- They can be any data type that we want

There is a special method called main, it is where the program execution occurs
- There only one per program

# Pass by Value

Java uses pass by value when passing variables to methods
- This means a copy of the value is passed into the method, the original will not be modified

![pass-by](https://blog.penjee.com/wp-content/uploads/2015/02/pass-by-reference-vs-pass-by-value-animation.gif)

Java objects may appear like they are pass by reference, however they are still pass by value
- When objects are stored in variables, the variable is a "pointer" or reference to the object in memory
- When object references are passed to methds, it is not possible to change the reference itself, because the value of the reference is passed

# Constructors

A special method which is used to create an instance of an object
- Do not have a return type
- Returns a new object

The constructor declares how an object is to be instatiated and initalized from class

There are three types of constructors:

- default: gets created automatically if no other constructor is given
- argument: is a constructor that takes in parameters
- no-arg: is a constructor that takes in no paramaters

The `this` keyword is used to reference variables that belong the the specific object

The `super` keyword is used to call the constructor of the parent class, a call to `super()` is implicitly the first line of every constructor
- It MUST be the first line of the constructor

# Packages and Imports

Packages are a way to organize your classes, interfaces, and enums into a folder structure
- They follow the lowercase naming convention, with words separated by dots in the reverse way you would specific a web domain
    - eg. com.example.package

You can access classes by their fully qualified names, package.classname, com.example.package.Class

You can use import statement to pull in other classes

After importing the class or package we can just use it in the program.
- The the java.lang package is imported by default

# Primitive Data Types

The only thing keeping Java from being completely object oriented, there are 8 primitive types

-   boolean:
    -   1 bit, but actually 6 to due to metadata
    -   Represents true or false values
-   byte:
    -   Represents an 8 bit signed integer
    -   Values -128 to 127
-   short
    -   Represents a 16-bit signed integer
    -   Values -32768 to 32767
-   int
    -   Represents a 32-bit signed integer
    -   Values from around -2 billion to 2 billion
-   long
    -   Represents a 64-bit signed integer
    -   Values from -2^64 to 2^64-1
-   float
    -   Represents a 32-bit signed floating point value
    -   Can store values with up to 7 decimal digits
-   double
    -   Represents a 64-bit signed floating point value
    -   Can store values with up to 16 decimal digits
-   char
    -   Represents a 16 bit unicode character
-   String
    -   Is not a primitive, but it is used so much in Java that it treated as such

Data type Default Values:
- boolean: false
- char: \u000 (0)
- int: 0
- float: 0.0f
- reference types (object): null

Datatype Casting:

Widening: Will occur automatially, Java will convert smaller datatypes to a larger data type

Narrowing: Will need to be done manually, converting a larger datatype to a smaller data type

# Operators and Control Flow

Java Operators

| Operator             | Precedence                              |
| -------------------- | --------------------------------------- |
| postfix              | x++ x--                                 |
| prefix               | ++x --x                                 |
| multiplicative       | \* / %                                  |
| additive             | + -                                     |
| shift                | << >> >>>                               |
| relational           | < > <= >=                               |
| equality             | == !=                                   |
| bitwise AND          | &                                       |
| bitwise exclusive OR | ^                                       |
| bitwise OR           | \|                                      |
| logical AND          | &&                                      |
| logical OR           | \|\|                                    |
| ternary              | expression ? true option : false option |
| assignment           | = += -= /= %=                           |

Logical AND and OR will short circuit
- is when the operation can determin the outcome by looking at only one side of the expression

Java Control Flow:

Typically in Java the program runs from top to bottom, we can break this traditional behavior with control flow statements

- These are conditionals, loops, and branching statements

Conditional/Branching
- if/else, if/else if, ternary operators, switch, try catch

Looping statements:
- for loops, enhanced for loops, while loops, and do-while loops

Conditional Statements run code when a condition evaulates to true, or skips it if false

- You can use if statements in three ways
    - single if
    - if/else
    - if/else if
    - if(true) run some logic
- Switch statements are another way to conditionally check equality
    - They take a variable and attempt to match its content
    - Only work with byte, char, short, int, String, and enums

Loop statements repeat logic until the loop is finished
- for loops run the logic inside for a set number of times
- while loops run the logic inside while a condition is true
- do-while loops run the logic inside of them while a condition is true, but this will run at least once

Break and Continue Keywords

Break can be used in loops, if statements, and switch statements
- It will break out of the current block of code

Continue can only be used inside of loops
- It will break out of the current iteration of the loop, and return to the top of the loop execution