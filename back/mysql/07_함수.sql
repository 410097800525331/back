-- 테이블 삭제
DROP TABLE member;

-- 테이블 생성
CREATE TABLE member (
  member_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  age INT,
  gender CHAR(1),
  point INT,
  salary INT,
  regdate DATE
);

-- 데이터 삽입
INSERT INTO member VALUES
(1, 'Hong Gildong', 35, 'M', 500, 3000000, '2023-01-01'),
(2, 'Yi Sunsin', 22, 'M', 200, 2500000, '2022-01-01'),
(3, 'Kim Younghee', 19, 'F', NULL, 1800000, '2025-01-01'),
(4, 'Park Cheolsu', 45, 'M', 900, 5000000, '2021-01-01'),
(5, 'Choi Minsu', 31, 'F', 700, NULL, '2024-01-01');

SELECT * FROM member;

/* 
    문자열(String) 함수
        1. LENGTH(str)
            - str의 길이(Byte 단위)
            - 숫자와 영문자는 1byte, 한글은 3byte
            - 예) LENGTH('Hello') -> 5
            - 예) LENGTH('홍길동') -> 9
        1-1 CHAR_LENGTH(str)
            - str의 길이(문자 단위)
            - 예) CHAR_LENGTH('홍길동') -> 3
        2. UPPER(str)
            - str을 모두 대문자로
            - 예) UPPER('Hello') -> 'HELLO'
        2-1 LOWER(str)
            - str을 모두 소문자로
*/
-- 1. 회원 이름의 길이를 조회하시오.
SELECT name, CHAR_LENGTH(name)
FROM member;
SELECT * FROM member;

-- 2. 회원 이름을 모든 글자를 대문자로 조회하시오.
SELECT UPPER(name)
FROM member;
SELECT LOWER(name)
FROM member;

/* 
    3. substring(str, start, len)
        - 부분 문자열 추출
        - str: 원본 문자열
        - start: 추출 시작 위치(1부터 시작)
        - len: 추출할 길이
        예) substring('ABCDEF', 2, 3) -> 'BCD'
    3-1 left(str, n)
        - 왼쪽에서부터  n개의 글자
        예) left('ABCDEF', 1) -> 'A'
    3-2 right(str, n)
        - 오른쪽 기준, n개의 글자
        예) right('ABCDEF', 1) -> 'F'
 */
-- 3. 회원 이름의 첫 글자만 조회하시오.
SELECT name, SUBSTRING(name, 1, 1)
FROM member;
SELECT name, LEFT(name, 1)
FROM member;
SELECT name, RIGHT(name, 1)
FROM member;

/* 
    4. concat(str1, str2, ...)
        - 문자열 연결
        예) concat('Hello', ' ', 'World') -> 'Hello World'
*/
-- 4. 이름과 성별을 하나의 문자열로 조회하시오. (예, 홍길동(M))
SELECT CONCAT(name, ' (', gender, ')')
FROM member;

/* 
    숫자 함수
        1. abs(num)
            - 절대값
            예) abs(-10) -> 10
*/
-- 5. 포인트와 500의 차이를 절대값으로 조회하시오.
SELECT name, ABS(point - 500) AS point_difference
FROM member;

/* 
    2. round(num, [decimals])
        - 반올림
        - num: 반올림할 숫자
        - decimals: 소수점 이하 자릿수 (생략시 0)
        예) round(3.146592, 2) -> 3.15 
    2-1. floor(num)
        - 버림
        예) floor(3.14) -> 3
    2-2. ceiling(num)
        - 올림
        예) ceiling(3.14) -> 4
*/
-- 6. 급여를 만원 단위로 반올림하여 조회하시오.
SELECT name AS 이름, salary AS 급여, CONCAT(ROUND(salary / 10000), '0000') AS "급여"
FROM member;
SELECT * FROM member;

SELECT salary, FLOOR(salary)
FROM member;
SELECT salary, CEILING(salary)
FROM member;

/* 
    날짜 함수
        1. CURDATE()
            - 현재 날짜를 'YYYY-MM-DD' 형식
            예) CURDATE() -> '2026-01-30'
        2. CURTIME()
            - 현재 시간을 'HH:MM:SS' 형식
        3. NOW()
            - 현재 날짜와 시간을 'YYYY-MM-DD HH:MM:SS' 형식
        4. YEAR(날짜)
            - 날짜의 년도를 'YYYY' 형식
*/
-- 7. 오늘 날짜를 조회하시오.
SELECT CURDATE();
SELECT CURTIME();
SELECT NOW();
SELECT YEAR(NOW());

