desc departments;

--부서테이블 입력
INSERT INTO departments(department_id, department_name, manager_id, location_id)
VALUES (7777, 'NAVER', NULL, NULL);

INSERT INTO departments(department_id, department_name, manager_id, location_id)
VALUES (2999, 'YAHOO', 53412, 1000);

INSERT INTO departments(department_id, department_name)
VALUES (8888, 'DAUM');

SELECT *
FROM departments;

--DD 조회
SELECT *
FROM user_tables;

SELECT *
FROM user_constraints
WHERE table_name = UPPER('departments');

--빈 테이블 생성
CREATE TABLE EMP2
AS SELECT *
    FROM employees
    WHERE 0 = 1;
--WHERE 절을 false로 하면 테이블 구조만 복사

INSERT INTO emp2
SELECT *
FROM employees;


--실습: employees 테이블에 내 정보 입력하기
INSERT INTO employees
VALUES (4330, 'KYUHEON', 'LEE', 'panpan68@naver.com', '01021124330', '22/1/12','IT_PROG', 2500, 0.1, 103, 60 );

UPDATE employees
SET phone_number = '010.2112.4330'
WHERE phone_number = '01021124330';

SELECT EMAIL
FROM employees
WHERE EMAIL LIKE 'pan%';


-- sequences 확인
select*
FROM user_sequences;

SELECT *
FROM employees;

--UPDATE
UPDATE emp2
SET salary = salary*1.5
WHERE salary > (SELECT AVG(salary)
                FROM employees);

DELETE FROM departments
WHERE department_name = 'GOOGLE';

DELETE FROM emp2
WHERE salary = (SELECT MAX(salary)
                FROM emp2);

--TCL
-- 연속적인 DML 처리를 파일에 반영
COMMIT;

--트랜잭션 시작
--INSERT ~~
--UPDATE ~~
--DELETE ~~
--COMMIT, ROLLBACK;

--트랜잭션 시작
INSERT INTO departments(department_id, department_name)
VALUES (departments_seq.NEXTVAL, 'Transaction');

UPDATE employees
SET department_id = 380
WHERE employee_id = 4330;

COMMIT;
--트랜잭션 종료

--스키마--
SELECT *
FROM hr.employees;

SELECT *
FROM departments;

