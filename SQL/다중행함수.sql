--다중행(그룹) 함수-----------------------

-- 전체 사원수(NULL은 포함 안됨)
SELECT COUNT(employee_id) 
FROM employees;

-- 전체 사원수(NULL 포함)
SELECT COUNT(*) 
FROM employees;

-- 커미션 받는 사원의 수
SELECT COUNT(commission_pct)
FROM employees;

SELECT COUNT(*) "전체사원수", COUNT(commission_pct) "커미션사원수"
FROM employees;

-- 급여 총액(NULL은 무시)
SELECT SUM(salary)
FROM employees;

-- 급여 평균(NULL은 무시)
SELECT ROUND(AVG(salary),2)
FROM employees;

-- 커미션 평균
SELECT AVG(commission_pct) "부정확", AVG(NVL(commission_pct, 0)) "정확"
FROM employees;

-- 최대값, 최소값
SELECT MAX(salary), MIN(salary), MAX(commission_pct), MIN(commission_pct)
FROM employees;

SELECT MAX(hire_date), MIN(hire_date), MAX(hire_date) - MIN(hire_date) "짬밥차"
FROM employees;

-- GROUP BY 절(특정 컬럼을 기준으로 그룹핑)
SELECT department_id
FROM employees
GROUP BY department_id;

-- 부서별 급여총액, 평균
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
ORDER BY AVG(salary);

-- HAVING 절(그룹에 대한 조건)
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING department_id = 10;

SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary) >= 3000;

SELECT department_id, MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) > 20000;

SELECT hire_date, COUNT(*)
FROM employees
GROUP BY hire_date
ORDER BY hire_date;
--ORDER BY COUNT(*);