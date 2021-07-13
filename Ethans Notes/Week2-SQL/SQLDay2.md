# Unix

Unix is a family of Operating Systems which derive from an OS built in the 1970's at Bell Labs by AT&T

Unix is open source, meaning that anyone can access the source code, and it cannot restrict other software

The first stable distribution Unix was Linux, now there are tons of OS's under the Unix umbrella, these include Linux, MacOS, RedHat enterpise linux

RedHat is the most commonly used version of Linux, it is not open sourced, but it is popular because it has a large community, and preinstalled tools for Linux servers

# Commands

The file system in Linux is comprised of Directories, and is generally described as a three structure. With the root directory, or root folder being the very top level directory, this is denoted by the `/` character

There is also another important directory called the `home` directory, this is where the users personal files are stored, this directory is denoted by the `~` character

Some commands can take arguments and flags

-   Arguments take a form of a string, and they go after the command you like to execute
-   Flags typically go before the arguments, they are precended by either a single `-` or a double dash `--`

Here is a list of Unix commands

## The Most Important Command

`man` - The manual command will print to the terminal the manual for the particular command. If you are unsure what flags, or arguments a command can take, you simply type `man command` and you can see all the information about that command. eg. `man cp`

## Directory Commands

-   `cd` - Chance the directory, this allows us to navigate through our directory structure

    -   To go to the root directory `cd /`
    -   To go to the home directory `cd` `cd ~`
    -   To go one directory out `cd ..`
    -   To go a given directory you can either use `cd directoryName` or use a file path `cd ./directory/name`

-   `ls` - List directory, allows us to see the contents for a particular directory. When given no arguments, it lists the contents of the current directory. The `-a` flag allows you to see hidden items

    -   to see the contents of a specific directory `ls ./directory`
    -   to see everything, including hiddent files `ls -a`

-   `mkdir` - The make directory command, this allows us to create a new directory, mkdir takes an argument representing the name of the directory you wish to create

-   `pwd` - The print working directory command, it prints the full name of the directory you are currently working in. For example, if you were in the `home` directory inside of the `root` directory the output of `pwd` would be `/home`

## General Purpose Commands

-   `su` - The substitute user command, allows you to switch users, with no arguments this defaults to the root user, which has higher privleges. This can be useful if you need to perform multiple commands with elevated priveleges. But generally it is consider to be bad practice

-   `sudo` - the sudo command allows you to run particular commands as the root user

-   `clear` - the clear command usually prints the number of blank lines such that all previous commands are no longer on the screen

-   `echo` - this will just print something out to the console

-   `>` - The `>` operator will redirect the output of one command to a gile. The file will be created, or overwritten id it already exists. `ls . > log.txt`

-   `>>` - The `>>` operator acts the same as `>` but oppends to the file instead of overriding it.

-   `grep` - the grep command prints any lines in a file or files that match a given pattern. By default, grep interprets the pattern as a basic regular expression

## File Commands

-   `cat` - the concatenate command prints the contents of a file to the console `cat hello.txt`
-   `head` - the head command prints the first ten lines of a file to the console `head hello.txt`
-   `tail` - the tail command prints the last ten lines of a file to the console `tail hello.txt`
-   `touch` - the touch command allows us to modify the timestamp of a file.This command is usually used to create empty files, as an empty file is created if the touch command is given a file name that does not exist. `touch hello.txt`

-   `cp` - copy command create a copy of the specified file at the location specified. If the recursive flag is used, it can also be used to copy directories

    -   copy a hello.txt to goodbye.txt with `cp hello.txt goodbye.txt`
    -   copy a directory hello to directory goodbye with `cp -r hello goodbye`

-   `mv` - move command will either rename, or move a file to a specified location

    -   to rename a file hello.txt to goodbye.txt use `mv hello.txt goodbye.txt`
    -   to move hello.txt to goodbye directory use `mv hello.txt goodbye/.`
    -   rename the hello directory to goodbye directory with `mv -r hello goodbye`

-   `rm` - the remove command will delete a file or directory. The force flag will cause the command to delete files without prompting the user if there are warning. The command `rm -rf .` is extremly dangerous

-   `wc` - the word count command will print the number of words in a file. This command has several flags

    -   `-c`, `--bytes` print out the byte count
    -   `-m`, `--chars` prints the character count
    -   `-l`, `--lines` prints out the line count
    -   `-w`, `--words` prints out the word count

