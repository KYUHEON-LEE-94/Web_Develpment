--������ �Լ�
--����/���ڿ� �Լ�
SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;
--dual�� ���� ���� ���̺�, TEST�� ���� ���� ���̺� 

SELECT CONCAT(first_name, last_name) "Ǯ ����"
FROM employees;

SELECT INITCAP('kim ki jung') --ù��¥�鸸 �빮�ڷ�
FROM dual;

SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james'; 
--first_name�� �ҹ��ڷ� �ٲٰ� ���ϴ°�

SELECT UPPER('bangry')
FROM dual;

SELECT LPAD('DataBase', 10, '*') --10���ڸ��� ä��µ� �ڸ��� ������ **�� ä��ڴٴ� ��
FROM dual;

SELECT RPAD('DataBase', 10, '*') 
FROM dual;

SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

SELECT SUBSTR('����ð��굿', 4)
FROM dual;

SELECT SUBSTR (last_name, 1,4)
FROM employees;

SELECT first_name, LENGTH(first_name)
FROM employees;

SELECT REPLACE ('�ٺ���', '�ٺ�', '��')
FROM dual;

SELECT REPLACE ('���� ��', ' ', '')
FROM dual;

SELECT INSTR('DataBase', 'B')
FROM dual;

SELECT first_name, LENGTH(first_name)
FROM employees;

SELECT REPLACE('�����ٺ�', '�ٺ�', '�ְ�')
FROM dual;

SELECT REPLACE('���� ��', ' ', '')
FROM dual;

SELECT INSTR('DataBase', 'B')
--SELECT INSTR('DataBase', 'a', 1, 2)
FROM dual;


--SELECT LTRIM(' JavaDeveloper')
--SELECT LTRIM(' JavaDeveloper', ' ')
SELECT LTRIM('JavaDeveloper', 'Java')
FROM dual;

--SELECT RTRIM('JavaDeveloper ')
--SELECT RTRIM('JavaDeveloper ', ' ')
SELECT RTRIM('JavaDeveloper', 'Developer')
FROM dual;

SELECT TRIM(' Java Developer ')
FROM dual;


--���� �Լ� --------------------------------------

SELECT ROUND(45.923), ROUND(45.923, 0), ROUND(45.923, 2), ROUND(45.923, -1)
--�ڸ������� +1�� ������ �ݿø���
FROM dual;

SELECT TRUNC(45.923), TRUNC(45.923, 0), TRUNC(45.923, 2), TRUNC(45.923, -1)
FROM dual;

SELECT CEIL(123.123)
FROM dual;

SELECT FLOOR(123.123)
FROM dual;

SELECT ABS(-500)
FROM dual;

SELECT POWER(5, 2), SQRT(5), SIN(30), COS(30), TAN(30)
FROM dual;

-- �ּҰ� ��ȯ
SELECT LEAST(10, 20, 30, 40)
FROM dual;

-- �ִ밪 ��ȯ
SELECT GREATEST(10, 20, 30, 40)
FROM dual;


--��¥ �Լ�-----------------------------------------------------
SELECT SYSDATE
FROM dual;

SELECT SYSTIMESTAMP
FROM dual;

-- DATE Ÿ�Կ� ���� ����
SELECT SYSDATE - 1 "����" , SYSDATE "����", SYSDATE + 1 "����"
FROM dual;

-- ����� �ٹ� �ϼ� �˻�
SELECT first_name, hire_date, SYSDATE, CEIL(SYSDATE - hire_date) "�ٹ��ϼ�"
FROM employees;

-- ����� �ٹ� ������ �˻�
SELECT first_name, TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date)) "�ٹ�������"
FROM employees;

-- Ư���������� ���� ��¥ ��ȯ
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) "���ú��� 2���� ��"
FROM dual;

-- �̹��� ����� ��¥
SELECT SYSDATE "����", NEXT_DAY(SYSDATE, 7) "�̹��� �����" --�Ͽ�����1, ��������2
FROM dual;

-- �̹��� ������ ��¥
SELECT SYSDATE, LAST_DAY(SYSDATE) "�̹��� ��������"
FROM dual;