-- More DDL to create a table called users

--Use create table to create a new table in your database
create table if not exists users(
	id int primary key generated always as identity,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	email varchar(50) not null unique,
	username varchar(64) not null unique,
	password varchar(50) not null
);

-- DDL statements also include ALTER, SET, DROP, and TRUNCATE

alter table users add column test int;
alter table users alter column test set data type varchar(2);
alter table users alter column test set default 'hi';

-- Update all null values to 'hi'
update users set test = coalesce(test, 'hi');

-- Continue with more DDL examples
alter table users alter column test set not null;
alter table users drop column test;

-- TRUNCATE table - will remove all data, but it leave the table
truncate table users;

-- DROP table will remove the table entirely
drop table users;

-- DML Statements
-- You can insert a single value into a table
insert into users(first_name, last_name, email, username, password) values
	('Hayden', 'Fields', 'hayden.fields@mail.com', 'haydenfields3841', 'p4ssw0rd');

insert into users(first_name, last_name, email, username, password) values
	('Harry', 'Smith', 'hsmith@mail.com', 'harrysmith2341', 'password'),
	('Larry', 'King', 'lking@mail.com', 'larryking8345', 'password'),
	('Mary', 'Shelley', 'mshelley@mail.com', 'maryshelley9324', 'password'),
	('Terry', 'Miller', 'tmiller@mail.com', 'terrymiller4601', 'password');

-- We can update specific entries in that table with UPDATE
update users set email = 'franenstein@mail.com' where id = 5;

-- We can delete specific entries from a table with DELETE
delete from users where id = 5;

-- DQL Queries

-- We can grab everything from the table using this
select * from users;

-- We can specify specific columns to return
select first_name, last_name from users;

-- WE can use the WHERE keyword to narrow down our results
select * from users where id > 2;

-- We can assign alias' to change the title of an attribute in the result set
select username as alias from users;

-- We can use the keyword LIKE with wildcards to search for strings
-- % is a wildcard that is a stand in for 0 or more characters
-- _ is a wildcard that is a stand in for exactly 1 character
select username from users where username like 'm%';
insert into users (first_name, last_name, email, username, password) values
	('Terry', 'Miller', 'tmiller@mail.com', 'terrymiller4601', 'password');
select username from users where username like 'te%';
select username from users where username like '%ar%';
select username from users where username like '_aryshelley9324';
select username from users where username like '__rry%';

-- Sorting/ordering with the ORDER BY Keyword
select * from users order by username;
select * from users order by username desc;

-- Between keyword
select * from users where id between 1 and 4;

-- IN keyword
select * from users where first_name in('Larry', 'Mary', 'Harry');

-- Create a Many-to-one relationship

create table if not exists posts(
	post_id int primary key generated always as identity,
	-- references users(id) is how we make our link to the users table
	author_id int references users(id) not null,
	wall_user_id int references users(id) not null,
	post_content varchar(500) not null
);

-- After we create some posts, you cannot drop a user while a post points at its id
-- Because posts depends on users, you can fix this issue by using CASCADE

drop table users cascade;

-- Create a many-to-many relationship with a junction table

create table if not exists post_likes_junction(
	user_id int references users(id) not null,
	post_id int references posts(post_id) not null,
	primary key(user_id, post_id)
);

-- Use your DML skills to do the following:
    -- Harry should post a message on Haydens walls, which Terry likes
    -- Mary should post a message on her own wall, which Harry and Terry like
    -- Hayden will post a message on Terrys wall, which Mary and Hayden like
    
-- Harry is userid 2, Hayden is userid 1
insert into posts(author_id, wall_user_id , post_content) values 
	(2, 1, 'Whats up');

select * from posts;

insert into post_likes_junction (user_id, post_id) values (6, 1);

select  * from post_likes_junction;


	




