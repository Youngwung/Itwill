/*
    join: 2개 이상의 테이블에서 검색하는 것.
    join 종류:
    1. inner join -- 테이블1과 테이블2에 모두 데이터가 있는경우만(교집합) 출력함.
            아래 예제에서 dname(dept테이블, 테이블2) 값이 없는 50번을 가진 '오쌤'의 정보가 출력되지 않음. -> left outer join으로 출력 가능
  또한, empno, ename (emp테이블, 테이블1) 값이 없는 40번을 가진 OPERATIONS(dname)의 정보가 출력되지 않음. -> right outer join으로 출력 가능.
                    
    2. outer join
        (1) left outer join  테이블1의 정보만 가지고 테이블2의 정보가 없는 경우도 출력
                --> 이 경우 select 테이블2.deptno로 호출하면 '오쌤'의 deptno는 null로 출력됨 
                ==>테이블2에서 '오쌤'의 deptno를 찾을 수 없음
        (2) right outer join 테이블2의 정보만 가지고 테이블1의 정보가 없는 경우도 출력
                        --> 이 경우 select 테이블1.deptno로 호출하면 'OPERATIONS'의 deptno는 null로 출력됨 
                ==>테이블1에서 'OPERATIONS'의 deptno를 찾을 수 없음
        (3) full outer join 테이블1의 정보만 가지고 있는 경우와 테이블2의 정보만 가지고 있는 경우 모두 출력.
    문법: 
    1. ANSI 표준 문법:
        select 컬럼, ...
        from 테이블1 join 종류 테이블2 on 조건식;  조건식은 두 테이블의 공통조건. 예제에서는 deptno
    2. Oracle 문법:
        select 컬럼, ...
        from 테이블1, 테이블2
        where 조건식;
*/

-- inner join과 outer join의 차이점을 설명하기 위해서.
insert into emp (empno, ename, sal, deptno)
values (1004, '오쌤', 3500, 50);
-- deptno가 50인 새로운 데이터 추가.
commit; -- 테이블의 변경 내용을 영구히 저장. 'ctrl + s' 느낌



-- 사번, 이름, 부서번호, 부서이름 검색

-- inner join. 표준 문법.
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp 
--    inner join dept on emp.deptno = dept.deptno;
    join dept on emp.deptno = dept.deptno;
--> inner join에서 inner는 생략 가능.

-- inner join. Oracle 문법.
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp, dept
where emp.deptno = dept.deptno;


-- left (outer) join. 표준문법.
--> 공통컬럼인 deptno를 select에서 e로 호출 한 경우 출력 테이블에 '오쌤'의 deptno 값이 정상적으로 출력함.
----> 만약 d로 호출한 경우에는 dept테이블에서 '오쌤'의 deptno값을 출력하지 못함. 
--> dept테이블에서는 50번을 찾을수 없기 때문
select e.empno, e.ename, e.deptno, d.dname
from emp e 
    left outer join dept d on e.deptno = d.deptno;


-- left (outer) join. Oracle 문법.
select e.empno, e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno(+);


-- right (outer) join. 표준문법.
select e.empno, e.ename, d.deptno, d.dname
from emp e
    right join dept d on e.deptno = d.deptno;
--> right outer join에서 outer는 생략 가능.

-- right (outer) join. Oracle 문법.
select e.empno, e.ename, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;


-- full (outer) join. 표준 문법
select e.empno, e.ename, e.deptno, d.deptno, d.dname --> 'OPERATIONS'의 deptno가 안보임.
from emp e
    full join dept d on e.deptno = d.deptno;

select e.empno, e.ename, e.deptno d.deptno, d.dname --> '오쌤'의 deptno가 안보임.
from emp e
    full join dept d on e.deptno = d.deptno;

-- full (outer) join. Oracle 문법
--select e.empno, e.ename, e.deptd.deptno, d.dname
--from emp e, dept d
--where e.deptno(+) = d.deptno(+);

------------> Oracle은 full outer join 문법을 제공하지않음
-- 집합 연산(합집합 union, 교집합 intersection, 차집합 minus)을 사용
-- Oracle에서 full outer join 하는 방법
select e.empno, e.ename, e.deptno, d.deptno, d.dname --left join
from emp e, dept d
where e.deptno = d.deptno(+)

union --> 합집합 연산자

select e.empno, e.ename, e.deptno, d.deptno, d.dname -- right join
from emp e, dept d
where e.deptno(+) = d.deptno;


-- equi join: join의 조건식이 = 연산자를 사용해서 만들어진 경우.
-- non-equi join: join의 조건식이 부등호를 사용해서 만들어진 경우.

-- 사번, 이름, 급여, 급여등급(호봉) 검색.
-- 표준문법
select e.empno, e.ename, e.sal, s.grade
from emp e 
    join salgrade s on e.sal between s.losal and s.hisal;
