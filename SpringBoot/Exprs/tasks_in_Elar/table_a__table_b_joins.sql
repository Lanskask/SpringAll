create table a (
	name varchar(10),
	id int
);

create table b (
	name varchar(10),
	id int,
	A_id int
);

insert into a(name, id) values ('First', 1), ('Second', 2),	('Third', 3);

insert into B values  ('First', 1, 1), ('Second', 2, 1), ('Third', 3, 2), ('Fourth', 4, 6), ('Fifth', 5, 2), ('Sixth', 6, 5), ('Seventh', 7, 3), ('Eighth', 8, 4);


select count(*) from a join b on a.id = b.a_id; # 5
select count(*) from a left join b on a.id = b.a_id; #
select count(*) from a right join b on a.id = b.a_id;
select count(*) from b right join a on a.id = b.a_id;

