
DROP TABLE MEMBER;

commit;

CREATE TABLE member (
    member_id VARCHAR2(10),
    team_id NUMBER(3),
    password VARCHAR2(10) NOT NULL,
    name VARCHAR2(20) NOT NULL,
    age NUMBER(3) NOT NULL,
    regdate DATE DEFAULT SYSDATE
);

ALTER TABLE member
ADD ( CONSTRAINT member_id_pk PRIMARY KEY(member_id),
CONSTRAINT team_id_fk FOREIGN KEY(team_id) REFERENCES team(team_id));

Drop Table member_history;

-- Member History Table
create table member_history(
history_id NUMBER,
message VARCHAR2(30),
member_id VARCHAR2(20)
);

ALTER TABLE member_history
ADD ( CONSTRAINT member_history_id_pk PRIMARY KEY(history_id),
CONSTRAINT member_history_memberid_fk FOREIGN KEY(member_id) REFERENCES member(member_id));

create sequence member_history_seq;

SELECT * FROM MEMBER;

SELECT * FROM member_history;

SELECT * FROM TEAM;

commit;