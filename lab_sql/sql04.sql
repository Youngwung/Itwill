/*
    오라클 함수(function) 
    1. 단일 행 함수:
    행(row)이 하나씩 함수의 아규먼트로 전달되고, 
    행 마다 하나씩 결과가 리턴되는 함수.
    (예) to_date, to_char, lower, upper, ...
    
    2. 다중 행 함수:
    여러개의 행들이 함수의 아규먼트로 전달되고,
    하나의 결과가 리턴되는 함수.
    (예) 통계 관련 함수: count, sum, avg, max, min, variance(분산), stddev(표준편차)
*/

-- 단일 행 함수 예 - 모든 행의 문자열을 소문자로 바꾸기.
select ename, lower(ename), job, lower(job)
from emp;

-- to_char(...): 다른 타입의 값을 문자열로 변환. (예) 날짜 -> 문자열
select hiredate, to_char(hiredate, 'yyyy/mm/dd'), to_char(hiredate, 'mm-dd-yyyy') || '(미국식)'
from emp;

-- nvl(변수, 값): 변수가 null이면 두번째 아규먼트 값을 리턴하고, null이 아니면 원래 값을 리턴.
-- nvl2 (변수, 값1, 값2): 변수가 null이 아니면 값1을 리턴하고, 
-- 변수가 null이면 값2를 리턴.
select comm, nvl(comm, -1), nvl2(comm, comm, -1)
from emp;




-- 다중 행 함수 예: 
-- count(컬럼): null이 아닌 행의 개수를 리턴.
select count(empno), count(mgr), count(comm)
from emp;
-- 테이블의 행의 개수
select count(*) from emp;

-- 통계 함수: 합계, 평균, 최댓값, 최솟값, 분산, 표준편차
select sum(sal), round(avg(sal), 2), max(sal), min(sal), round(VARIANCE(sal), 2), round(STDDEV(sal), 2)
from emp; 

select sum(comm), round(avg(comm), 2) from emp; --> 원래 계산식에 null이 포함되면 계산 자체가 안되지만
--> 모든 통계함수는 null이 포함되어 있어도 계산이 가능.(null은 제외)
--> 평균은 null이 아닌 값만 count.

-- 단일 행 함수와 다중 행 함수는 함께 사용할 수 없음. 
-- (하나의 select 안에서 함께 사용할 수 없음)
--> 다중 행 함수의 리턴값은 한 개(보통 숫자)
----> 단일 행 함수의 리턴값은 테이블 그 자체이므로 행 개수가 달라져서 같이 사용할 수 없음.



select sysdate from dual; -- 더미테이블(dual) => sysdate를 저장하고 있는 테이블은 없는데 임시로 사용할 테이블
-- 더미테이블 사용법:
select lower('Allen') from dual; --> 함수의 리턴값이 무엇인 지 테스트하고 싶을 때 사용.


-- ALLEN, Allen, allen -> 어떤 형식으로 테이블이 작성되어있는 지 모름.

-- 이름이 'a'로 시작하는 직원들의 모든 정보
select *
from emp
where lower(ename) like 'a%'
order by ename asc;

-- 사번, 이름, 급여, 수당, 연봉(annual salary)을 검색
-- 연봉 = 급여 * 12 + 수당
select empno, ename, sal, comm, sal*12+nvl(comm,0) as "연봉" 
from emp;


-- 수업때 안배운 함수들 한번씩 쳐보기

-- 문자열에서 1번째 글자부터 3개의 글자를 추출
select substr('smith',1,3) --> 'smi'
from dual;

-- 문자열에서 i가 몇 번 째에 있는지 알려주는 함수.
select instr('smith','i') --> 3
from dual;

-- 문자열에서 0을 *로 바꾸기 -> 특정 철자를 다른 철자로 변경.
select replace('5000','0','*') --> 5***
from dual;

-- 특정 철자를 N개 만큼 채우기
-- 문자열에서 총 길이 10을 유지하면서 문자열 오른쪽을 *로 채움.
select rpad('5,000',10,'*') -- 5,000*****
from dual;
-- 왼쪽으로 채움
select lpad('5,000',10,'*') --*****5,000
from dual;

