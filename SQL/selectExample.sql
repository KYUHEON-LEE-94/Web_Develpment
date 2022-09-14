--사원정보 조회--
SELECT employee_id, phone_number, email
FROM employees;

-- SQL 연산--
SELECT employee_id, last_name, job_id
FROM employees
WHERE job_id IN ('SA_MAN', 'IT_PROG');

--BETWEEN 연산--
SELECT employee_id, last_name, job_id
FROM employees
WHERE hire_date BETWEEN '2005/01/01' AND '2005/12/31';

-- NULL을 비교할때는 무조건 IS or IS NOT 연산자를 사용해야한다.--
SELECT employee_id, last_name, commission_pct
FROM employees
WHERE commission_pct IS NULL;

SELECT employee_id, last_name, job_id
FROM employees
--WHERE last_name LIKE 'K%'; -- % : 0개이상의 문자
--WHERE last_name LIKE '%K%';
--WHERE last_name LIKE '%k';
--WHERE last_name LIKE 'K___'; -- _ : 임의의 한 문자
--WHERE last_name LIKE '_e%';
WHERE job_id LIKE 'IT\_%' ESCAPE '\';

--정렬 ORDER BY
SELECT employee_id, last_name, salary
FROM employees
ORDER BY salary DESC;
--ORDER BY salary DESC, last_name;

--그룹화 ORDER BY
--SELECT department_id
SELECT department_id, count(department_id) "부서별 사원수"
FROM employees
WHERE department_id > 30
GROUP BY department_id
--ORA-00937: not a single-group group function -> 그룹화가 안되면 count 함수를 사용할 수 없다는 의미
HAVING department_id IS NOT NULL -- -> 그룹에 대한 조건 지정
ORDER BY department_id;

-- UNION 실습을 위한 테이블 복사
CREATE TABLE emp AS
SELECT *
FROM employees;

SELECT * FROM employees
UNION
SELECT * FROM emp;

--UNION ALL
SELECT * FROM employees
UNION ALL
SELECT * FROM emp;



