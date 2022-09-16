-- 서브쿼리를 사용하지 않을 경우
SELECT salary
FROM employees
WHERE LOWER(last_name) = 'seo';

SELECT last_name, salary, hire_date
FROM employees
WHERE salary = 2700;

---단일행 서브쿼리

SELECT last_name, salary, hire_date
FROM employees
WHERE salary = (SELECT salary 
                FROM employees
                WHERE LOWER(last_name) = 'seo');
-- seo과 같은 연봉을 받는 사람을 찾아와라~


SELECT last_name, salary, hire_date
FROM employees
WHERE salary > (SELECT AVG(salary)
                FROM employees);
                
--다중행 서브쿼리---------------------------------------------------
-- IN 연산자
-- 30번 부서에 소속된 사원들과 동일한 업무를 가지는 전체 사원목록 조회
SELECT last_name,
job_id,
department_id
FROM employees
WHERE job_id IN (SELECT job_id
                FROM employees
                WHERE department_id = 30);

-- ANY 연산자
SELECT *
FROM employees
WHERE salary > ANY(SELECT salary
                    FROM employees
                    WHERE department_id = 30);

SELECT *
FROM employees
WHERE salary > (SELECT MIN(salary)
                FROM employees
                WHERE department_id = 30);
                
-- ALL
SELECT *
FROM employees
WHERE salary > ALL(SELECT salary
                    FROM employees
                    WHERE department_id = 30);

-- EXISTS 연산자
SELECT *
FROM employees
WHERE EXISTS(SELECT *
            FROM departments
            WHERE department_id = 30)
AND department_id = 30;

--다중컬럼 서브쿼리--------------------------------
SELECT *
FROM employees
WHERE (department_id, salary) IN(SELECT department_id, MIN(salary)
                                FROM employees
                                GROUP BY department_id)
ORDER BY department_id;


--인라인 뷰
-- 서브쿼리가 하나의 테이블처럼 사용되는 경우
SELECT e.employee_id, e.first_name, e.department_id, e.salary
FROM employees e
JOIN (SELECT department_id, MAX(salary) maxsal
        FROM employees
        GROUP BY department_id) i
    ON e.department_id = i.department_id
            AND e.salary = i.maxsal;

--스칼라 서브쿼리
--하나의 컬럼처럼 사용하는 서브쿼리로 SELECT 절에서 서브쿼리를 사용한다
--행별로 서브쿼리가 실행되기 떄문에 성능이 좋지 않음
SELECT employee_id,
first_name,
(SELECT department_name
FROM departments d
WHERE d.department_id = e.department_id) "department_name"
FROM employees e;

-- 상호연관 서브쿼리
-- 부서별 평균급여보다 많은 급여를 받는 사원 정보 조회
SELECT department_id, employee_id, last_name, salary, job_id
FROM employees e1
WHERE salary > (SELECT AVG(salary)
                FROM employees e2
                WHERE e2.department_id = e1.department_id)
ORDER BY e1.department_id;


SELECT e1.department_id, employee_id, last_name, salary, job_id
FROM employees e1
JOIN(SELECT department_id, AVG(salary) avg
                FROM employees
                GROUP BY department_id) el2
    ON e1.department_id = el2.department_id
AND e1.salary > el2.avg
ORDER BY e1.department_id;

