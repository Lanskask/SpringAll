/*employees_depart_id_fkey
alter table drop constraint if exist departments_pkey;*/
-- ======== For Ghost Group ======================
/*drop type IF EXISTS furniture_type CASCADE;
CREATE TYPE furniture_type AS ENUM (
  'cushioned',
  'store',
  'office'
);*/

/*drop table if EXISTS departments_enum CASCADE;
create table departments_enum (
  id SERIAL not null primary key,
  type furniture_type
);*/

drop table if EXISTS departments CASCADE;
create table departments (
  id SERIAL not null primary key,
  type VARCHAR(100)
);

drop table if EXISTS employees CASCADE;
create table employees (
  id serial not null primary key,
  full_name varchar(100) NOT NULL,
  depart_id INTEGER REFERENCES departments(id)
);

DROP TABLE IF EXISTS client_orders CASCADE;
create table client_orders (
  id serial not null primary key,
  name VARCHAR(250),
  order_date TIMESTAMP DEFAULT current_timestamp,
  finish_till TIMESTAMP DEFAULT current_timestamp + INTERVAL '7 day',
  depart_id INTEGER REFERENCES departments(id),
  employee_id INTEGER REFERENCES employees(id)
);