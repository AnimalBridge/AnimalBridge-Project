-- HAPPY_BOARD 테이블 생성
-- "IDX"의 값에는 IDX_SEQ.NEXTVAL 로 값을 넣어야 시퀀스값이 입력된다.
-- NICK_NAME -> FOREIGN KEY로 변경할 것
-- (ORACLE 구려ㅡ.,ㅡ;)
CREATE TABLE HAPPY_BOARD(
    IDX         INT			    PRIMARY KEY		AUTO_INCREMENT,
    NICK_NAME   VARCHAR(40)    NOT NULL,
    TITLE       VARCHAR(40)    NOT NULL,
    CONTENT     VARCHAR(500)   NOT NULL,
    REG_DATE    DATE           NOT NULL,
    WATCH       INT		       DEFAULT 0,
    HIT         INT     	    DEFAULT 0,
    IMG_1       VARCHAR(100),
    IMG_2       VARCHAR(100),
    IMG_3       VARCHAR(100)
);

DROP TABLE HAPPY_BOARD;

DESC HAPPY_BOARD;

INSERT INTO HAPPY_BOARD(NICK_NAME, TITLE, CONTENT, REG_DATE)
VALUES('chocobe',
       '저 행복해요',
       '우헤헤헹',
       CURDATE()
);

SELECT * FROM HAPPY_BOARD;
SELECT COUNT(*) FROM HAPPY_BOARD;
SELECT * FROM HAPPY_BOARD ORDER BY IDX LIMIT 3 OFFSET 2;

SELECT * FROM HAPPY_BOARD WHERE NICK_NAME='a1' AND TITLE='초코비_1' AND CONTENT='asf' AND IMG_1='';

DELETE FROM HAPPY_BOARD;

COMMIT;