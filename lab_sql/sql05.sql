/*
    서브쿼리(subquery): SQL 문장의 일부로 다른 SQL 문장이 포함되는 것.
*/

-- 급여가 평균 이상인 직원들?
select avg(sal) from emp; --> 2073.21
select * from emp where sal >= 2073.21;

/*
    select * from emp where sal >= avg(sal) -->이거 하면 편할거같은데?
    
    --> 안되는 이유
    sql에서는 함수는 단독으로 호출할 수 없고
    반드시 select 함수호출 from 테이블 의 형태가 되어야한다.
    따라서 위 함수호출 자리 말고 함수를 사용하고 싶다면 
    그 부분에 (select 함수 from 테이블 where 조건) 형태로 사용해야한다.
    이게 서브쿼리.
*/
--> 2073.21자리에 평균을 구하는 쿼리를 넣어주고 괄호로 가두기.
select * 
from emp
where sal >= (
    select avg(sal) from emp --> 서브쿼리
);

-- Ex1. ALLEN보다 더 적은 급여를 받는 직원들의 사번, 이름, 급여를 검색
select empno, ename, sal
from emp
where sal < (
    select sal
    from emp
    where ename = 'ALLEN'
);

-- Ex2. ALLEN과 같은 업무를 담당하는 직원들의 
--      업무, 사번, 이름, 부서번호, 급여를 검색
select job, empno, ename, deptno, sal
from emp
where ename != 'ALLEN' and job = (
    select job
    from emp
    where ename = 'ALLEN'
);
-- Ex3. SALESMAN의 급여 최댓값보다 더 많은 급여를 받는 직원들의
--      업무, 사번, 이름, 부서번호, 급여를 검색
select job, empno, ename, deptno, sal
from emp
where sal > (
    select max(sal)
    from emp
    where job = 'SALESMAN'
);




-- Ex. WARD의 연봉보다 더 많은 연봉을 받는 직원들의 이름, 급여, 수당, 연봉을 검색.
-- 연봉 = sal * 12 + comm. comm(수당)이 null인 경우에는 0으로 계산.
-- 연봉 내림차순 정렬.
select ename, sal, nvl(comm, 0), (sal * 12 + nvl(comm, 0)) as ann_sal
from emp
where (sal * 12 + nvl(comm, 0)) > (
    select sal * 12 + nvl(comm, 0)
    from emp
    where ename = 'WARD'
)
order by sal * 12 + nvl(comm, 0) desc;


-- Ex. SCOTT과 같은 급여를  받는 직원들의 이름과 급여를 검색.
select ename, sal
from emp
where sal = (
    select sal
    from emp
    where ename = 'SCOTT'
);


-- Ex. 위 결과에서 SCOTT은 제외하고 검색.
select ename, sal
from emp
where ename != 'SCOTT' 
    and 
    sal = (
        select sal
        from emp
        where ename = 'SCOTT'
    );


-- Ex. ALLEN보다 늦게 입사한 직원들의 이름, 입사날짜를 최근입사일부터 출력.
select ename, to_char(hiredate,'rrrr/mm/dd') as HIREDATE
from emp
where hiredate > (
    select hiredate
    from emp
    where ename = 'ALLEN'
)
order by hiredate desc;


-- Ex. 매니저가 KING인 직원들의 사번, 이름, 매니저 사번을 검색.
select deptno, ename, mgr
from emp
where mgr = (
    select empno
    from emp
    where ename = 'KING'
)
order by deptno;


-- Ex. ACCOUNTING 부서에 일하는 직원들의 이름, 급여, 부서번호를 검색.
select ename, sal, deptno
from emp
where deptno = (
    select deptno
    from dept
    where dname = 'ACCOUNTING'
);

-- Ex. CHICAGO에서 근무하는 직원들의 이름, 급여, 부서 번호를 검색.
select ename, sal, deptno
from emp
where deptno = (
    select deptno
    from dept
    where loc = 'CHICAGO'
);


/*
    다중행 서브쿼리
    where weight < ALL (
        select weight student where grade =4
    )
    --> 서브쿼리의 결과는 테이블임. 테이블 전체를 비교하고 싶을때
    ALL 또는 ANY를 사용할 수 있음.
    ALL은 서브쿼리의 모든 행보다 몸무게가 작아야 함. 해당 식에는 최솟값.
    ANY는 서브쿼리의 한개만이라도 몸무게가 작으면 됨. 해당 식에서는 최댓값.
    부등호의 방향이 반대가되면 ALL이 최댓값, ANY는 최솟값이 됨.
*/




















