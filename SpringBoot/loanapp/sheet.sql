
-- Part 1
create user user1 with password 'password';

create database fortest with owner = user1 encoding = 'UTF8';
grant all on database fortest to user1;

-- \connect fortest

-- Part 2
create sequence hibernate_sequence
  increment 1
  start 10000
  maxvalue 9223372036854775807
  cache 1;
alter sequence hibernate_sequence owner to user1;

-- Part 3
drop table if EXISTS t_users;
create table t_users (
  id bigint unique not null default nextval('hibernate_sequence') primary key,
  name varchar(100),
  surname varchar(100)
);

drop table if EXISTS t_loans;
create table t_loans (
id bigint unique not null default nextval('hibernate_sequence') primary key,
amount bigint,
term_end timestamp,

user_id  BIGINT REFERENCES t_users(id)
);

-- Part 4 Inserting some data
-- Part 4.1
insert into t_users(id, name, surname) values
  (1, 'Bob', 'Sinclare');
insert into t_loans(amount, term_end, user_id) values
  ( 20, TIMESTAMP 'now' + interval '0.5 year', 1),
  (100, TIMESTAMP 'now' + interval '4 year', 1),
  (300, TIMESTAMP 'now' + interval '2 year', 1);

-- Part 4.2
insert into t_users(id, name, surname) values
  (2, 'Melany', 'Trump');
insert into t_loans(amount, term_end, user_id) values
  ( 20, TIMESTAMP 'now' + interval '1 year', 2),
  (100, TIMESTAMP 'now' + interval '2 year', 2),
  (300, TIMESTAMP 'now' + interval '3 year', 2);

-- Part 4.3
insert into t_users(id, name, surname) values
  (3, 'Bob', 'Sinclare');
insert into t_loans(amount, term_end, user_id) values
  ( 20, TIMESTAMP 'now' + interval '10 year', 3),
  (100, TIMESTAMP 'now' + interval '21 year', 3),
  (300, TIMESTAMP 'now' + interval '3 year', 3);
