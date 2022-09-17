--1.
SELECT employee_id, last_name, salary, hire_date
FROM employees 
WHERE NOT(salary BETWEEN 5000 AND 15000);

--2
SELECT employee_id, last_name, job_id, hire_date
FROM employees 
WHERE department_id= 50 AND job_id='ST_MAN' AND hire_date ='2004-07-18';

--3
SELECT *
FROM employees
WHERE hire_date > '2022/01/01' AND job_id ='ST_MAN' OR hire_date = '2004-07-18';

--4
SELECT *
FROM employees
WHERE manager_id IS NULL;

--5
SELECT last_name, salary
FROM employees
WHERE (last_name LIKE 'J%'
    OR last_name LIKE 'A%'
    OR last_name LIKE 'M%')
ORDER BY last_name ASC;

--6
SELECT TO_CHAR(hire_date, 'YYYY'), COUNT(hire_date)
FROM employees
GROUP BY TO_CHAR(hire_date, 'YYYY');

--7
SELECT *
FROM employees
WHERE MOD(employee_id, 2) =1;

--8
SELECT SYSDATE "오늘", TO_CHAR(NEXT_DAY(ADD_MONTHS(SYSDATE,6), 7),'YYYY/MM/DD HH24:MI:SS DAY') "6개월 후 토요일"
FROM dual;

--9
SELECT employee_id, first_name, NVL2(TO_CHAR(manager_id), TO_CHAR(manager_id), '대빵')
FROM employees;
-- manager_id는 숫자형이기 때문에 형변환이 필요하다.

--10
SELECT first_name,
employee_id,
CASE
WHEN MOD(employee_id,3)=0 THEN '영화배우팀'
WHEN MOD(employee_id,3)=1 THEN '개그맨팀'
WHEN MOD(employee_id,3)=2 THEN '가수팀'
END "팀이름"
FROM employees;

--11
SELECT first_name,salary,
CASE
WHEN CEIL((salary/1000))=3 THEN '***'
WHEN CEIL((salary/1000))=4 THEN '****'
WHEN CEIL((salary/1000))=5 THEN '*****'
END "달러"
FROM employees;

SELECT first_name,TO_CHAR(salary,'999999')
FROM employees;