-- 응용방법
-- 월급을 시각화 하여 표시. 800이라면 100으로 나누어 8개의 도형으로 표시됨.
--> 월급의 크고 작음을 한 눈에 알아볼 수 있는 막대그래프처럼 표현할 수 있음.
select ename, sal, lpad('♥',round(sal/100) , '♥') as bar_chart
from emp;

-- 특정 철자 잘라내기
-- 문자열을 왼쪽부터 읽기 시작하여 's'문자열을 "1개" 제거한다.
select ltrim('smiths','s') --> miths
from dual;
-- rtrim도 마찬가지

-- trim 
-- 문자열의 모든 's'를 제거한다.
select trim ('smiths','s') --> mith
from dual;


-- 나눈 나머지 값 출력하기
--> 10을 3으로 나눈 나머지를 출력한다.
select mod(10,3) --> 1
from dual;

-- 날짜 간 개월 수 출력하기
--> 테이블의 입사일과 현재 시간까지 몇 개월인 지 소수점 단위로 출력.
select hiredate, round(months_between(sysdate, hiredate),2) as "몇 개월?" -->실행시켜봐
from emp
order by hiredate;

-- N개월 후의 날짜 출력
--> 현재로부터 100달 뒤의 날짜를 출력.
select add_months(sysdate, 100) --> 2024-04-22 기준 2032-08-22를 출력
from dual;

-- 특정 날짜 뒤에 오는 요일의 날짜를 출력
오늘 이후 바로 다음에 오는 '토요일'에 해당하는 날짜를 출력
select sysdate, next_day(sysdate, '토요일') --> 2024/04/22{월}  2024/04/27{토}
from dual;

-- 오늘부터 100달 후에 가장 빨리 오는 토요일 출력하기
select sysdate, next_day(add_months(sysdate, 100), '토요일') // 2024/04/22	2032/08/28
from dual;


-- 특정 날짜가 있는 달의 마지막 날짜 출력
select sysdate, last_day(sysdate) --2024/04/22	2024/04/30
from dual;


-- 문자형으로 데이터 유형 변환하기
--> 데이터의 출력 형식을 정할 수 있음
-- scott의 입사일을 '요일' 형태로 바꾸어 출력하고
-- scott의 월급을 [천 단위마다 콤마를 붙이는 데이터 형식]으로 출력함. => 999,999를 출력하는 게 아님.
--> 날짜는 비슷하게 rrrr을 쓰면 연도 4자리를 표시, mm을 쓰면 개월 2자리 표시 등등으로 이용할 수 있음.
select ename, to_char(hiredate,'day') as 요일, to_char(sal, '999,999') as 월급
from emp  --> SCOTT	일요일	   3,000
where lower(ename) = 'scott';

--연도/월/일 를 각각 테이블에 넣을 수 있는 함수
select ename as 이름,   extract(year from hiredate) as 연도,
                        extract(month from hiredate) as 달,
                        extract(day from hiredate) as 일
from emp;


select ename, deptno, decode(deptno, 10,300,20,400,0) as 보너스
from emp;


select ename, job, sal, 
    case when sal >= 3000 then 500
         when sal >= 2000 then 300
         when sal >= 1000 then 200
         else 0 end as 보너스
from emp
where job in ('SALESMAN', 'ANALYST');


-- 연습 끝---------------------------------------------------------



