--������ �׷� �Լ�-----------------------

-- ��ü �����(NULL�� ���� �ȵ�)
SELECT COUNT(employee_id) FROM employees;

-- ��ü �����(NULL ����)
SELECT COUNT(*) FROM employees;

-- Ŀ�̼� �޴� ����� ��
SELECT COUNT(commission_pct)
FROM employees;

SELECT COUNT(*) "��ü�����", COUNT(commission_pct) "Ŀ�̼ǻ����"
FROM employees;

-- �޿� �Ѿ�(NULL�� ����)
SELECT SUM(salary)
FROM employees;

-- �޿� ���(NULL�� ����)
SELECT AVG(salary)
FROM employees;

-- Ŀ�̼� ���
SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;