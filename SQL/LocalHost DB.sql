--������ �Լ�
--����/���ڿ� �Լ�
SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;
SELECT INITCAP('kim ki jung')
FROM dual;
SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james';
SELECT UPPER('bangry')
FROM dual;
SELECT LPAD('DataBase', 10, '*')
FROM dual;
SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;
SELECT SUBSTR('����ð��굿', 4)
FROM dual;

