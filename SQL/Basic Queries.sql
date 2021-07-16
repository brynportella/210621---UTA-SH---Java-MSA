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

truncate table users cascade;

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

insert into post_likes_junction (user_id, post_id) values (6, 1);

insert into posts(author_id, wall_user_id, post_content) values
	(4,4, 'Hello myself');

insert into post_likes_junction(user_id, post_id) values (2,2),(6,2);

insert into posts(author_id, wall_user_id, post_content) values
	(1,5, 'Hello Terry');

insert into post_likes_junction(user_id, post_id) values (4,3),(1,3);

-- Lets insert some more data to play with
INSERT INTO posts(author_id, wall_user_id, post_content) VALUES 
    (1, 1, 'I just joined!'),
    (1, 3, 'How are you today!'),
    (1, 5, 'How is the family?'),
    (2, 3, 'Happy birthday!'),
    (2, 5, 'That was a crazy night'),
    (3, 1, 'I am doing great!'),
    (3, 5, 'We should do that again sometime!'),
    (4, 1, 'Glad to see you joined'),
    (5, 5, 'Thanks everyone how came out'),
    (5, 2, 'We really had a great time'),
    (5, 3, 'We will definitely plan to do some more events');

   
insert into post_likes_junction (user_id, post_id) values
	(2,1), (3,1),
	(3,2), (4,2),
	(5, 3), (2, 3), (3, 3),
	(3, 4), (2, 4), (1, 4),
	(5, 5), (3, 5), (2, 5),
	(1, 6),
	(5, 7), (2, 7), (3, 7), (4,7),
	(1, 8), (3, 8),
	(3, 9), (2, 9), (4, 9),
	(2, 10), (3, 10),
	(3, 11);
   
select  * from post_likes_junction;
select * from posts;

truncate table posts cascade;

drop table posts cascade;

-- Aggregate functions

select count (l.post_id) as likes, p.post_content
	from post_likes_junction l, posts p
	where l.post_id = p.post_id 
	group by p.post_content
	order by likes desc;

select max(username) from users;

select min(username) from users;

-- Scalar functions

select LOWER(first_name) as first, LOWER(last_name) as last from users;

select CONCAT(first_name, last_name) as name from users;

-- TCL Statements

begin;
	insert into posts (author_id, wall_user_id, post_content) values (4,6, 'Great event last night');
	insert into posts (author_id, wall_user_id, post_content) values (1,6, 'Can I get an invite next time?');
	savepoint mysavepoint;
	rollback to savepoint mysavepoint;
	insert into posts (author_id, wall_user_id, post_content) values (6, 1, 'Of course you can');
commit;

-- Stored Procedures don't return anything, they are useful for adding elements to a table
create or replace procedure create_post(a_id int, w_id int, post varchar(500))
as $$
begin
	insert into posts(author_id, wall_user_id, post_content) values (a_id, w_id, post);
end;
$$ language 'plpgsql';

-- To run a stored procedure, you use the keyword call
call create_post(1,6, 'Why did not get invited last weekend?');

select * from posts;

-- Creating a function, functions return a value
create or replace function like_check(p_id int)
returns int as $$
declare likes int;
begin
	select into likes count(*) from post_likes_junction plj where p_id = plj.post_id;
	return likes;
end;
$$ language 'plpgsql';

select like_check(3);

-- Sequences are just a sequence of number that goes from 1 to the next
create sequence counter start 1;
select nextval('counter');

create table following(
	f_id int primary key,
	follower_id int,
	followie_id int
);

-- We can use sequences in conjunction with triggers to create auto generated field values
create or replace function ex_trigger()
returns trigger as $$
begin
	-- new.f_id will get the f_id column from the following table
	-- and set it to the next val of counter
	new.f_id = nextval('counter');
	return new;
end;
$$ language 'plpgsql';

create trigger id_trigger before insert on following for each row execute procedure ex_trigger();

insert into following(follower_id, followie_id) values (2,1);

select * from following;

-- View, is a virtual representation of a table or subset of a table
create view myview as select post_id, post_content from posts;

select * from myview;

-- Cursors are pointers to a temporary workspace, they hold rows returned by a sql statement
-- The set of rows it holds is known as the result set or the active set

-- We use cursors to return mulitple rows of data from a function
create or replace function get_user_posts(u_id int)
returns refcursor as $$
declare ref refcursor;
begin
	open ref for select * from posts where author_id = u_id;
	return ref;
end;
$$ language 'plpgsql';

select get_user_posts(6);
commit;

create or replace function get_all_posts()
returns refcursor as $$
declare ref refcursor;
begin
	open ref for select u.username, p.post_id, p.author_id, p.wall_user_id, p.post_content from users u, posts p where u.id = p.author_id;
	return ref;
end;
$$ language 'plpgsql';

select get_all_posts();
commit;

-- Simple join examples

insert into users (first_name, last_name, email, username, password) values
	('Rick', 'Sanchez', 'rick@rickmail.com', 'ricksanchex1234', 'password');

select * from users u inner join posts p on u.id = p.author_id;

select * from users u full join posts p on u.id = p.author_id;

select * from users u left join posts p on u.id = p.author_id;

select * from users u right join posts p on u.id = p.author_id;

-- Get what posts each user has liked
select u.username, p2.post_content as liked_content from users u
	inner join (select * from posts p inner join post_likes_junction plj on p.post_id = plj.post_id) as p2 
	on u.id = p2.user_id;

-- Count users with the greatest number of posts
select u.id, u.first_name, u.last_name, count(*) as post_num from users u
	left join posts p on p.author_id = u.id
	group by u.id
	order by post_num desc;

-- Rank the users with the most total likes
select count(u.id) as like_count, u.username
	from users u
	inner join (select * from posts p inner join post_likes_junction plj on p.post_id = plj.post_id) as u2 on u2.author_id = u.id
	group by u.username
	order by like_count desc;

-- Set Operators

select u.username from users u union select p.post_content from posts p, users u where u.id = p.author_id;

-- Get all posts with a like on it
select post_content from posts intersect select p.post_content from post_likes_junction plj, posts p where p.post_id = plj.post_id;

-- Get all posts with no likes on them
select post_content from posts except select p.post_content from post_likes_junction plj, posts p where p.post_id = plj.post_id;

-- Creating an index
-- There are other parameters you can include while creating an index, however they are not important for this training
create index uname on users (username);






