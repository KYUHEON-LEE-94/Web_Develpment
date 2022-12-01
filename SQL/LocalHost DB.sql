SELECT employee_id, last_name, email, salary, To_CHAR(hire_date, 'yyyy-MM-DD HH24:MI:SS') hire_date
FROM employees
WHERE employee_id = 200;

INSERT INTO students(ssn,name,korean,english,math)
VALUES(stu_seq.nextval, '강아지',50,60,70);

ROLLBACK;

SELECT *
FROM students;

DELETE FROM students
WHERE NAME = '황소';