--  join salgrade s on e.sal >=s.losal and e.sal <=s.hisal;

-- Oracle 문법
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;


-- self join: 같은 테이블에서 join을 하는것. (emp테이블에서 mgr과 empno는 관계가 있다.)

-- 표준문법
-- 사번, 이름, 매니저사번, 매니저 이름
select e1.empno, e1.ename, e1.mgr as MGR_NUM, e2.ename as MGR_NAME
from emp e1 join emp e2 on e1.mgr = e2.empno;

-- Oracle 문법
select e1.empno, e1.ename, e1.mgr as MGR_NUM, e2.ename as MGR_NAME
from emp e1, emp e2
where e1.mgr = e2.empno;

-- 표준문법 left join
select e1.empno, e1.ename, e1.mgr as MGR_NUM, e2.ename as MGR_NAME
from emp e1 
    left join emp e2 on e1.mgr = e2.empno;


-- Oracle left join
-- Oracle 문법
select e1.empno, e1.ename, e1.mgr as MGR_NUM, e2.ename as MGR_NAME
from emp e1, emp e2
where e1.mgr = e2.empno(+);



-- ex1. 직원 이름, 직원 근무 도시를 검색. 근무 도시 오름차순 정렬.

--표준 문법
select e.ename, d.loc
from emp e 
    join dept d on e.deptno = d.deptno
order by d.loc asc;

--Oracle 문법
select e.ename, d.loc
from emp e ,dept d 
where e.deptno = d.deptno
order by d.loc asc;

-- ex2. 직원 이름, 매니저 이름, 급여, 급여 등급을 검색.
--      정렬순서: (1)매니저, (2)급여 등급

--표준 문법
select e.ename, e.mgr, e.sal, s.grade
from emp e join salgrade s on e.sal between s.losal and s.hisal
order by e.mgr, s.grade;

--Oracle 문법
select e.ename, e.mgr, e.sal, s.grade
from emp e, salgrade s 
where e.sal between s.losal and s.hisal
order by e.mgr, s.grade;

-- ex3. 직원 이름, 부서 이름, 급여, 급여 등급을 검색.
--      정렬 순서: (1)부서 이름, (2)급여 등급

--표준 문법
select e.ename, d.dname, e.sal, s.grade
from emp e 
    join dept d on e.deptno = d.deptno
    join salgrade s on sal between s.losal and s.hisal
order by d.dname, s.grade;

--Oracle 문법
select e.ename, d.dname, e.sal, s.grade
from emp e , dept d, salgrade s 
where e.deptno = d.deptno 
    and 
    e.sal between s.losal and s.hisal
order by d.dname, s.grade;

-- ex4. 부서 번호, 부서 이름, 부서 위치, 부서의 직원수를 검색. 부서 번호 오름 차순.

--표준 문법
select d.dname, d.loc, count(e.deptno)
from emp e 
    right join dept d on d.deptno = e.deptno
group by d.deptno, d.dname, d.loc
order by d.deptno;

--Oracle 문법
select d.dname, d.loc, count(e.deptno)
from  emp e, dept d
where e.deptno(+) = d.deptno
group by d.deptno, d.dname, d.loc
order by d.deptno;





-- ex5. 부서 번호, 부서 이름, 부서 직원수, 부서의 급여 최솟값, 
--      부서의 급여 최댓값 검색. 부서 번호 오름 차순.

--표준 문법
select d.deptno, d.dname, count(e.deptno), min(e.sal), max(e.sal)
from emp e
    join dept d on e.deptno = d.deptno
group by d.deptno, d.dname
order by d.deptno asc;

--Oracle 문법
select d.deptno, d.dname, count(e.deptno), min(e.sal), max(e.sal)
from emp e, dept d
where  e.deptno = d.deptno
group by d.deptno, d.dname
order by d.deptno asc;

-- ex6. 부서 번호, 부서 이름, 사번, 이름, 매니저 사번, 매니저 이름, 
--      급여, 급여 등급을 검색. 급여가 3000 이상인 직원들만 검색.
--      정렬 순서: (1) 부서 번호, (2) 사번 오름차순.

--표준 문법
select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e2.ename, e1.sal, s.grade
from dept d
    right join emp e1 on d.deptno = e1.deptno
    left join emp e2 on e1.mgr = e2.empno
    join salgrade s on e1.sal between s.losal and s.hisal
where e1.sal >= 3000
order by d.deptno, e1.empno asc;

--Oracle 문법
select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e2.ename, e1.sal, s.grade
from dept d, emp e1, emp e2, salgrade s 
where d.deptno = e1.deptno and 
    e1.mgr = e2.empno and 
    e1.sal between s.losal and 
    s.hisal and 
    e1.sal >= 3000
order by d.deptno, e1.empno asc;