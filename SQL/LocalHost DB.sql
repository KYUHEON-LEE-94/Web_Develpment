--단일행 함수
--문자/문자열 함수
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
SELECT SUBSTR('서울시가산동', 4)
FROM dual;

