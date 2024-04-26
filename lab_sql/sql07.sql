/*
    SQL 종류: 
    1. DQL(Data Query Language): select --> 데이터 질문 언어: 테이블의 내용이 변경되지 않고 검색만 함.
    2. DML(Data Manipulation Language): insert, update, delete --> 데이터 조작 언어: 테이블의 내용이 변경됨.
    3. DDL(Data Definition Language): create, alter, truncate, drop --> 데이터 정의 언어: ...
    4. TCL(Tracnsaction Control Language): commit, rollback
        - commit: 데이터베이스 테이블의 변경 내용을 영구 저장.
        - rollback: 직전의 commit 상태로 되돌리기.
        
    테이블 생성:
    create table 테이블 이름 (
        컬럼이름 데이터타입 [제약조건 기본값], --> []는 생략이 가능하다는 의미
        ...
    );
    
    컬럼의 데이터타입으로 사용되는 키워드는 데이터베이스 종류에 따라서 다름.
    오라클 데이터 타입: number, varchar2, date, timestamp, clob, blob, ...
        varchar: 배열처럼 크기가 정해져있고 최대로 저장하지 않아도 메모리 사용량이 줄어들지 않음.
        varchar2 : 리스트처럼 길이가 늘어날 때마다 메모리 사용량이 증가. 최댓값은 정해져있음.
        clob(character large object): 문자(char)로 이루어져있는 큰 객체. 
            -- varchar2의 최대 길이(메모리제한)보다 큰 문자열을 저장하고 싶을 때 사용. (최대 메모리 양이 GB단위임)
        blob(binary large object): mp3, mp4, jpg, ... 등의 파일들을 저장하는 객체.
            -- 이것을 사용하면 DB의 성능이 많이 떨어짐. 사용 안하는걸 권장
                -- 그럼 mp3같은 파일 저장하고 싶으면 어캄?
                -- mp3 파일같은 미디어 파일들만을 저장하는 미디어 DB를 따로 만들어두고 
                -- 이 미디어파일들을 찾아가는 경로(문자열)로 제공하는 방법을 추천.
*/

/*
    테이블 이름: ex_students
    컬럼:
     - stuno: 학생 번호(학번), 숫자(6자리)
     - stuname: 학생의 이름, 문자열(4글자)
     - birthday: 생일, 날짜
*/

create table ex_students (
    stuno number(6),
    stuname varchar2(4 char),
    birthday date
);

/*
    테이블에 행 추가(insert, 삽입):
    insert into 테이블이름 (컬럼, ...) values (값, ...);
    
    테이블에 삽입하는 값의 개수가 컬럼의 개수와 같고, 
    값들의 순서가 테이블 생성 시 컬럼 순서와 같으면
    다음과 같이 간단하게 작성할 수 있음.
    insert into 테이블 values (값, ...);
*/
select * from ex_students;

insert into ex_students
values (241001,'홍길동','2000/12/31');

insert into ex_students (stuno, stuname)
values (241002,'오쌤');

insert into ex_students values ('abcd',1,sysdate);
--> 실행 중 오류: 'abcd' 문자열은 학번(숫자 타입)이 될 수 없기 때문.
insert into ex_students values (1, 'abcd');
--> 실행 중 오류: 테이블의 컬럼 개수와 values의 값들의 개수가 다름.
----> 간단하게 쓰고싶으면 값들을 넣을 때 테이블의 전체 컬럼 개수와 타입을 맞춰야 한다.
insert into ex_students (stuname, stuno, birthday)
values ('abcd', 1, sysdate);
--> 테이블 이름 뒤에 컬럼 이름을 나열한 경우, 테이블의 컬럼 순서를 지킬 필요는 없음. 
    --나열한 순서와 타입을 지키면 됨. => 컬럼 순서와 values의 순서를 맞춰주면 됨.
    
insert into ex_students (stuno) values (1234567);
--> 실행 중 오류: stuno 컬럼의 숫자 자리수보다 크기 때문에.
insert into ex_students (stuname) values ('가나다라마');
--> 실행 중 오류: stuname 컬럼은 최대 4글자(char)까지만 저장할 수 있기 때문에.


commit; --> 현재까지의 insert내용을 DB 테이블에 영구 저장.
create table ex_test_byte (
    ctest varchar2(4 byte)
);

insert into ex_test_byte values ('abcd'); --> 성공
insert into ex_test_byte values ('한글'); --> 실패: 열에 대한 값이 너무 큼(실제: 6, 최대값: 4)
-- 오라클에서 문자열을 저장할 때 인코딩: UTF-8
-- UTF-8 일 때, 영문자/숫자/특수기호 1byte, 한글 3byte.
select* from ex_test_byte;

-- 테이블을 생성할 때 컬럼에 기본값 설정하기:
create table ex_test_default (
    tno number(4),
    tdate date default sysdate
);

insert into ex_test_default values (1,'2024-03-14');
insert into ex_test_default (tdate) values ('2024-03-15');
insert into ex_test_default (tno) values (2);

select *from ex_test_default;
commit;

/*
    테이블을 생성할 때 제약조건(constraint) 만들기:
    (1) primary jey(PK, 고유키) - 중복불가, null값 불가. 
        -- not null과 unique를 사용하면 비슷한 효과가 나오지만
        -- 고유키 라고 명시적으로 써줘야 객체같은게 생성되는듯?
    (2) not null(NN) - null값 불가
    (3) unique - 중복불가
    (4) check - 조건식을 사용할 수 있음.
        -ex) 문자열의 길이가 4이상, 숫자가 20 이상 , ... 등
    (5) foreign key (FK, 외래키) - 다른 테이블의 고유키를 찾아가는 값.
            --> null가능, 중복가능
            --> emp테이블의 deptno는 외래키. dept테이블의 고유키인 deptno를 찾아갈 수 있음.
*/

