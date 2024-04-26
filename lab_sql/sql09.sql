/*
    DDL(Date Definition Language): create, alter, truncate, drop
    DML(Data Manipulation Language): insert, update, delete
*/

-- create table ... as select ...
-- 테이블 모양(컬럼 이름, 데이터 타입)과 데이터를 복사
-- emp 테이블을 ex_emp6으로 복사:
create table ex_emp6 as select * from emp;

select * from ex_emp6;

-- emp 테이블의 모양과 똑같은 테이블을 생성, 데이터(행)는 복사하지 않을 수 있음.
create table ex_emp7 as select * from emp where empno = -1; -- where에 절대 만족할 수 없는 조건을 걸어두면 데이터는 안들어옴
-- 고유키를 선택하고 고유키에 없는 값을 선택하면 편함.
select * from ex_emp7;


-- truncate table: 테이블의 모든 행을 삭제하는 DDL. 행이 차지하고있던 공간(메모리) 자체를 삭제함.
select * from ex_emp6; --> 데이터가 있었음.
truncate table ex_emp6; --> ~가 잘렸습니다. 메세지 출력.


-- drop table: 테이블을 삭제하는 DDL
drop table ex_emp7; --> ~~가 삭제되었습니다. 메시지 출력.


-- DML 
-- insert into 테이블 (컬럼, ...) values (값, ...);
----> 테이블에 1개 행을 삽입(insert)
-- insert into 테이블 (컬럼, ...) select ...;
----> select 결과만큼 여러개의 행들을 삽입(insert)


-- emp 테이블에서 부서번호가 10번인 행들을 ex_emp6에 삽입:
select * from ex_emp6;
insert into ex_emp6 
select * from emp where deptno = 10;

-- emp 테이블에서 수당(comm)이 null 아닌 행들을 bonus 테이블에 삽입:
insert into bonus
select ename, job, sal, comm
from emp where comm is not null;

select * from bonus;

commit;


-- update 문장: 테이블 데이터 업데이트(수정)
-- update 테이블 set 변수 = 값, ... where 조건식;
select * from emp;

-- emp 테이블에서 사번이 1004인 직원의 급여를 6000으로 변경:
update emp set sal = 6000 where empno = 1004;

-- where 조건식이 없으면 update 문장은 테이블의 '모든 행'의 값을 업데이트함.
commit; -- 현재까지 모든 변경 내용을 영구히 저장.
update emp set sal = 6000; -- emp의 모든 행의 sal을 6000으로 바꿔버림. 큰일남
select * from emp; --> 모든 행의 sal이 6000으로 되버린걸 확인
rollback; --> 직전의 commit 상태로 되돌림.
select * from emp; --> 6000으로 업데이트한 부분을 되돌림.
-->그 전에 사번 1004의 sal을 6000으로 올렸던 부분은 되돌아가지 않음.

-- 사번이 1004인 직원의 업무를 'MANAGER', 입사 날짜를 '2024/04/25'로 변경
update emp 
set job = 'MANAGER', 
hiredate = to_date('2024/04/25') 
where empno = 1004;

select * from emp;

commit;

-- 'ACCOUNTING' 부서에서 일하는 직원들의 급여를 10% 인상:
update emp set sal = sal * 1.1 where deptno = (
    select deptno
    from dept
    where dname = 'ACCOUNTING'
);
select * from emp;

-- salgrade가 1인 직원들의 급여를 25% 인상:
update emp set sal = sal * 1.25 where sal >= (
   select losal
   from salgrade
   where grade = 1
) and sal <= (
    select hisal
    from salgrade
    where grade = 1
);

select * from emp
where sal between 700*1.25 and 1200*1.25;

commit;
--delete 문: 테이블에서 행 삭제(DML). 행의 내용만을 지우고 행이 있던 공간(메모리)는 남겨둠.
-- delete from 테이블 [where 조건식];
-- where 조건식을 쓰지 않으면 테이블의 모든 행이 삭제됨.

-- emp 테이블에서 사번이 1004인 직원 정보를 삭제:
delete from emp where empno = 1004;
select * from emp;
commit;

delete from emp; -- 다 삭제되버림. 롤백ㄱㄱ
select * from emp; 
rollback;

-- emp테이블에서 1987년에 입사한 사원들을 삭제:
delete from emp
where to_char(hiredate, 'rrrr') = '1987';

select * from emp
order by hiredate desc; 
rollback;



