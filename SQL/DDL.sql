--DDL
CREATE TABLE students(
    ssn NUMBER CONSTRAINT stu_ssn_pk  PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    korean  NUMBER    DEFAULT 0 CONSTRAINT stu_kor_ck  CHECK(korean BETWEEN 0 AND 100),
    english NUMBER    DEFAULT 0 CONSTRAINT stu_eng_ck  CHECK(english BETWEEN 0 AND 100),
    math    NUMBER    DEFAULT 0 CONSTRAINT stu_math_ck CHECK(math BETWEEN 0 AND 100)
);

SELECT *
FROM user_tables;

SELECT *
FROM user_constraints
WHERE table_name = UPPER('students');

DROP TABLE SAWON;

--#1. ���̺� ������ ����
CREATE TABLE sawon (
id NUMBER(5),
name VARCHAR2(10) NOT NULL,
gender CHAR(1) NOT NULL,
hiredate DATE DEFAULT SYSDATE,
manager_id NUMBER(6)
);

--#2. �������� �߰�
ALTER TABLE sawon
ADD ( CONSTRAINT sawon_id_pk PRIMARY KEY(id),
      CONSTRAINT sawon_gender_ck CHECK (gender IN('M', 'F')),
      CONSTRAINT sawon_mgid_fk FOREIGN KEY(manager_id) REFERENCES employees(employee_id));


SELECT * FROM user_constraints
WHERE table_name = 'SAWON';

--#3. ������ ���Ǽ��� ����  �������� ��Ȱ��ȭ/Ȱ��ȭ
ALTER TABLE sawon
DISABLE CONSTRAINT sawon_id_pk CASCADE
DISABLE CONSTRAINT sawon_gender_ck
DISABLE CONSTRAINT sawon_mgid_fk;

ALTER TABLE sawon
ENABLE CONSTRAINT sawon_id_pk
ENABLE CONSTRAINT sawon_gender_ck
ENABLE CONSTRAINT sawon_mgid_fk;

--���̺� �÷� �߰�
ALTER TABLE emp
    ADD(address VARCHAR2(50));

ALTER TABLE emp
    MODIFY(address VARCHAR2(100));
    
--�÷� ����
ALTER TABLE emp
    DROP COLUMN address;

--�������� ����
ALTER TABLE emp
    DROP CONSTRAINT SYS_C006997;
    --DROP CONSTRAINT pk�������� CASCADE;
    
SELECT * FROM user_constraints
WHERE table_name = 'EMP';

-- ������ ����
CREATE SEQUENCE stu_seq
    START WITH 1
    INCREMENT BY 1;

SELECT *
FROM user_sequences;

--������ �̿�
INSERT INTO students(ssn,name, korean,english,math)
VALUES (stu_seq.NEXTVAL, '�̱���', 90, 80,100);

INSERT INTO students(ssn,name, korean,english,math)
VALUES (stu_seq.NEXTVAL, '��Ʈ����', 50, 60,70);

COMMIT;

SELECT *
FROM students;


--��ųʸ��κ��� �� ��ȸ

SELECT *
FROM user_views;

CREATE OR REPLACE VIEW emp_view
AS SELECT employee_id, last_name, department_id
FROM employees
WHERE department_id = 10;

-- �信�� ������ ��ȸ
SELECT * FROM emp_view;

CREATE OR REPLACE VIEW emp_simple_view
AS SELECT employee_id, last_name, salary, hire_date
FROM employees;

SELECT * FROM emp_simple_view;

DROP VIEW emp_simple_view;

CREATE OR REPLACE VIEW emp_view
    AS SELECT e.employee_id id,
            e.first_name name,
            j.job_title,
            d.department_name dname,
            l.city city
    FROM employees e
        JOIN jobs j
            ON e.job_id = j.job_id
        JOIN departments d
            ON e.department_id = d.department_id
        JOIN locations l
            ON d.location_id = l.location_id;

SELECT * FROM emp_view;


-- 10�� �μ��� ����� ���ؼ��� INSERT, UPDATE �� �� �ִ� �� ����
CREATE OR REPLACE VIEW emp_view
AS SELECT employee_id, last_name, email, hire_date, job_id, department_id
FROM employees
WHERE department_id = 10
WITH CHECK OPTION;

INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'jack', 'jack@korea.com', sysdate, 'AD_VP', 10);
-- INSERT ERROR
INSERT INTO emp_view (employee_id, last_name, email, hire_date, job_id, department_id)
VALUES (employees_seq.nextval, 'king', 'jack@korea.com', sysdate, 'AD_VP', 20);

SELECT ROWNUM, employee_id
FROM emp_view;