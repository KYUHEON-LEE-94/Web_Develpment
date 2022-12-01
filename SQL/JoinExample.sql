-- CROSS JOIN----------------------------------------------
-- 하나의 사원은 27개 모든 부서에 소속될 수 있다 (107*27=2889)
SELECT
    first_name,
    department_name
FROM
    employees,
    departments;

-- 조인 시 컬럼명의 모호성을 해결하기 위해 테이블명이나 별칭 사용을 권장
SELECT
    employees.first_name,
    departments.department_name
FROM
    employees,
    departments;

SELECT
    e.first_name,
    d.department_name
FROM
    employees   e,
    departments d;

-- DBMS간의 호환을 위해 ANSI(미국규격협회)에서 제시한 표준 CROSS JOIN 구문 (오라클 9i부터 지원)
SELECT
    e.employee_id,
    e.last_name,
    d.department_name
FROM
         employees e
    CROSS JOIN departments d;
    
--INNER JOIN--------------------------------------------------
--Equi JOIN

-- 3개이상 테이블 조인(딕셔너리(테이블)로부터 테이블 종류 조회)
SELECT
    *
FROM
    user_tables;
    
-- 오라클 조인---
SELECT
    e.employee_id,
    e.last_name,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;    
    
-- ANSI 조인
SELECT
    e.employee_id,
    e.last_name,
    d.department_name
FROM employees e
    JOIN departments d ON e.department_id = d.department_id;


SELECT
    e.employee_id id,
    e.last_name name,
    e.salary salary,
    d.department_name dname,
    l.city city
FROM
         employees e
    JOIN departments d 
    ON e.department_id = d.department_id
    JOIN locations   l 
    ON d.location_id = l.location_id;
    
-- NON-EQUI JOIN------------
-- 테스트를 위한 급여등급(salgrace) 테이블 생성
CREATE TABLE salgrade(grade NUMBER,
losal NUMBER,
hisal NUMBER);

-- 데이터 입력
INSERT INTO salgrade VALUES (1, 2001, 3000);
INSERT INTO salgrade VALUES (2, 3001, 4000);
INSERT INTO salgrade VALUES (3, 4001, 5000);
INSERT INTO salgrade VALUES (4, 5001, 6000);
INSERT INTO salgrade VALUES (5, 6001, 100000);
COMMIT;

-- 오라클 NON-EQUI JOIN 구문
SELECT e.employee_id, e.last_name, e.salary, s.grade
FROM employees e, salgrade s
WHERE e.salary BETWEEN s.losal AND s.hisal
ORDER BY s.grade DESC;


SELECT e.employee_id, e.last_name, e.salary, s.grade
FROM employees e
JOIN salgrade s
ON salary BETWEEN losal AND hisal
ORDER BY s.grade DESC;


------------------OUTER JOIN-------------------------------------------
-- 오라클 OUTER JOIN에서는 조인 시킬 값이 없는 쪽에 (+) 기호를 추가한다
-- employees 테이블에에서 부서번호가 NULL 인 Kimberely는 EQUI Join만으로는 검색되지 않음
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- 부서번호가 없는 사원도 조회
-- 오라클 OUTER JOIN
SELECT e.employee_id,
e.first_name,
e.last_name,
d.department_name
FROM employees e,
departments d
WHERE e.department_id = d.department_id(+);

---ANSI---------------------
-- LEFT OUTER JOIN
SELECT e.last_name,
d.department_name
FROM employees e
LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;

-- RIGHT OUTER JOIN
SELECT e.last_name,
d.department_name
FROM employees e
RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id;

-- FULL OUTER JOIN
SELECT e.first_name,
d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON e.department_id = d.department_id;


---Self JOIN--------------------------------
-- ANSI 표준 SELF JOIN
SELECT e.first_name , m.first_name "BOSS"
FROM EMPLOYEES e
LEFT OUTER JOIN EMPLOYEES m
ON e.manager_id = m.employee_id;

