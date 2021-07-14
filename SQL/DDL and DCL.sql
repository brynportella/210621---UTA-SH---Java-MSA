-- DDL to create our database and DCL to grant our user access
-- Typical convention is to put keywords in all Uppercase, however dbeaver likes to change it to lowercase

create user socialuser with password 'password';

create database socialdb;

grant all privileges on database socialdb to socialuser;