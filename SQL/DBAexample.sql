SELECT *
FROm hr.employees;

CREATE PUBLIC SYNONYM emps
FOR HR.employees;

--User ����: �󲮵��⸸ ���� ����
CREATE USER lee IDENTIFIED by lee;

--�ý��� ���� ���� �ο�
GRANT CREATE SESSION TO lee;

--��ü�� ���� ���� �ο�(sys�� bangry���� hr��Ű���� employees ���̺� ���� CRUD ������ �ο�)
GRANt SELECT, INSERT, UPDATE, DELETE on hr.employees
TO lee;
-- �ʿ信 ���� User���� �ο��� ���� ȸ��
REVOKE SELECT, INSERT, UPDATE, DELETE on hr.employees
FROM lee;


/* ��(ROLE) : ���� ���ѵ��� ����(���� �� / ����� ���� ��) */
/* #1. User�� ���� �� �ο� */
GRANT CONNECT, RESOURCE, DBA TO lee;

/* #2. ����� ���� �� ���� */
CREATE ROLE some_role;
--DROP ROLE some_role;

/* #3. �ý��� ���Ѱ� ��ü ������ �ѿ� ��� */
GRANT CREATE SESSION TO some_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO some_role;
-- �� ��� ������ �ѿ� �ο�

GRANT ALL ON hr.employees TO some_role;
/* #4. User�� ����� ���� �� �ο� */
GRANT some_role TO lee;

/* #5. User ��� �� ���� */
ALTER USER lee ACCOUNT LOCK;
ALTER USER lee ACCOUNT UNLOCK;

/* #6. User ��й�ȣ ���� */
--ALTER USER bangry IDENTIFIED BY bbangry;

/* #7. User ���� */
DROP USER bangry CASCADE;
/* #8. ������ ��ųʸ��κ��� ���� ��� ��ȸ */
SELECT * FROM dba_users;

/* #9. ����ڿ��� �ο��� �ý��� ���� ��ȸ */
SELECT *
FROM dba_sys_privs
WHERE grantee = 'lee';

/* #10. �ѿ� �ο��� �ý��� ���� ��ȸ */
SELECT *
FROM dba_sys_privs
WHERE grantee = 'lee';