-- ���������� ������� ���� ���
SELECT salary
FROM employees
WHERE LOWER(last_name) = 'seo';

SELECT last_name, salary, hire_date
FROM employees
WHERE salary = 2700;

---������ ��������

SELECT last_name, salary, hire_date
FROM employees
WHERE salary = (SELECT salary 
                FROM employees
                WHERE LOWER(last_name) = 'seo');
-- seo�� ���� ������ �޴� ����� ã�ƿͶ�~


SELECT last_name, salary, hire_date
FROM employees
WHERE salary > (SELECT AVG(salary)
                FROM employees);
                
--������ ��������---------------------------------------------------
-- IN ������
-- 30�� �μ��� �Ҽӵ� ������ ������ ������ ������ ��ü ������ ��ȸ
SELECT last_name,
job_id,
department_id
FROM employees
WHERE job_id IN (SELECT job_id
                FROM employees
                WHERE department_id = 30);

-- ANY ������
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

-- EXISTS ������
SELECT *
FROM employees
WHERE EXISTS(SELECT *
            FROM departments
            WHERE department_id = 30)
AND department_id = 30;

--�����÷� ��������--------------------------------
SELECT *
FROM employees
WHERE (department_id, salary) IN(SELECT department_id, MIN(salary)
                                FROM employees
                                GROUP BY department_id)
ORDER BY department_id;


--�ζ��� ��
-- ���������� �ϳ��� ���̺�ó�� ���Ǵ� ���
SELECT e.employee_id, e.first_name, e.department_id, e.salary
FROM employees e
JOIN (SELECT department_id, MAX(salary) maxsal
        FROM employees
        GROUP BY department_id) i
    ON e.department_id = i.department_id
            AND e.salary = i.maxsal;

--��Į�� ��������
--�ϳ��� �÷�ó�� ����ϴ� ���������� SELECT ������ ���������� ����Ѵ�
--�ະ�� ���������� ����Ǳ� ������ ������ ���� ����
SELECT employee_id,
first_name,
(SELECT department_name
FROM departments d
WHERE d.department_id = e.department_id) "department_name"
FROM employees e;

-- ��ȣ���� ��������
-- �μ��� ��ձ޿����� ���� �޿��� �޴� ��� ���� ��ȸ
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

