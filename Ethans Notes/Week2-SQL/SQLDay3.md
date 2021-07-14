# SQL Sublanguages

There are 4 or 5 sublanguages in SQL depending on who you ask

-   In this traning we will be teaching 5

## Data Definition Language (DDL):

-   Used to define the Database itself
-   Deals with creation, alteration, or deletion of tables, schemas, or databases themselves
-   Syntax/Keywords
    -   CREATE: used to create a new table, schema, or database
    -   ALTER: used to make changes to a table, schema, or database
    -   DROP: used to completely remove/delete a table
    -   TRUNCATE: used to remove all the data from a table, but leave its structure behind

## Data Manipulation Language (DML):

-   Used to change data inside of the database
-   Often refered to as the CRUD operations, (Create, Read, Update, Delete)
    -   This is the theoretical construct of what you should be able to do with data in a table
-   Syntax/keywords for DML:
    -   INSERT: add new data to a table
    -   SELECT: retrieve data from a table
    -   UPDATE: make a change to existing data in a table
    -   DELETE: remove a record from a table

## Data Query Language (DQL):

-   This is often debated, however it exists in PostgreSQL so we teach it
-   The debate itself is whether it should be its own language or part of DML
-   Syntax/Keywords for DQL:
    -   SELECT: used to retrieve data from a table
-   Typical DQL is refering to using SELECT with the use of constraints, aka with the "WHERE" keyword/clause

## Data Control Language (DCL):

-   This sublanguage is used to manage the security and control of your database
-   Syntax/Keywords for DCL:
    -   GRANT: to grant any permissions to a user
    -   REVOKE: removes any permissions from a user

# Constraints

Constraints are restrictions that we can put on the columns of our tables in SQL

Some constraints include:

-   Composite Key: a key that uses more than one column
-   Not null: the column must have data
-   Unique: no two records enter into this column can be the same
-   Primary Key: denotes that this column is a primary key
-   Foreign Key: denots that the column is pointing to an attribute in another table
-   Default: create a defualt value if a value is not given
-   Serial: This is the old way to implement an auto generated primary
-   Indentity: this is the new way to create a primary key automatically

# Other Notible Keywords

-   WHERE: used to narrow the query results of your SELECT statement
-   ORDER BY: used to sort data returned by a SELECT statement by a specific row
-   GROUP BY: used to group rows by a column and perform a aggregate function
-   HAVING: similar to the WHERE clause, but used in conjunction with aggregate functions

## Transaction Control Language

-   Used to manage transactions within the database
-   A transaction is any change that happens to our table
-   Syntax/Keywords for TCL:
    -   COMMIT: this will perminently save any DML operations that occur
    -   ROLLBACK: this will completely erase any DML operations that occured between two commits. Keep in mind, once you commit something, you cannot rollback
    -   SAVEPOINT: creates a spot to rollback to

In SQL every Transaction must have a specific four properties, these are know as the ACID properties

Atomic: all of nothing, the transaction must be fully complete, or it doesnt happen at all

Consistency: The tables schema will remain intach after the transaction

Isolation: Each transaction cannot addect the results of other transactions

Durability: Data will persite through system crases and other issues

# Mulitplicity in Databases

Multiplicity is the relationship between entries in different tables

These relationships are defined with foreign key constraints

Foreign Keys:

-   Make relationships between tables
-   Do not need to be unique, but they can be
-   Can be made up of one or more columns
-   A foreign key made up of mulitple columns is a composite key

There are four types of multiplicity in relational databases

1. One-to-many: one entry in the first table can be mapped to many entries in the second table
    - The foreign key in the first is allowed to map to multiple entries in the second table
2. Many-to-one: this is the opposite of the above
3. Many-to-many: Many entries in the first table can be mapped to many entries in the second table
    - These are implemented with what are called junction tables
4. One-to-one: a single entry in the first table is mapped to a single entry in the second table
    - The foreign of both tables must be unique

Referential Intregrity

-   A foreign key is the reference to the relationship in mulitplicity, and the rule ensures that a reference record always exists
-   You are not allowed to delete an entry if an entry of another table depends on it
-   You can use cascade delete, which will delte children and parent entries

# Aggregate and Scalar Functions

Aggregate functions take multiple rows, and combine the values into a single column

Some popular aggregate functions are:

-   MAX(column): returns the max value
-   MIN(column): returns the min value
-   AVG(column): returns the average
-   SUM(column): adds and retursn the sum of the values in that column
-   COUNT(column): returns the number of elements in that column

These functions are used in the SELECT clause, and cannot be used with the WHERE clause

If more than one column is being selected in the SELECT clause, you will need to use GROUP BY

You can use the HAVING clause with an aggregate function instead of WHERE

Scalar Functions operate on a single row, these can be used with SELECT and WHERE

Some popular scalar functions are:

-   LENGHT(string): returns the length of the given string
-   UPPER(string): returns the string in all caps
-   LOWER(string): returns the string in all lower case
-   ABS(numer): returns the absolute value of the row
-   CEILING(number): returns the rounded up value of the number
-   FLOOR(number): returns the rounded down value of the number

# Normalization

Normalization refers to reducing the redundancy of data and improving data integrity and consistency

There are many different forms, but we will only focus on the first three

First Normal Form (1NF):

-   Must have a primary key
-   No duplicates
-   Atomic Columns (break up the columns as small as we can)

Second Normal Form (2NF):

-   It must first be first normal form
-   All attributes must depend on the key, aka, there are no partial dependences

Third Normal Form (3NF):

-   Must be second normal form
-   Here are no transitive dependencies (data should only relate to the primary key, nothing else)

A way to remember the three normal forms in order is the saying:

The key (1nf), the whole key (2nf), and nothing but the key (3nf), so help me codd

# JDBC

Java Database Connectivity, allows us to write java code that interacts with relational databases

# Interfaces of JDBC

There are several classes and interfaces commonly used with JDBC, which can be found in the java.sql, and javax.sql packages

-   `DriverManger` class : to make a connection with a database driver
-   `DataSource` interface : for retrieving connections, an alternative to DriverManager
-   `Connection` interface : represents a physical connection with a database
-   `SQLExceptin` class : a general exception thrown when somthing goes wrong when accessing a database
-   `Statement` interface : used for executing static SQL statements
-   `PreparedStatement` interface : used to execute precompiled SQL statements
-   `CallableStatement` interface : used to execute stored procedures
-   `ResultSet` interface : represents data returned from the database

# Setting up the database Driver and connection

To establish a connection, we will need what is know as a driver

-   These are database engine specific
-   You can get these through Maven Dependencies in your pom.xml

```xml
<!-- https://mvnrepository.com/artifact/postgresql/postgresql -->
<dependency>
	<groupId>postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<version>9.1-901.jdbc4</version>
</dependency>
```

# Connection Interface

To create a connection you use the DriverManger.getConnection() method, with these parameters

-   URL to the database (jdbc:postgresql://hostname:port/databasename)
-   username
-   password

# Design Pattern: Data Access Object

This is a design pattern we will be following to separate our business logic from our database logic

-   You will create a interface with method stubs of your database calls
-   Implement that interface with concrete DAO classes

This pattern results in reusable code, and cleaner project structure
