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

The way you serialize data, is with a FileOutputStream, and an ObjectInputStream

The way you deserialize is with a FileInputStream, and an ObjectInputStream

# Scanner

The scanner class can be used to read user input from the command line

# Try with resources

Java 7 implemented a new use for the try catch block, try with resources, it allows you to add a resource to the try block, and java will automatically close the resource for you when you are finished with it

The only catch, is that the object you are trying to use try with resources with, must implement the AutoCloseable interface