-- 테이블 생성할 때 제약조건 만들기 1: 제약조건 이름 설정하지 않기.
create table ex_emp1 (
    eno     number(4) primary key,          -- 사번. 고유키.
    ename   varchar2(10) not null,          -- 이름. 문자열 길이 자리에 단위를 안써주면 byte.
    email   varchar2(100) unique,           -- 이메일
    age     number(3) check (age >= 0),     -- 나이
    memo    varchar2(1000)                  -- 메모. 제약조건 없음
);

insert into ex_emp1
values (1001, '홍길동', 'hgd@itwill.com', 16, '안녕하세요');

insert into ex_emp1 (eno, ename)
values (1002, '허균');

insert into ex_emp1 (eno, ename)
values (1002, 'abc'); 
--> 실행중 오류. 무결성 제약조건에 위배됩니다. => eno는 고유키라 중복이 불가함.

insert into ex_emp1 (eno)
values (1003);
--> 실행 중 오류. ename에는 null을 삽입할 수 없습니다.
--> NN 제약조건 위배

insert into ex_emp1 (eno, ename, email)
values (1003, 'John Doe', 'hgd@itwill.com');
--> 실행 중 오류. 무결성 제약 조건에 위배됩니다. 
--> email은 unique 제약조건이 있어 중복된 값을 삽입할 수 없다.

insert into ex_emp1 (eno, ename, age)
values (1003, 'Scott', -1);
--> 실행 중 오류. 체크 제약조건이 위배되었습니다.
--> age는 check 제약조건(age >= 0) 이 있어 음수를 삽입할 수 없다.


select * from ex_emp1;

commit;

-- 제약조건 만들기 설정 2: 제약조건 이름 설정
create table ex_emp2 (
    id      number(4) constraint ex_emp2_pk_id primary key, -- 제약조건이름 권장형식: 테이블이름_제약조건이름_컬럼이름
    ename   varchar2(10) constraint ex_emp2_nn_ename not null,
    email   varchar2(100) constraint ex_emp2_uq_email unique,
    age     number(3) constraint ex_emp2_ck_age check (age >= 0),
    memo    varchar2(1000)
);

insert into ex_emp2(id, ename)
values (1, '홍길동');
insert into ex_emp2(id, ename)
values (1, '오쌤'); --> 오류메세지만 보고 무슨 제약조건을 위배했는 지 알 수 있다. PK_ID

select * from ex_emp2;
commit;

-- 제약조건 만들기 3: 컬럼 정의 따로, 제약조건 정의 따로.

create table ex_emp3 (
    -- 컬럼 정의: 컬럼 이름 & 데이터 타입
    id      number(4),
    ename   varchar2(10),
    email   varchar2(100),
    age     number(3),
    memo    varchar2(1000),
    -- 제약 조건 정의
    constraint ex_emp3_pk_id primary key (id), --> 괄호가 없으면 무슨 컬럼의 제약조건인지 모르기 때문.
    constraint ex_emp3_nn_ename check (ename is not null), --> 이 형태로 NN을 쓰고싶다면 check로 제약조건을 걸어야함.
    constraint ex_emp3_uq_email unique (email),
    constraint ex_emp3_ck_age check (age >= 0)
);


-- FK(Foreign Key, 외래키): 다른 테이블의 PK를 참조하는 제약조건. 
-- 데이터를 insert할 때, 다른 테이블의 PK에 없는 값이 삽입되지 않도록.
-- 테이블을 만들 때 FK를 설정하려면, PK가 설정된 다른 테이블이 먼저 생성되어 있어야 함.


create table ex_dept (
    deptno  number(2)
    constraint ex_dept_pk_deptno primary key,
    dname   varchar2(10)
    constraint ex_dept_nn_dname not null
);

create table ex_emp4 (
    empno   number(4)
            constraint ex_emp4_pk_empno primary key,
    ename   varchar(10)
            constraint ex_emp4_nn_ename not null,
    deptno  number(2)
            constraint ex_emp4_fk_deptno references ex_dept (deptno) --> FK설정하는 문법.
);



insert into ex_emp4 values (1200, '오쌤', 10);
--> 10번 부서가 ex_dept 테이블에 없는 경우에는 insert 실패! FK 위배.
--> 10번 부서가 ex_dept 테이블에 있는 경우에는 insert 성공!

insert into ex_dept values (10, '개발1팀');

insert into ex_emp4 (empno, ename) values (1300, '홍길동');
--> FK 제약조건이 있는 컬럼에는 null이 삽입될 수도 있음.

insert into ex_emp4 values (1400, 'Jake', 10);
--> FK 제약조건이 있는 컬럼에는 중복된 값이 삽입될 수도 있음.


select * from ex_dept;
select * from ex_emp4;

-- 컬럼 정의 따로, FK 제약조건 설정 따로
create table ex_emp5 (
    -- 컬럼 정의:
    empno number(4),
    ename varchar(10),
    deptno number(2),
    -- 제약조건 정의:
    constraint ex_emp5_pk_empno primary key (empno),
    constraint ex_emp5_nn_ename check (ename is not null),
    constraint ex_emp5_fk_deptno foreign key (deptno) references ex_dept (deptno)
    --> fk e.deptno는 pk d.deptno를 참조한다는 문법
    --> 따로써줄때는 자기 테이블의 컬럼이름도 알려줘야 하므로 더 복잡해지는듯.
); 



-- 오라클은 테이블들을 관리하기 위한 테이블을 가지고 있음.
select * from user_tables;

-- 오라클은 제약조건들을 관리하기 위한 테이블을 가지고 있음.
select * from user_constraints;
select constraint_name from user_constraints;
