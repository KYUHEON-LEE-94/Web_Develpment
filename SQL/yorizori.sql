-- users 테이블 변경
ALTER TABLE users 
    MODIFY (id      VARCHAR2(30),
            passwd  VARCHAR2(30),
            name    VARCHAR2(30));

desc users;


-- cookbook 테이블 생성
CREATE TABLE cookbook (
  book_id     NUMBER(7),
  book_name   VARCHAR2(50)  NOT NULL,
  book_desc   VARCHAR2(200),
  author_id   VARCHAR2(30)
);

-- recipe 테이블 생성
CREATE TABLE recipe (
  recipe_id      NUMBER(7),
  book_id        NUMBER(7),
  recipe_name    VARCHAR2(30)  NOT NULL,
  recipe_time    NUMBER(3),
  recipe_level   NUMBER(1),
  ingredients    VARCHAR2(300),
  img_cont_type  VARCHAR2(20),
  img_file_name  VARCHAR2(20),
  writer_id      VARCHAR2(20)  
);

-- recipe_procedure 테이블 생성
CREATE TABLE recipe_procedure (
  recipe_id      NUMBER(7),
  seq_num        NUMBER(2),
  procedure      VARCHAR2(200) NOT NULL 
);

-- 제약조건 추가
ALTER TABLE cookbook
  ADD ( CONSTRAINT cookbook_id_pk PRIMARY KEY(book_id),
        CONSTRAINT cookbook_author_id_fk FOREIGN KEY(author_id)  REFERENCES users(id));

ALTER TABLE recipe
  ADD ( CONSTRAINT recipe_id_pk          PRIMARY KEY(recipe_id),
        CONSTRAINT recipe_book_id_fk     FOREIGN KEY(book_id)    REFERENCES cookbook(book_id),
        CONSTRAINT recipe_writer_id_fk   FOREIGN KEY(writer_id)  REFERENCES users(id) );

ALTER TABLE recipe_procedure
  ADD ( CONSTRAINT recipe_id_seqnum_pk   PRIMARY KEY(recipe_id, seq_num) );

--복합키
ALTER TABLE recipe_procedure
  ADD ( CONSTRAINT recipe_id_fk          FOREIGN KEY(recipe_id)  REFERENCES recipe(recipe_id));


SELECT * FROM user_constraints
WHERE table_name = 'RECIPE_PROCEDURE';

SELECT *
from cookbook;

-- cookbook 등록
desc cookbook;

CREATE SEQUENCE cookbook_seq
START WITH 1
INCREMENT BY 1; 

INSERT INTO cookbook (book_id, book_name, book_desc, author_id)
VALUES (cookbook_seq.nextval, '한식매니아', '한식요리를 맛있게 만드는 방법을 설명합니다',  'bangry');

SELECT book_id, book_name, book_desc, author_id
FROM cookbook
ORDER BY book_id;

--요리책 목록 조회
SELECT c.book_id bookId, c.book_name bookName, c.book_desc bookDesc, c.author_id authorId, u.name authorName
FROM cookbook c
    JOIN users u on c.author_id = u.id;    
    
SELECT book_id, book_name, book_desc, author_id, u.name authorName
FROM ( SELECT CEIL(rownum / 2) request_page,  book_id, book_name, book_desc, author_id
    FROM   ( SELECT  book_id, book_name, book_desc, author_id
    FROM cookbook) )c
    JOIN users u on c.author_id = u.id
    WHERE  request_page = 1;


DELETE FROM cookbook
WHERE book_name ='된장국';

rollback;

--- 레시피 관련
--
SELECT * FROM user_constraints
WHERE table_name = 'recipe_id';

--레시피 전체조회
SELECT recipe_id, book_id, recipe_name, recipe_time, recipe_level, ingredients, img_cont_type, img_file_name, writer_id
FROM recipe;

DELETE FROM recipe
WHERE recipe_id = 240;

commit;

-- 레시피 생성
INSERT INTO recipe (recipe_id, book_id, recipe_name, recipe_time, recipe_level, ingredients, img_cont_type, img_file_name, writer_id)
VALUES (123, 'cookbook의 bookid', 'recipe_name',  'recipe_time','recipe_level','ingredients','img_cont_type','img_file_name','writer_id는 userid');


SELECT RECIPE_ID,SEQ_NUM,PROCEDURE
FROM recipe_procedure;

INSERT INTO recipe_procedure  (RECIPE_ID,SEQ_NUM,PROCEDURE)
VALUES ((SELECT RECIPE_ID FROM recipe WHERE ),1,'fesfd');

SELECT *
FROM employees
WHERE EMPLOYEE_ID = 110;

DELETE FROM recipe_procedure
WHERE RECIPE_ID = 240;

SELECT r.RECIPE_ID, r.recipe_name, r.recipe_time, r.recipe_level, r.writer_id,r.INGREDIENTS, rp.SEQ_NUM,rp.PROCEDURE,r.img_cont_type, r.img_file_name
FROM recipe r
JOIN recipe_procedure rp on r.RECIPE_ID = rp.RECIPE_ID
 WHERE r.book_id = 62;
