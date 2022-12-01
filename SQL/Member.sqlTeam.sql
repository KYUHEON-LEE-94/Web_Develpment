DROP TABLE member;

CREATE TABLE member (
member_id VARCHAR2(10),
team_id NUMBER(3),
password VARCHAR2(10) NOT NULL,
name VARCHAR2(20) NOT NULL,
age NUMBER(3) NOT NULL,
regdate DATE DEFAULT SYSDATE
);

commit;

ALTER TABLE member
ADD ( CONSTRAINT member_id_pk PRIMARY KEY(member_id),
        CONSTRAINT team_id_fk FOREIGN KEY(team_id) REFERENCES team(TEAM_ID));
        
DROP TABLE team;
        
CREATE TABLE team (
team_id NUMBER(3),
name VARCHAR2(30) NOT NULL
);

ALTER TABLE team
ADD ( CONSTRAINT team_id_pk PRIMARY KEY(team_id));

CREATE SEQUENCE team_seq;

INSERT INTO team(team_id, name)
VALUES (team_seq.nextval, 'red');

INSERT INTO member(team_id, name)
VALUES (team_seq.nextval, 'red');

commit;

SELECT *
FROM TEAM;

SELECT *
FROM member;

DELETE FROM TEAM
WHERE TEAM_ID = 7;