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