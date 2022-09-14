--������� ��ȸ--
SELECT employee_id, phone_number, email
FROM employees;

-- SQL ����--
SELECT employee_id, last_name, job_id
FROM employees
WHERE job_id IN ('SA_MAN', 'IT_PROG');

--BETWEEN ����--
SELECT employee_id, last_name, job_id
FROM employees
WHERE hire_date BETWEEN '2005/01/01' AND '2005/12/31';

-- NULL�� ���Ҷ��� ������ IS or IS NOT �����ڸ� ����ؾ��Ѵ�.--
SELECT employee_id, last_name, commission_pct
FROM employees
WHERE commission_pct IS NULL;

SELECT employee_id, last_name, job_id
FROM employees
--WHERE last_name LIKE 'K%'; -- % : 0���̻��� ����
--WHERE last_name LIKE '%K%';
--WHERE last_name LIKE '%k';
--WHERE last_name LIKE 'K___'; -- _ : ������ �� ����
--WHERE last_name LIKE '_e%';
WHERE job_id LIKE 'IT\_%' ESCAPE '\';

--���� ORDER BY
SELECT employee_id, last_name, salary
FROM employees
ORDER BY salary DESC;
--ORDER BY salary DESC, last_name;

--�׷�ȭ ORDER BY
--SELECT department_id
SELECT department_id, count(department_id) "�μ��� �����"
FROM employees
WHERE department_id > 30
GROUP BY department_id
--ORA-00937: not a single-group group function -> �׷�ȭ�� �ȵǸ� count �Լ��� ����� �� ���ٴ� �ǹ�
HAVING department_id IS NOT NULL -- -> �׷쿡 ���� ���� ����
ORDER BY department_id;

-- UNION �ǽ��� ���� ���̺� ����
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



