# Exceptions

Exceptions are events that occur in during the execution of a program, that disrupts the normal flow of the application, during these events an execption or error object is thrown

-   We can recover from exceptions, we can also technically recover from errors, but it is not practical

## Exception Hierachy

The root of all Exceptions is the Throwable class

-   Any class that extends this Throwable class can be "thrown" with the `throw` keyword

The Exception and Error classes both extend Throwable

RuntimeException class extends from Exception

From there, all exceptions extend either RuntimeException or Exception

![Exceptions hierarchy](https://i.pinimg.com/originals/a6/ab/f3/a6abf35c5fbbb57ebd4e949945839f31.jpg)

## Checked vs Unchecked Exceptions

There are two types of exceptions in Java, checked and unchecked

Checked exceptions are any exception that is not a sub-class of RuntimeException, also known as compile time

-   These are caught at compile time, you are required to handle/catch these, otherwise your code will not compile

Examples:

-   FileNotFoundException
-   ClassNotFoundException
-   CloneNotSupportedException

Unckecked exceptions are any exception that is a subclass of RuntimeException, also known as run time exceptions

-   These are caught during runtime of your application, these are not required to be caught

Examples:

-   ArithmeticException
-   IndexOutOfBoundsException
-   NullPointerException

In Java we have Error objects, these occur when something goes horribly wrong, you should not try to recover from these

Examples of errors:

-   StackOverflow
-   OutOfMemory

## Exception Handling or Declarations

When you suspect that code may be at risk of throwing an exception, it can be handled in two ways

1. You can place the code inside of a try/catch block
2. You can delcare that the method could throw an exception with the `throws` keyword

-   This will "duck" the exception, essentially whatever calls the method, will now have to handle the exception

try/catch/finally blocks:

You want to enclosed the code that is suspect to throw an error in a try block

Inside the parentethis of the catch block, you want declare what exception you are expecting,

Inside of the catch block you put and logic

The finally block will run some logic no matter what

try/catch rules/multi-catch block

-   Multiple catches, but they must go from most specific to least specific
-   You can catch more than one exception per catch block using ||
-   The finally is option
-   A try/finally is valid, however, you cannot have only a try

## Custom Exceptions

You can also create your own custom exceptions

-   You can create a checked exception by extending the exception
-   You can create an unchecked exception by extending the RunTimeException class

Which one you choose depends on wether or not you want to force the programmer to handle your custom exception

You should know the difference between `throws` `throw` and `Throwable`

# Collections API

The Collections API is a framework of Java classes and interfaces that implement commonly used data structures

A data structure is a data organization, management, and storage format, that enables efficient access and modification

-   Each one prioritize access and modification in different ways
-   Each one is best suited for specfic problems

There are two types of data structures

-   Linear: arranged in an orderly manner where each element is attached adjacently
    -   Elements can be acces in one time sinlgle run
    -   simpler to implement
    -   single level
    -   memory ineficient
-   Hiercharchical: arranges elements in a sorted order and there is a relationship between them
    -   Cannot access all elements in a single run
    -   Complex to implement
    -   Multi-leveled
    -   Memory effiecient

![Collection API class hierarchy](https://javaconceptoftheday.com/wp-content/uploads/2014/11/CollectionHierarchy.png)

ALMOST every class in the Collections API come from the Iterable interface,

-   Exception being Map, but it is still considered part of the API

# Iterable Interface and Iterator Interface

The iterable interface defines data structures that can be directly traversed using the `.iterator()` method

The Iterator interface contains methods for traversing linear data structures, these methods include:

-   hasNext()
-   next()
-   remove()

Any class the implemenst Iterable can also be used with enhanced for-loops

-   The downside is that you can not get index information from the loop

Classes that implement the Iterable interface also have the .forEach() method, this allows us to iterate through the data structure, and perform some logic with lambda expression

Some important interfaces that indirectly implement Iterable through the Collections API are:

-   List
-   Queue
-   Set

# Lists

Lists are the most bacis datatype, which are just collections of data that is ordered, and preserve the order in which the elements are inserted into the list

-   Duplicates are allowed
-   Elements are accessed by their#, which start at 0

ArrayList: a concrete implementation of the List interface which contains an array inside of it

-   The array is resizable, once it reaches its max capacity it increases its size by 50%
-   You can traverse it quickly via indexes
-   Insertion, and deletion are slower because it has to resize the array

LinkedList: a concrete implemention of the List interface that is composed of nodes that reference one another

-   Insertion and deletion are quick
-   Traversion to a specific index is slower, because you have to iterate through the list

Vector: an older concrete implementation of the List interface, which is a thread safe ArrayList

-   Doubles in size when it runs out of space

Stack: an older concrete implementation of the List interface, used to implement the stack datatype, but now you should use an ArrayDeque

-   Stack is first in last out

# Sets

Set is another interface that implements the Iterable interface through the Collections API

-   It is not index driven
-   Only allows unique elements
-   Does not perserve order

HashSet: a concrete implemention of the Set interface:

-   There is no ordering when iterating
-   Allows on null value
-   Allows fast insertion and traverals

TreeSet: a concrete implementation of the Set interface, and it maintains the sorted order in which the elements are inserted:

-   Is backed by a Sorted Tree
-   Insertion and Deletion is slow
-   It cannot contain null elements

# Queue

The Queue interface is an interface that describes the queue data structure, and it used when elements should be added and removed in a specific order

-   Queues are First in First Our, (FIFO), unless otherwise specified

ArrayDeque is a concrete implementation of the Queue interface, it allows programmers to implement either a queue or a stack

-   It is a double ended queue
-   It stores elements in a resizable array

Useful ArrayDeque methods:

-   pop()
-   push()
-   peekFirst()
-   peekLast()
-   pollFirst()
-   pollLast()
-   offerFirst()
-   offerLast()

Priority Queue: is a concrete implementation of the Queue interface, it orders elements based on their natural ordering

-   Used the a Comparator to order the elements

# Maps

The Map Interface does not implement the Collection Interface, however it is still part of the Collections API

Maps are used to indetify a value by a key, and each entry in a map is a key-value pair

You cannot iterate over a Map directly, because it does not implement the Iterable interface

If we want to iterate over features of a map we can use these:

-   entrySey() method to iterate over Map.entry
-   keySet() method to iterate over the set of keys
-   values() method to return a collection of the values in the map

HashMap

-   Stores elements in key/value pairs
-   Insertion/retrieval is fast
-   Tradeoff is that it does not maintain isertion order
-   Permits on null key, and many null values

TreeMap

-   Stores its keys in a sorted tree structure
-   Insertion and retrieval is slow
-   Cannot contain null keys

Hashtable

-   Older
-   Threadsafe
-   It cannot contain null keys or values

# Generics

Generics are constructs introduced in Java 5, which enforce compile time safety by allowing you use paramertizes types

-   These are heavily used with the Collections API

They are essentially a place holder for future datatypes, and help us enforce type safety

Gernerics can be declared on a class, method, or return types

With generics you can restrict a class to only accept objects of a given type, and the compiler will prevent you from using any other type

To make a class or interface generic, you use angled brackets `<>` when declaring it, and use an arbritary "generic type" which is determined at run time

Naming conventions:

-   E => Element
-   K => Map Key
-   V => Map Value
-   N => Number
-   T => Generic Data Type

# Comparable and Comparator Interface

Comparable is an interface which defines the natural ordering for a class

-   The class must implement the Comparable interface and implement the compareTo() method

The compareTo() method will return:

-   Zero id the two objects are equals
-   Less than zero if "this" object is smaller than the one in the parameter
-   Greate than zero if "this" object is larger than the one in the parameter

Comparator is an interface that allows you to define a total ordering on some collection of objects

-   You can implement the Comparator interface, but you are not required to implement the .compare() method

# collections vs Collection vs Collections

Remember the difference between these three:

-   collections are just a collection of entities
-   Collection is an interface within the Collections API
-   Collections is a utility class that has static, conveient methods that operate on data structures in the Collections API
