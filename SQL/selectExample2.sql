--단일행 함수
--문자/문자열 함수
SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;
--dual은 가상 더미 테이블, TEST를 위한 가상 테이블 

SELECT CONCAT(first_name, last_name) "풀 네임"
FROM employees;

SELECT INITCAP('kim ki jung') --첫글짜들만 대문자로
FROM dual;

SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james'; 
--first_name을 소문자로 바꾸고 비교하는것

SELECT UPPER('bangry')
FROM dual;

SELECT LPAD('DataBase', 10, '*') --10개자리로 채우는데 자리가 남으면 **로 채우겠다느 뜻
FROM dual;

SELECT RPAD('DataBase', 10, '*') 
FROM dual;

SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

SELECT SUBSTR('서울시가산동', 4)
FROM dual;

SELECT SUBSTR (last_name, 1,4)
FROM employees;

SELECT first_name, LENGTH(first_name)
FROM employees;

SELECT REPLACE ('바보다', '바보', '굿')
FROM dual;

SELECT REPLACE ('서울 시', ' ', '')
FROM dual;

SELECT INSTR('DataBase', 'B')
FROM dual;
