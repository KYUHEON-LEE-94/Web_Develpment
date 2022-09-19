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


