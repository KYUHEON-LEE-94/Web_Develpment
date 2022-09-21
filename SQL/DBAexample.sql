SELECT *
FROm hr.employees;

CREATE PUBLIC SYNONYM emps
FOR HR.employees;

--User 생성: 빈껍데기만 만든 상태
CREATE USER lee IDENTIFIED by lee;

--시스템 연결 권한 부여
GRANT CREATE SESSION TO lee;

--객체에 대한 권한 부여(sys가 bangry에게 hr스키마의 employees 테이블에 대한 CRUD 권한을 부여)
GRANt SELECT, INSERT, UPDATE, DELETE on hr.employees
TO lee;
-- 필요에 따라 User에게 부여된 권한 회수
REVOKE SELECT, INSERT, UPDATE, DELETE on hr.employees
FROM lee;


/* 롤(ROLE) : 여러 권한들의 묶음(내장 롤 / 사용자 정의 롤) */
/* #1. User에 내장 롤 부여 */
GRANT CONNECT, RESOURCE, DBA TO lee;

/* #2. 사용자 정의 롤 생성 */
CREATE ROLE some_role;
--DROP ROLE some_role;

/* #3. 시스템 권한과 객체 권한을 롤에 등록 */
GRANT CREATE SESSION TO some_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO some_role;
-- ※ 모든 권한을 롤에 부여

GRANT ALL ON hr.employees TO some_role;
/* #4. User에 사용자 정의 롤 부여 */
GRANT some_role TO lee;

/* #5. User 잠금 및 해제 */
ALTER USER lee ACCOUNT LOCK;
ALTER USER lee ACCOUNT UNLOCK;

/* #6. User 비밀번호 변경 */
--ALTER USER bangry IDENTIFIED BY bbangry;

/* #7. User 삭제 */
DROP USER bangry CASCADE;
/* #8. 데이터 딕셔너리로부터 유저 목록 조회 */
SELECT * FROM dba_users;

/* #9. 사용자에게 부여된 시스템 권한 조회 */
SELECT *
FROM dba_sys_privs
WHERE grantee = 'lee';

/* #10. 롤에 부여된 시스템 권한 조회 */
SELECT *
FROM dba_sys_privs
WHERE grantee = 'lee';