drop table workers CASCADE;
TRUNCATE workers;
create table workers (
  id serial,
  depart_id integer,
  chief_id integer,
  salary integer
);

insert into workers (depart_id, chief_id, salary) VALUES
  (100,1,1000), (100,1,500), (100,1,600), (100,1,1100),
  (200,5,3000), (200,5,2000), (200,5,15000),
  (300,8,5000), (300,8,300), (300,8,200),
  (400,11,2500), (400,11,2000), (400,11,1200), (400,11,3000);

-- в каком департаменте работник получает больше шефа
-- какой департамент получает большую зарплату

-- ====================
-- в каком департаменте работник получает больше шефа
select * from workers;

-- list of departments
select DISTINCT depart_id from workers;
-- SELECT chief_id from workers WHERE id = chief_id;
-- list of chiefs ids, there departs and there salary
SELECT depart_id, chief_id, salary from workers WHERE id = chief_id;

create VIEW chiefs_ids as
  SELECT chief_id from workers WHERE id = chief_id;
select * from chiefs_ids;
select id, salary from workers
  WHERE chief_id != id and salary >
          select salary from workers where id = chief_id;
-- list of chiefs salaries
select depart_id, salary FROM workers where chief_id = id ORDER BY salary;
select depart_id, salary FROM workers where chief_id = id ORDER BY salary;

select * from workers JOIN workers
  on
-- it's the same
/*select salary FROM workers
  where chief_id = id and depart_id in
   (select DISTINCT depart_id from workers) ORDER BY salary;*/

select id from workers where salary > (select salary FROM workers where chief_id = id);


-- какой департамент получает большую зарплату
-- select * from sal_sums ORDER BY m_sal DESC;
-- select max(m_sal) from sal_sums;

create view sal_sums as
  select depart_id, sum(salary) m_sal from workers WHERE depart_id in
    (select DISTINCT depart_id from workers) group BY depart_id order by depart_id;
drop VIEW IF EXISTS the_max_sum;
create VIEW the_max_sum as
  select depart_id, max(m_sal) from sal_sums GROUP BY depart_id;

SELECT * from the_max_sum order by max DESC;
select depart_id, max from the_max_sum ORDER BY max DESC LIMIT 1;

select depart_id from the_max_sum
  WHERE max = (select max from the_max_sum ORDER BY max DESC LIMIT 1);

-- select depart_id from workers where depart_id = (select * from the_max_sum);
