use webtest;
CREATE TABLE team ( 
	teamno int NOT NULL AUTO_INCREMENT primary key,
	tname VARCHAR(20) NOT NULL,
	skills VARCHAR(20) NOT NULL,
	phone VARCHAR(20) NOT NULL,
	address VARCHAR(100) NULL,
	zipcode int NULL,
	gender VARCHAR(10) NOT NULL,
	rdate DATE NOT NULL
);

-- 등록
INSERT INTO team(tname, skills, phone, address, zipcode, gender, rdate)
VALUES('홍깅동', 'java', '010-1234-5678', '미룡동', 12345, '남', NOW());
INSERT INTO team(tname, skills, phone, address, zipcode, gender, rdate)
VALUES('이몽룡', 'jsp', '010-9123-4567', '나운동', 67891, '남', NOW());
INSERT INTO team(tname, skills, phone, address, zipcode, gender, rdate)
VALUES('성춘향', 'spring', '010-8912-3456', '미장동', 23456, '여', now());
INSERT INTO team(tname, skills, phone, address, zipcode, gender, rdate)
VALUES('연흥부', 'java', '010-7891-2345', '월명동', 78912, '남', now());
INSERT INTO team(tname, skills, phone, address, zipcode, gender, rdate)
VALUES('연놀부', 'jsp', '010-6789-1234', '산북동', 34567, '남', now());
INSERT INTO team(tname, skills, phone, address, zipcode, gender, rdate)
VALUES('최콩쥐', 'spring', '010-5678-9123', '금암동', 89123, '여', now());

-- 목록
SELECT teamno, tname, skills, phone, address, zipcode, gender, rdate
FROM team
ORDER BY teamno asc;

-- 조회
SELECT teamno, tname, skills, phone, address, zipcode, gender, rdate
FROM team
WHERE teamno=1;

-- 수정
UPDATE team
SET phone='010-1234-5678', address='미룡동', zipcode=12345
WHERE teamno=1;

-- 삭제
DELETE FROM team
WHERE teamno=6;
 
SELECT * FROM team;