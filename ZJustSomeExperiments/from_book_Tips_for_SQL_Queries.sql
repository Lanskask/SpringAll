select d.* from dept d
  left JOIN emp e
    on (d.deptno = e.deptno)
WHERE e.deptno is NULL;

select * from dept d
  left JOIN emp e
    on (d.deptno = e.deptno);


select deptno from dept
EXCEPT
  SELECT deptno from emp;

select deptno
from dept
WHERE deptno not IN (SELECT  deptno from emp);

-- ============ for numbers
select empno, avg(deptno) from emp GROUP BY empno;
select * from emp;
select count(job), job, ename from emp GROUP BY job, ename;

select deptno, sum(sal) from emp GROUP BY deptno;

-- =================== Независимое добавление объединений в запрос
select * from emp;
select * from dept;

select e.ename, d.loc from emp e, dept d
  WHERE e.deptno = d.deptno;

SELECT e.deptno, e.ename, d.loc
from emp e JOIN dept d
    on (e.deptno = d.deptno);

SELECT e.*, d.*
from emp e FULL JOIN dept d
    on (e.deptno = d.deptno);

SELECT e.ename, d.loc, eb.received
  from emp e JOIN dept d
    on (e.deptno = d.deptno)
  left JOIN emp_bonus eb
    on (eb.empno = e.empno)
order by 2;

