--DDL
CREATE TABLE students(
    ssn NUMBER CONSTRAINT stu_ssn_pk  PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    korean  NUMBER    DEFAULT 0 CONSTRAINT stu_kor_ck  CHECK(korean BETWEEN 0 AND 100),
    english NUMBER    DEFAULT 0 CONSTRAINT stu_eng_ck  CHECK(english BETWEEN 0 AND 100),
    math    NUMBER    DEFAULT 0 CONSTRAINT stu_math_ck CHECK(math BETWEEN 0 AND 100)
);

SELECT *
FROM user_tables;

SELECT *
FROM user_constraints
WHERE table_name = UPPER('students');

DROP TABLE SAWON;

--#1. 테이블 구조만 생성
CREATE TABLE sawon (
id NUMBER(5),
name VARCHAR2(10) NOT NULL,
gender CHAR(1) NOT NULL,
hiredate DATE DEFAULT SYSDATE,
manager_id NUMBER(6)
);

--#2. 제약조건 추가
ALTER TABLE sawon
ADD ( CONSTRAINT sawon_id_pk PRIMARY KEY(id),
      CONSTRAINT sawon_gender_ck CHECK (gender IN('M', 'F')),
      CONSTRAINT sawon_mgid_fk FOREIGN KEY(manager_id) REFERENCES employees(employee_id));


SELECT * FROM user_constraints
WHERE table_name = 'SAWON';

--#3. 개발의 편의성을 위해  제야조건 비활성화/활성화
ALTER TABLE sawon
DISABLE CONSTRAINT sawon_id_pk CASCADE
DISABLE CONSTRAINT sawon_gender_ck
DISABLE CONSTRAINT sawon_mgid_fk;

ALTER TABLE sawon
ENABLE CONSTRAINT sawon_id_pk
ENABLE CONSTRAINT sawon_gender_ck
ENABLE CONSTRAINT sawon_mgid_fk;

--테이블에 컬럼 추가
ALTER TABLE emp
    ADD(address VARCHAR2(50));

ALTER TABLE emp
    MODIFY(address VARCHAR2(100));
    
--컬럼 삭제
ALTER TABLE emp
    DROP COLUMN address;

--제약조건 삭제
ALTER TABLE emp
    DROP CONSTRAINT SYS_C006997;
    --DROP CONSTRAINT pk제약조건 CASCADE;
    
SELECT * FROM user_constraints
WHERE table_name = 'EMP';

-- 시퀸스 생성
CREATE SEQUENCE stu_seq
    START WITH 1
    INCREMENT BY 1;

SELECT *
FROM user_sequences;

--시퀸스 이용
INSERT INTO students(ssn,name, korean,english,math)
VALUES (stu_seq.NEXTVAL, '이규헌', 90, 80,100);

INSERT INTO students(ssn,name, korean,english,math)
VALUES (stu_seq.NEXTVAL, '리트리버', 50, 60,70);

COMMIT;

SELECT *
FROM students;


--딕셔너리로부터 뷰 조회

SELECT *
FROM user_views;

CREATE OR REPLACE VIEW emp_view
AS SELECT employee_id, last_name, department_id
FROM employees
WHERE department_id = 10;

-- 뷰에서 데이터 조회
SELECT * FROM emp_view;

CREATE OR REPLACE VIEW emp_simple_view
AS SELECT employee_id, last_name, salary, hire_date
FROM employees;

SELECT * FROM emp_simple_view;

DROP VIEW emp_simple_view;

CREATE OR REPLACE VIEW emp_view
    AS SELECT e.employee_id id,
            e.first_name name,
            j.job_title,
            d.department_name dname,
            l.city city
    FROM employees e
        JOIN jobs j
            ON e.job_id = j.job_id
        JOIN departments d
            ON e.department_id = d.department_id
        JOIN locations l
            ON d.location_id = l.location_id;

SELECT * FROM emp_view;


-- 10번 부서의 사원에 대해서만 INSERT, UPDATE 할 수 있는 뷰 생성
CREATE OR REPLACE VIEW emp_view
AS SELECT employee_id, last_name, email, hire_date, job_id, department_id
FROM employees
WHERE department_id = 10
WITH CHECK OPTION;

INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'jack', 'jack@korea.com', sysdate, 'AD_VP', 10);
-- INSERT ERROR
INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'king', 'jack@korea.com', sysdate, 'AD_VP', 20);

SELECT ROWNUM, employee_id
FROM emp_view;