/*
    그룹별 쿼리(query) - [직업 별 급여 평균], [부서 별 급여 평균] 등의 그룹별로 데이터를 알고 싶을 때
    (예) 부서별 직원수, 부서별 급여 평균, ...
    (문법)
    select 컬럼, 함수호출,...
    from 테이블
    where 조건식(1)
    group by 컬럼이름(그룹을 묶을 수 있는 변수)
    having 조건식(2)
    order by 컬럼(정렬 기준)
    
    조건식(1): 그룹으로 묶기 전에 행들을 선택할 조건
    조건식(2): 그룹으로 묶은 후에 행들을 선택할 조건
    
   ************** select문의 실행 순서!************
    5. select 컬럼, 함수호출, ...
    1. from 테이블
    2. where 조건식(1)
    3. group by 컬럼
    4. having 조건식(2)
    6. order by 컬럼
    ***********************************************
    where: from에서 부른 원본 테이블에서 조건식에 만족하는 테이블을 만들어줌.
            ex) 급여가 1000 미만인 직원의 수를 출력하고싶을때. where + group by
    having: 그룹으로 묶은 후의 테이블에서 조건식에 만족하는 테이블을 만들어줌.
            ex) 부서별로 평균 급여가 2000이상인 부서만 출력하고 싶을 때. group by + having
*/


-- 부서별 급여 평균
select deptno, round(avg(sal), 2) as 평균 --, round(variance(sal), 2) as 분산, round(stddev(sal), 2) as 표준편차
from emp
group by deptno
order by deptno asc;


-- 부서별 급여 평균, 표준편차

select deptno, round(avg(sal), 2) as 평균, round(stddev(sal), 2) as 표준편차
from  emp
group by deptno
order by deptno asc;



-- 모든 문제에서 소수점은 반올림해서 소수점 이하 2자리까지 표시.
--Ex.  업무별 업무, 직원수, 급여 최댓값, 최솟값, 평균을 업무 오름차순으로 출력
select job, count(job) as COUNT, max(sal) as MAX_SAL, min(sal) as MIN_SAL, round(avg(sal), 2) as AVG_SAL
from emp
group by job
order by job asc;
--Ex. 부서별/업무별로 부서번호, 업무, 직원수, 급여 평균을 검색.
--  정렬 순서: (1) 부서번호 (2) 업무
select deptno, job, count(*) as COUNT, round(avg(sal), 2) as AVG_SAL
from emp
group by deptno, job
order by deptno, job;

-- Ex. 입사연도별 사원수를 검색. (힌트) to_char(날짜, 포맷) 이용.
select to_char(hiredate, 'rrrr') as YEAR, count(hiredate) as COUNT
from emp
group by to_char(hiredate, 'rrrr')
order by to_char(hiredate, 'rrrr');
-- Ex. 부서별 급여 평균 검색. 급여 평균이 2000 이상인 부서만 검색.
select deptno, round(avg(sal), 2) as AVG_SAL
from emp
group by deptno
having avg(sal) >= 2000
order by deptno;
-- Ex. mgr 컬럼이 null이 아닌 직원들 중에서 부서별 급여 평균을 검색.
--        정렬순서: 부서번호 오름차순.
select deptno, round(avg(sal), 2) as AVG_SAL
from emp
where mgr is not null 
group by deptno
order by deptno;

-- PRESIDENT는 제외하고 업무별 사원수를 검색. 
-- 업무별 사원수가 3명 이상인 업무들만 검색. 
-- 업무 이름 오름차순 정렬

--(1) president 조건식을 where에 넣는 방법
select job, count(job) as COUNT
from emp
where lower(job) != 'president'
group by job 
having count(job) >= 3 
order by job;
--(2) 'president 조건식을 having 넣는 방법
select job, count(job) as COUNT
from emp
group by job 
having count(job) >= 3 and lower(job) != 'president'
order by job;

-- ****두 경우가 모두 가능한 이유는 president는 그룹으로 묶은 job의 데이터


-- 입사연도별, 부서별 사원수 검색. 1980년은 검색에서 제외.
-- 연도별, 부서별 사원수가 2명 이상인 경우만 출력.
-- 정렬 순서: (1)연도, (2)부서

select to_char(hiredate,'rrrr') as YEAR, deptno, count(deptno) as COUNT
from emp
group by to_char(hiredate,'rrrr'), deptno
having to_char(hiredate,'rrrr') != '1980' and count(deptno) >= 2
order by to_char(hiredate,'rrrr'), deptno;






