--#1. 테이블 구조만 생성
CREATE TABLE users (
  id          VARCHAR2(20),
  passwd      VARCHAR2(20)  NOT NULL,
  name        VARCHAR2(30)  NOT NULL,
  email       VARCHAR2(50)  NOT NULL,
  regdate     DATE DEFAULT  SYSDATE
);

--#2. 제약조건 추가
ALTER TABLE users
  ADD ( CONSTRAINT user_id_pk     PRIMARY KEY(id),
        CONSTRAINT user_email_uk  UNIQUE (email));

--#3. 개발의 편의성을 위해 제약조건 비활성화
ALTER TABLE users
  DISABLE CONSTRAINT user_id_pk CASCADE
  DISABLE CONSTRAINT user_email_uk;

ALTER TABLE users
  ENABLE CONSTRAINT user_id_pk
  ENABLE CONSTRAINT user_email_uk;        


-- 전체 조회
SELECT id, name, email,passwd, TO_CHAR(regdate, 'yyyy-MM-DD') regdate
FROM users
ORDER BY regdate DESC;

DELETE FROM users
WHERE ID = 'gono2';

SELECT *
FROM users
WHERE ID = 'gono2';

ROLLBACK;

--검색 옵션에 따른 회원목록 조회
SELECT id, name, email,passwd, TO_CHAR(regdate, 'yyyy-MM-DD') regdate
FROM users
--WHERE id = 'bangry';
WHERE name LIKE name AS '기%'

-- ID로 조회(회원 상세)
SELECT id, name, email, TO_CHAR(regdate, 'yyyy-MM-DD HH24:MI:SS')
FROM users
WHERE id = 'bangry';

-- ID/PW로 조회(회원 로그인)
SELECT id, name, email, TO_CHAR(regdate, 'yyyy-MM-DD HH24:MI:SS')
FROM users
WHERE id = 'bangry' AND passwd = '1111';

-- 회원 등록
INSERT INTO users(id, name, passwd, email)
VALUES ('honggildong', '홍길동', 'honggildong@gmail.com', '1234');

INSERT INTO users(id, name, passwd, email)
VALUES ('125456', '이다다', 'fesg', '1234');

ROLLBACK;
        
-- 선택페이지에 따른 사용자 목록 반환
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 10) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
                ORDER  BY regdate DESC))
WHERE  request_page = 2;

-- 선택페이지, 조회 목록개수에 따른 사용자 목록 반환
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 5) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
                ORDER  BY regdate DESC))
WHERE  request_page = 2;

-- 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 5) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
--                WHERE id = 'bangry'
                WHERE name like '%기%'
                ORDER  BY regdate DESC))
WHERE  request_page = 1;


-- 검색유형, 검색값에 따른 사용자 개수 반환 - 페이징 처리 시 필요
SELECT COUNT(id) count
FROM   users
--WHERE id = 'bangry';
--WHERE name like '%기%';

