/*
drop table IF EXISTS folders CASCADE;
create table folders (
  id serial PRIMARY KEY,
  name varchar(100),
  parrent_id integer
);
alter table folders add constraint fk_folder_id foreign key(parrent_id) references folders(id);
insert into folders values (1, 'root', null);

insert into folders(name, parrent_id) values ('fold_1', 1);
insert into folders(name, parrent_id) values ('fold_2', 2);
insert into folders(name, parrent_id) values ('fold_3', 1);

select * from folders;*/

/*
drop table IF EXISTS authors CASCADE;
drop table IF EXISTS rooms CASCADE;

CREATE table authors (
  id serial UNIQUE NOT NULL PRIMARY KEY,
  name VARCHAR(100),
  room_id integer REFERENCES rooms(id)
);

CREATE table rooms (
  id serial UNIQUE NOT NULL PRIMARY KEY,
  level_id integer
);

insert INTO rooms(id, level_id) VALUES (1,5),(2,6),(3,7),(4,7);
insert into rooms(id, level_id) VALUES (5,8);
insert into rooms(id, level_id) VALUES (6,8);
insert into rooms(id, level_id) VALUES (7,9);
insert into rooms(id, level_id) VALUES (8,10);
insert into authors(name, room_id) VALUES ('name1', 5), ('name2', 6), ('name3', 7), ('name1', 8);
insert into authors(name, room_id) VALUES ('name21', 3), ('name20', 4);
select * from rooms;
select * from authors;
select id from rooms where level_id = 7;
select distinct id, name from authors where room_id in (3,4);
select id, name from authors where room_id in (select id from rooms where level_id = 7);
*/

-- create database
create database frombook with owner = user1 encoding = 'UTF8';
-- \c frombook

-- making sequence
drop SEQUENCE if EXISTS int_sequence;
create sequence int_sequence
  increment 1
  start 1
  maxvalue 2147483647
  cache 1;
alter sequence int_sequence owner to user1;

-- create tables
drop table if EXISTS customers CASCADE;
drop table if EXISTS orders CASCADE;
drop table if EXISTS order_lines CASCADE;
drop table if EXISTS products CASCADE;
drop table if EXISTS comments CASCADE;

CREATE table customers (
  id integer unique not null default nextval('int_sequence') PRIMARY KEY,
  name varchar(100),
  customer_since TIMESTAMP
);

create table products (
  id integer unique not null default nextval('int_sequence') primary key,
  name varchar(100),
  price decimal,
  in_stock BOOLEAN
);

create table comments (
  id integer unique not null default nextval('int_sequence') primary key,
  text text,
  product_id integer REFERENCES products(id)
);

create table order_lines (
  id integer unique not null default nextval('int_sequence') primary key,
  amount integer,
  purchase_price DECIMAL,
  product_id integer REFERENCES products(id)
);

create table orders (
  id integer unique not null default nextval('int_sequence') primary key,
  date timestamp,
  customer_id integer references customers(id),
  order_lines_id integer REFERENCES order_lines(id)
);
