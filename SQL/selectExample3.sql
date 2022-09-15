-- ����ȯ �Լ�------------------
SELECT TO_CHAR(12345), TO_CHAR(12345.67) --���ڿ��� ����ȯ��
FROM dual;

SELECT TO_CHAR(12345, '999,999'), TO_CHAR(12345.677, '999,999.99')
FROM dual;

SELECT TO_CHAR(12345, '000,000'), TO_CHAR(12345.677, '000,000.00')
FROM dual;

SELECT TO_CHAR(150, '$9999'), TO_CHAR(150, '$0000')
FROM dual;

SELECT TO_CHAR(150, 'S9999'), TO_CHAR(150, 'S0000')
FROM dual;

SELECT TO_CHAR(150, '9999MI'), TO_CHAR(-150, '9999MI')
FROM dual;

SELECT TO_CHAR(150, '9999EEEE'), TO_CHAR(150, '99999B')
FROM dual;

SELECT TO_CHAR(150, 'RN'), TO_CHAR(150, 'rn')
FROM dual;

SELECT TO_CHAR(10, 'X'), TO_CHAR(10, 'x'), TO_CHAR(15, 'X')
FROM dual;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY')
FROM dual;

SELECT first_name, hire_date, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI')
FROM employees;

-- �Ի�⵵�� 2002�⵵�� �����
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') = '2002';

--TO_NUMBER--
SELECT TO_NUMBER('12345') + 1
FROM dual;

SELECT TO_NUMBER('12,345', '00,000') + 1
FROM dual;

SELECT TO_NUMBER('1000')
FROM dual;

-- TO_DATE(char|number, [format])

SELECT TO_DATE('2021/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('2003-06-17', 'YYYY-MM-DD');

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE(20030617, 'YYYY-MM-DD');

-- �Ϲ� �Լ�

SELECT NVL(NULL, 10) FROM dual;

SELECT 10*NULL, 10*NVL(NULL, 1)
FROM dual;

SELECT first_name, salary, commission_pct, NVL(commission_pct, 0)
--commission_pct�� null�̸� 0 ���, null�� �ƴϸ� �ƴѰ� ���
FROM employees;

SELECT first_name, salary, commission_pct, ( salary + ( salary * commission_pct ) ) * 12 "����"
FROM employees;

SELECT first_name, salary, commission_pct, ( salary + ( salary * NVL(commission_pct, 0) ) ) * 12 "����"
FROM employees;

SELECT first_name, salary, NVL2(commission_pct, commission_pct, 0)
FROM employees;

SELECT first_name, salary, NVL2(TO_CHAR(commission_pct), TO_CHAR(commission_pct), '���Ի��') "�μ�Ƽ��"
FROM employees;

--DECODE-------------------------------------------

SELECT first_name, job_id,

DECODE(job_id, 'IT_PROG', '������',
'AC_MRG', '������',
'FI_ACCOUNT', 'ȸ���',
'����')

FROM employees;