-   `ln` - the link command, it create a link between files. This allows you to make shortcuts to a file in one location without copying it over

# Environment Variables

An environment variable is a variable that is set, and able to be used from anywhere in your system

-   You are able to set these using the export command, either in your terminal, or in the startup ~/.bashrc

If you set an Environment Variable with just the export command in the terminal, the variable will no longer exist after restarting you shell, that is when you use the startup ~/.bashrc script

# File Permissions

File permissions in Unix are important because everything in Unix is considered a file, even directories

File permissions are broken up into three different groups, and you can set these individually

-   File owner
-   Group
-   Other

To change these file permissions you will use the `chmod` command

Each of the three groups can be assigned a number between 0 and 7, this number is a binary representation of which permissions are aloud

-   Binary 1 -> 001 execution is allowed
-   Binary 2 -> 010 write is allowed
-   Binary 4 -> 100 means that read is allowed
-   You can combine these in different ways to get any combination of execute, write, and read

The syntax for chmod goes as follows:

chmod owner perm group perm other perm file

chmod 750 file.txt -> 7 would allow everything for the owner, 5 would allow execution and reading to the group, 0 allows nothing to other users

There is a second less intuitive way that uses letters and +/-

chmod a+rwx hello.txt -> give permission to everyone

chmod o-w hello.txt -> this removes the permissions to write from the others

chmod g+w -> gives permission to the group to write to the file

# Package Managers

In order to install software on a Unix based OS, you generally use a package manager. There are several available, here are some popular ones:

RPM: is the Red Hat Package Manager, this is a package mananger that was created for the Red Hat Linux, but it can be used with other distributions

APT: Advanced Package Tool, this is a package manager used on many Linux Distributions. It allows you to retrieve, configure, and install/uninstall software packages

YUM: Yellow Dog Updater, is a package manangement utility for running RPM, your amazon EC2 will install YUM from you on initilization,

-   you will most likely use YUM commands such as update, install, remove

# Command-Line text editors

Command line text editors all you to write/modify files in the command line

Editors sucha as vi, vim, or nano should be built into your linux distribution

Nano is the easiest to control typically. Here are some guides to the two of the most popular command line editors

Nano: https://www.howtogeek.com/howto/42980/the-beginners-guide-to-nano-the-linux-command-line-text-editor/

Vim: https://www.linux.com/training-tutorials/vim-101-beginners-guide-vim/

# SQL Overview

What is a database?

A collection of structured data, typically grouped into tables

-   Each table has rows and columns
    -   The row will contain the information about the particular entry
    -   The columns are the attributes of the items the table

Every table will have a primary key:

-   A unique indetifier for each entry in the database
-   Each row will have only one primary key, but a primary can consist of multiple columns (this is called a composite)

## DBMS and RDBMS

DBMS: Database Management System

-   These are what we use to store and manage the data in our database

RDBMS: Relational Database Management System

-   This is what we will be using during training
-   Relational Databases are used to store information in tables that have relations to other one another
-   RDBMS's are structured so that is maintains security, accuracy, integretity, and consistency of data
-   The ultimate goal of a Database is to persist information

## SQL

SQL: Structued Query Language

-   This is NOT a programming
-   It is the underlying language used to query relational databases
-   English like syntax for developer to manipulate data

# Database Vendors

There are many different RDBMS vendors/flavors of SQL, these include:

-   Oracle
-   PostgreSQL
-   MySQL
-   Microsoft SQLSercer
-   Micrsoft Access

# Datatypes of Postgres

Tables in our database have attributes that describe the data stored in the row, these attributes can be of many different forms.

-   boolean(bool): true or false
-   character(char[n]): a fixed length character string
-   charcter varying(varchar(n)): a varying length string of characters
-   date: calendar date
-   integer(int): a whole number
-   numeric/decimal: a decimal number

PostgreSQL documenation on datatypes:

https://www.postgresql.org/docs/9.5/datatype.html

# Schema

A database schema refers to the formal structure of data defined by a relational database, this includes:

-   The various tables in the database and their columns and data types
-   the relationships between the table in the database

Schemas enforce constraints when defining tables, so we can visulize them through Entity Relationship Diagrams

An Entity Relationship Diagram (ERD) illustrates how different tables in a database relate to one another

They contain these three components:

The entity:

-   What the table is representing

Attributes:

-   These are the columns of the table

Relationships:

-   These are the connections between the tables
