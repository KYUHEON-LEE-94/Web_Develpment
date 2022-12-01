--#1. 테이블 구조만 생성
DROP TABLE member;
CREATE TABLE member (
  id          VARCHAR2(12)  NOT NULL,
  passwd      VARCHAR2(20)  NOT NULL,
  name        VARCHAR2(30)  NOT NULL,
  age         NUMBER(3)  NOT NULL,
  regdate     DATE DEFAULT SYSDATE
);

--#2. 제약조건 추가
ALTER TABLE member
  ADD ( CONSTRAINT member_id_pk PRIMARY KEY(id));

--생성
INSERT INTO member(id, name, passwd, age)
VALUES ('fake', '가짜', '1111', '12');

INSERT INTO member(id, name, passwd, age)
VALUES ('Noone', '익명', '1111', '15');

SELECT *
FROM member;

SELECT TO_CHAR(regdate, 'yyyy-mm-dd HH24:MI:SS')
FROM member;


CREATE TABLE guestbook(
    writer      VARCHAR2(20) NOT NULL,
    contents    VARCHAR2(4000) NOT NULL,
    regdate     DATE DEFAULT sysdate
);

INSERT INTO guestbook(writer, contents)
VALUES ('강아지', '멍멍멍멍머멍멍');

commit;
SELECT writer, contents,regdate
FROM guestbook
ORDER BY regdate desc;

SELECT writer, contents,TO_CHAR(regdate,'yyyy-mm-dd HH24:MI:SS') "date"
FROM guestbook
ORDER BY regdate desc;

-- 방명록을 위한 테이블 생성
DROP TABLE guestbook;

CREATE TABLE guestbook(
    guestbook_id NUMBER(10),
    writer VARCHAR2(20) NOT NULL,
    contents VARCHAR2(4000) NOT NULL,
    regdate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE guestbook_seq
START WITH 1
INCREMENT BY 1;

ALTER TABLE guestbook
ADD CONSTRAINT guestbook_id_pk PRIMARY KEY(guestbook_id);
