-- CROSS JOIN----------------------------------------------
-- �ϳ��� ����� 27�� ��� �μ��� �Ҽӵ� �� �ִ� (107*27=2889)
SELECT
    first_name,
    department_name
FROM
    employees,
    departments;

-- ���� �� �÷����� ��ȣ���� �ذ��ϱ� ���� ���̺���̳� ��Ī ����� ����
SELECT
    employees.first_name,
    departments.department_name
FROM
    employees,
    departments;

SELECT
    e.first_name,
    d.department_name
FROM
    employees   e,
    departments d;

-- DBMS���� ȣȯ�� ���� ANSI(�̱��԰���ȸ)���� ������ ǥ�� CROSS JOIN ���� (����Ŭ 9i���� ����)
SELECT
    e.employee_id,
    e.last_name,
    d.department_name
FROM
         employees e
    CROSS JOIN departments d;
    
--INNER JOIN--------------------------------------------------
--Equi JOIN

-- 3���̻� ���̺� ����(��ųʸ�(���̺�)�κ��� ���̺� ���� ��ȸ)
SELECT
    *
FROM
    user_tables;
    
-- ����Ŭ ����---
SELECT
    e.employee_id,
    e.last_name,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;    
    
-- ANSI ����
SELECT
    e.employee_id,
    e.last_name,
    d.department_name
FROM employees e
    JOIN departments d ON e.department_id = d.department_id;


SELECT
    e.employee_id id,
    e.last_name name,
    e.salary salary,
    d.department_name dname,
    l.city city
FROM
         employees e
    JOIN departments d 
    ON e.department_id = d.department_id
    JOIN locations   l 
    ON d.location_id = l.location_id;
    
-- NON-EQUI JOIN------------
-- �׽�Ʈ�� ���� �޿����(salgrace) ���̺� ����
CREATE TABLE salgrade(grade NUMBER,
losal NUMBER,
hisal NUMBER);

-- ������ �Է�
INSERT INTO salgrade VALUES (1, 2001, 3000);
INSERT INTO salgrade VALUES (2, 3001, 4000);
INSERT INTO salgrade VALUES (3, 4001, 5000);
INSERT INTO salgrade VALUES (4, 5001, 6000);
INSERT INTO salgrade VALUES (5, 6001, 100000);
COMMIT;

-- ����Ŭ NON-EQUI JOIN ����
SELECT e.employee_id, e.last_name, e.salary, s.grade
FROM employees e, salgrade s
WHERE e.salary BETWEEN s.losal AND s.hisal
ORDER BY s.grade DESC;


SELECT e.employee_id, e.last_name, e.salary, s.grade
FROM employees e
JOIN salgrade s
ON salary BETWEEN losal AND hisal
ORDER BY s.grade DESC;


------------------OUTER JOIN-------------------------------------------
-- ����Ŭ OUTER JOIN������ ���� ��ų ���� ���� �ʿ� (+) ��ȣ�� �߰��Ѵ�
-- employees ���̺����� �μ���ȣ�� NULL �� Kimberely�� EQUI Join�����δ� �˻����� ����
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- �μ���ȣ�� ���� ����� ��ȸ
-- ����Ŭ OUTER JOIN
SELECT e.employee_id,
e.first_name,
e.last_name,
d.department_name
FROM employees e,
departments d
WHERE e.department_id = d.department_id(+);

---ANSI---------------------
-- LEFT OUTER JOIN
SELECT e.last_name,
d.department_name
FROM employees e
LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;

-- RIGHT OUTER JOIN
SELECT e.last_name,
d.department_name
FROM employees e
RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id;

-- FULL OUTER JOIN
SELECT e.first_name,
d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON e.department_id = d.department_id;


---Self JOIN--------------------------------
-- ANSI ǥ�� SELF JOIN
SELECT e.first_name , m.first_name "BOSS"
FROM EMPLOYEES e
LEFT OUTER JOIN EMPLOYEES m
ON e.manager_id = m.employee_id;

