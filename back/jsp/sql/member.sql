-- DB 생성
CREATE SCHEMA `testdb` DEFAULT CHARACTER SET utf8mb4 ;

-- DB 사용
USE testdb;

-- 테이블 생성
CREATE TABLE users (
	userid VARCHAR(20) PRIMARY KEY,
    userpw VARCHAR(20) NOT NULL 
);

-- 데이터 삽입
INSERT INTO `testdb`.`users` (`userid`, `userpw`) 
VALUES ('hong', '1234');

INSERT INTO users (userid, userpw) VALUES
('sublover01', 'Subway123!'),
('freshbite22', 'EatFresh22'),
('italianBMT', 'BMT2024!'),
('veggie_delight', 'Veggie99'),
('turkeyclub5', 'Club5500');

-- 조회
SELECT * FROM users;

-- 삭제
DELETE FROM `testdb`.`users` WHERE (`userid` = 'hong');