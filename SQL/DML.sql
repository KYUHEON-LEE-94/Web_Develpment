desc departments;

--부서테이블 입력
INSERT INTO departments(department_id, department_name, manager_id, location_id)
VALUES (7777, 'NAVER', NULL, NULL);

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

