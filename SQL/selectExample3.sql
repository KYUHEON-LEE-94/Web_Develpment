--다중행 그룹 함수-----------------------

-- 전체 사원수(NULL은 포함 안됨)
SELECT COUNT(employee_id) FROM employees;

-- 전체 사원수(NULL 포함)
SELECT COUNT(*) FROM employees;

-- 커미션 받는 사원의 수
SELECT COUNT(commission_pct)
FROM employees;

SELECT COUNT(*) "전체사원수", COUNT(commission_pct) "커미션사원수"
FROM employees;

-- 급여 총액(NULL은 무시)
SELECT SUM(salary)
FROM employees;

-- 급여 평균(NULL은 무시)
SELECT AVG(salary)
FROM employees;

-- 커미션 평균
SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;