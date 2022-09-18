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
SELECT LPAD(salary, FLOOR((salary/1000))+ LENGTH(salary), '*')
FROM employees;



--12
SELECT COUNT(employee_id)
FROM employees
WHERE hire_date BETWEEN '20020301' AND '20030228'
GROUP BY department_id
ORDER BY COUNT(employee_id);

--13
SELECT job_id, AVG(salary)
FROM employees
GROUP BY job_id
HAVING NOT AVG(salary)> 10000
ORDER BY AVG(salary);

--14 ****
SELECT TO_CHAR(hire_date, 'MM')||'월' "입사달", COUNT(*)||' 명' "직원수"
FROM EMPLOYEES
GROUP BY TO_CHAR(hire_date, 'MM')
ORDER BY TO_CHAR(hire_date, 'MM');


--15
SELECT e.employee_id, 
e.last_name, 
j.job_title, 
d.department_name,
l.city
FROM departments d
    JOIN employees e
        ON e.department_id = d.department_id
    JOIN JOBS j
        ON e.job_id = j.job_id
    JOIN locations l
        ON d.location_id = l.location_id
WHERE l.city = 'London';

--16
SELECT e.last_name, d.department_name
FROM employees e,
departments d
WHERE last_name LIKE '%A%';

--17
SELECT  e.employee_id, e.last_name, e.salary, d.department_name
FROM employees e,
departments d
WHERE salary BETWEEN 3000 AND 5000
ORDER BY salary;

--18
SELECT e.last_name,TO_CHAR(e.hire_date,  'YYYY"년"MM"월"DD"일" DAY')
FROM employees e
    JOIN departments d
        ON e.department_id =  d.department_id
WHERE d.department_name = 'Accounting';

--19
SELECT *
FROM employees e
    JOIN departments d
        ON e.department_id =  d.department_id
WHERE NOT e.last_name = 'Landry';

--20
SELECT e.last_name, e.hire_date
FROM employees e
WHERE hire_date > (SELECT e2.hire_date
                FROM employees e2
                WHERE e2.last_name ='Lee');

--21
SELECT e.last_name, e.salary
FROM employees e
WHERE salary > (SELECT e2.salary
                FROM employees e2
                WHERE e2.last_name ='Lee')
ORDER BY salary;

--22
SELECT e.last_name, e.salary
FROM employees e
WHERE salary IN (SELECT e2.salary
                FROM employees e2
                WHERE e2.department_id = 50);
                
 --23
 SELECT e.employee_id, e.last_name, e.salary
 FROM employees e
 WHERE salary > (SELECT AVG(salary)
                FROM employees);
 
 --24
 SELECT e.employee_id, e.last_name
 FROM employees e
 WHERE e.department_id IN(SELECT e2.department_id
                            FROM employees e2
                            WHERE e2.last_name LIKE '%T%');
                            
--25   
SELECT e.employee_id, e.last_name,e.salary
 FROM employees e
 WHERE e.salary = (SELECT MAX(salary)
                    FROM employees e2
                    WHERE e2.department_id = 10);
                            
 --26
SELECT e.employee_id, e.last_name, e.salary, e.department_id
FROM employees e
WHERE salary > (SELECT MAX(e2.salary)
        FROM employees e2
        JOIN departments d
            ON e2.department_id = d.department_id
         WHERE e2.job_id = 'IT_PROG');
         
--27
SELECT e.employee_id, e.last_name, e.salary
FROM employees e
WHERE salary > (SELECT MAX(e2.salary)
        FROM employees e2
        JOIN departments d
            ON e2.department_id = d.department_id
         WHERE e2.last_name LIKE '%u%');
         
--28
SELECT job_id, AVG(salary)
FROM employees
GROUP BY job_id
HAVING AVG(salary) = (SELECT MIN(AVG(salary))
                FROM employees
                GROUP BY job_id);





                         
                