/* 
    5. datediff(날짜1, 날짜2)
        - 날짜1 - 날짜2, 두 날짜의 차이를 일수로 반환
        예) datediff('2023-12-31', '2023-01-01') -> 364
*/
-- 8. 회원 가입 후 경과 일수를 조회하시오.
SELECT name AS 이름, CONCAT(DATEDIFF(CURDATE(), regdate), "일") AS 가입기간
FROM member;

/* 
    NULL 처리 함수
        ifnull(표현식1, 표현식2)
        ifnull(컬럼, 기본값)
            - 표현식1이 NULL이면 표현식2를 반환,
              아니면 표현식1을 반환
            예) ifnull(NULL, 'default') -> 'default'
*/
-- 9. 포인트가 NULL이면 0으로 표시하시오.
SELECT name AS 이름, IFNULL(point, 0) AS 포인트
FROM member;

/* 
    IF(조건, 값1, 값2)
        - 조건에 따라 값1 또는 값2를 반환
        - 값1: 조건이 참일때의 값
        - 값2: 조건이 거짓일때의 값
        예) IF(5 >= 3, 'yes', 'no') -> 'yes'
        예) IF(point >= 500, '우수', '일반') -> ?
*/
-- 10. 포인트가 500 이상이면 '우수', 아니면 '일반'으로 표시하시오.
SELECT name AS 이름, point AS 포인트, IF(point >= 500, '우수', '일반') AS 회원등급
FROM member;
SELECT name AS 이름, point AS 포인트, IF(point >= 800, 'VIP', IF(point >= 500, '우수', '일반')) AS 회원등급
FROM member;

/* 
    CASE ~ END
        - 여러 조건에 따른 결과 값 반환
        CASE
            WHEN 조건 THEN 결과
            WHEN 조건 THEN 결과
            ...
            ELSE 결과
        END

        예)
            CASE
                WHEN score >= 90 THEN 'A'
                WHEN score >= 80 THEN 'B'
                WHEN score >= 70 THEN 'C'
                WHEN score >= 60 THEN 'D'
                ELSE 'F'
            END
*/
-- 11. 나이에 따라 연령대(10대, 20대, ..., 50대 이상)를 분류하시오.
SELECT name AS 이름, age AS 나이, 
        CASE 
            WHEN age < 20 THEN '10대'
            WHEN age BETWEEN 20 AND 29 THEN '20대'  
            WHEN age BETWEEN 30 AND 39 THEN '30대'  
            WHEN age BETWEEN 40 AND 49 THEN '40대'  
            ELSE '50대 이상'
        END AS 연령대
FROM member;
SELECT name AS 이름, age AS 나이, 
        CASE 
            WHEN age < 20 THEN '10대'
            WHEN age < 30 THEN '20대'
            WHEN age < 40 THEN '30대'
            WHEN age < 50 THEN '40대'
            ELSE '50대 이상'
        END AS 연령대
FROM member;

/* 
    집계 함수
        1. count(컬럼)
            - 컬럼의 NULL이 아닌 행 수
        1-1. count(*): NULL 값이 있는 레코드도 개수에 포함된다.
        2. sum(컬럼)
            - 컬럼의 합계
        3. avg(컬럼)
            - 컬럼의 평균
        4. max(컬럼)
            - 컬럼의 최댓값
        5. min(컬럼)
            - 컬럼의 최솟값
*/
-- 12. 전체 회원 수를 조회하시오.
SELECT COUNT(*) AS '총 원' FROM member; -- 5
SELECT COUNT(point) FROM member; -- 4

-- 13. 전체 포인트 합계를 조회하시오.
SELECT SUM(point) AS `포인트 총합` FROM member; -- 2300

-- 14. 평균 급여를 조회하시오.
SELECT AVG(salary) AS `평균 급여` FROM member;

-- 15. 성별별 평균 급여를 조회하시오.
SELECT gender AS 성별, AVG(salary) AS `평균 급여`
FROM member
GROUP BY gender;