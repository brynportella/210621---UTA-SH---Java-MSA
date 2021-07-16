# SQL Joins

Joins are used to combine two tables on specified columns

-   Normally comparing primary and foreign
-   They can be done on any column as long as the types match

Joins are a way of denormalizing tables, and aggregating data

![joins](https://www.postgresqltutorial.com/wp-content/uploads/2018/12/PostgreSQL-Joins.png)

## Inner

Inner join is the most common, it returns rows that match the specified join clause

## Outer

The outer keyword can be used with LEFT, RIGHT, and FULL, these specify what kind of outer join you want

## Left

Left (Outer) returns the matching rows and the ones that are null, on the first table

## Right

Right (Outer) returns the matching rows, and the ones that are null on the second table

## Full

Full (Outer) returns all rows from both tables, including the ones that are null from both tables

## Self

This performs an inner join between two columns inside of the same table, represents a hierarchy

## Cross

This will return the cartesian product of two tables

## Natural

This will join tables based off of matching column names

# Set Operators

![set-operators](https://dwgeek.com/wp-content/uploads/2019/12/Snowflake-Set-Operators.jpg)

Set operators are similar to joins, however, instead of joining tables, they combine rows of return sets from queries

Some important Set Operators to know are:

Union: returns everything between the two sets without duplicates

-   Union all with will return duplicates

Intersect: returns the records the queries have in common

Minus: Removes any row from the first set, that is also present in the second set

Except: Does the opposite of Minus

# Views

Views are virtual tables in SQL, they are created using DQL statements

Advantages of views:

-   Give access to some but not all of the data in a table
-   Hide complexity of a database from users
-   Allows users to query normalized tables easily
-   Changes to the underlying table(s) are automatically reflected in the view

# Indexes

Indexes are used to speed up the look up of rows in a database

They are created on individual table columns which you expect to be looked up often, this is why primary keys are often automatically given indexes by the database

Then an index is created on a database column, a separate data structure is created in the database, typically some sort of balanced tree, which stores references to the actual records stored in the table

The advantage of indexes, ist that it speeds up the retrieval of data when looking for a specific column, however the trade off is that you lose effiency when inserting into the database

You should consider adding an index to a column when you anticipare or already know that the column will be used often when searching the table for records

## Types

There are many types of indexes, however they are all split into two categories: clustered and non-clustered

Clustered indexes alter the order in which the records are physically stored on the disk. Only one of these can be created per table

Non-clustered indexes specify a logical ordering of rows but do not alter the physical ordering in the table, you are allowed more than one of these per table

A list of index types includes:

-   Bitmap
-   Dense
-   Sparse
-   Reverse
-   Primary
-   Secondary
