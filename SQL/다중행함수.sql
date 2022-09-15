--������(�׷�) �Լ�-----------------------

-- ��ü �����(NULL�� ���� �ȵ�)
SELECT COUNT(employee_id) 
FROM employees;

-- ��ü �����(NULL ����)
SELECT COUNT(*) 
FROM employees;

-- Ŀ�̼� �޴� ����� ��
SELECT COUNT(commission_pct)
FROM employees;

SELECT COUNT(*) "��ü�����", COUNT(commission_pct) "Ŀ�̼ǻ����"
FROM employees;

-- �޿� �Ѿ�(NULL�� ����)
SELECT SUM(salary)
FROM employees;

-- �޿� ���(NULL�� ����)
SELECT ROUND(AVG(salary),2)
FROM employees;

-- Ŀ�̼� ���
SELECT AVG(commission_pct) "����Ȯ", AVG(NVL(commission_pct, 0)) "��Ȯ"
FROM employees;

-- �ִ밪, �ּҰ�
SELECT MAX(salary), MIN(salary), MAX(commission_pct), MIN(commission_pct)
FROM employees;

SELECT MAX(hire_date), MIN(hire_date), MAX(hire_date) - MIN(hire_date) "«����"
FROM employees;

-- GROUP BY ��(Ư�� �÷��� �������� �׷���)
SELECT department_id
FROM employees
GROUP BY department_id;

-- �μ��� �޿��Ѿ�, ���
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
ORDER BY AVG(salary);

-- HAVING ��(�׷쿡 ���� ����)
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