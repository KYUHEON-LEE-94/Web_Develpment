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
