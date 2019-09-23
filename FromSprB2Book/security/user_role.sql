-- Part 1 - create tables
create table users (
	id serial primary key,
	name varchar(100),
	email varchar(100),
	password varchar(255)
);

create table roles (
	id serial primary key,
	name varchar(255)
);

create table user_role (
	user_id serial REFERENCES users(id),
	role_id serial REFERENCES roles(id)
);

-- Part 2 - insert part
delete from  user_role;
delete from  roles;
delete from  users;

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');
INSERT INTO users (id, email, name, password) VALUES
	(1, 'admin@gmail.com', 'Admin',
	 	'$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS'),
	(2, 'siva@gmail.com', 'Siva',
	 	'$2a$10$UFEPYW7Rx1qZqdHajzOnB.VBR3rvm7OI7uSix4RadfQiNhkZOi2fi'),
	(3, 'user@gmail.com', 'DemoUser',
	 	'$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by');
insert into user_role(user_id, role_id) values (1,1), (1,2), (3,2);