--#1. ���̺� ������ ����
DROP TABLE member;
CREATE TABLE member (
  id          VARCHAR2(12)  NOT NULL,
  passwd      VARCHAR2(20)  NOT NULL,
  name        VARCHAR2(30)  NOT NULL,
  age         NUMBER(3)  NOT NULL
);

commit;

--#2. �������� �߰�
ALTER TABLE member
  ADD ( CONSTRAINT member_id_pk PRIMARY KEY(id));

--����
INSERT INTO member(id, name, passwd, age)
VALUES ('fake', '��¥', '1111', '12');

INSERT INTO member(id, name, passwd, age)
VALUES ('Noone', '�͸�', '1111', '15');

SELECT *
FROM member;


CREATE TABLE guestbook(
    writer      VARCHAR2(20) NOT NULL,
    contents    VARCHAR2(4000) NOT NULL,
    regdate     DATE DEFAULT sysdate
);

INSERT INTO guestbook(writer, contents)
VALUES ('������', '�۸۸۸۸Ӹ۸�');

commit;
SELECT writer, contents,regdate
FROM guestbook
ORDER BY regdate desc;

SELECT writer, contents,TO_CHAR(regdate,'yyyy-mm-dd HH24:MI:SS') "date"
FROM guestbook
ORDER BY regdate desc;
