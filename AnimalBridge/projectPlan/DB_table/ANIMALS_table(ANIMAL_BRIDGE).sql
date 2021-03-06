CREATE TABLE ANIMALS(
	ANIMAL_IDX				INT		PRIMARY KEY		AUTO_INCREMENT,
	CENTER_IDX				INT,
	ANIMAL_TYPE				VARCHAR(20),
	ANIMAL_SORT				VARCHAR(20),
	ANIMAL_GENDER			VARCHAR(20),
	ANIMAL_NEUTER			VARCHAR(20),
	ANIMAL_INOCULATION	VARCHAR(20),
	ANIMAL_FEATURE			VARCHAR(500),
	ADOPTION_DATE			DATE,
	MEMBER_NICK_NAME		VARCHAR(20),
	IMG_1						VARCHAR(500),
	IMG_2						VARCHAR(500),
	IMG_3						VARCHAR(500),
	IMG_4						VARCHAR(500),
	IMG_5						VARCHAR(500),
	IMG_6						VARCHAR(500)
);

INSERT INTO ANIMALS(CENTER_IDX,
						 ANIMAL_TYPE,
						 ANIMAL_SORT,
						 ANIMAL_GENDER,
						 ANIMAL_NEUTER,
						 ANIMAL_INOCULATION,
						 ANIMAL_FEATURE,
						 ADOPTION_DATE,
						 MEMBER_NICK_NAME,
						 IMG_1,
						 IMG_2,
						 IMG_3,
						 IMG_4,
						 IMG_5,
						 IMG_6)
				VALUES(010,
						 'A1',
						 'A2',
						 'A3',
						 'A4',
						 'A5',
						 'A6',
						 CURDATE(),
						 'CHOCOBE',
						 'IMG_1',
						 'IMG_2',
						 'IMG_3',
						 'IMG_4',
						 'IMG_5',
						 'IMG_6');

SELECT * FROM ANIMALS;
SELECT * FROM ANIMALS ORDER BY ANIMAL_IDX DESC LIMIT 5 OFFSET 5;
SELECT * FROM ANIMALS WHERE ANIMAL_TYPE='강아지' LIMIT 5 OFFSET 0;

DROP TABLE ANIMALS;