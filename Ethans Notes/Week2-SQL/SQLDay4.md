# PLSQL

PL/SQL is procedural language sql, it allows us to create functions and other reusable bits of sql

-   It is closer to a programming language

Sequence:

-   An object that holds a numeric that starts at a certain point, and increments until it potentially reaches a max value
-   You increcent them with NEXTVAL

Trigger:

-   A block of code that executes when an event happens

Cursor:

-   Is a pointer to a result set, you can use these to loop programatically through the output of a select statement

Stored Procedures:

-   Reusable code in PL/SQL that has these properties
    -   Don't return anything
    -   May or may not contain IN and OUT parameters
    -   They allow and DML statement within
    -   Can call other stored procedures
    -   Can not use them in DML statements

Functions:

-   Resuable code in PL/SQL that return a value, and hase these properties
    -   Allow cursors
    -   Should be a single value
    -   They may or may not contain an IN parameter
    -   Only use them with SELECT statements
    -   Can call other functions
    -   Can be used in any DML statement
    -   You can use a DML statement to use them
