-- Active: 1769472522146@@127.0.0.1@3306@mydb
-- 테이블 삭제
DROP TABLE member; 
DROP TABLE board;
DROP TABLE product;
-- 참조 무결성 때문에 orders 테이블을 먼저 삭제한다.
-- orders 테이블은 외래키(FK)가 지정되어있어
-- member 테이블보다 먼저 삭제한다.
DROP TABLE orders;

-- 테이블 생성
CREATE TABLE member (
  member_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  age INT,
  gender CHAR(1),
  point INT,
  grade VARCHAR(20),
  regdate DATE
);

/*
	DML(데이터 조작 언어)
    1. INSERT: 삽입 -> Create(생성)
		2. SELECT: 조회 -> Read(읽기)
    3. UPDATE: 갱신 -> Update(갱신)
    4. DELETE: 삭제 -> Delete(삭제)
*/

/* 

    하나의 INSERT 문에 소괄호로 묶은 VALUES값을 사용하면
    하나의 INSERT 구문으로 데이터를 여러 행 입력할 수 있어
    INSERT INTO 테이블명 [(열1, 열2, ...)]
    VALUES [(값1, 값2, ...), (값1, 값2, ...), ...];
      - 테이블 뒤에 열 이름을 생략하려면
        VALUES문 뒤에 테이블의 열 순서와 개수에 맞춰 데이터를 채워야 함

    INSERT INTO 테이블명 (member_id, name, age, gender, point, grade, regdate) 
    VALUES (1,'홍길동',35,'M',500,'VIP','2023-01-01');

    INSERT INTO 테이블명 (age, name, gender, point, grade) 
    VALUES (35,'홍길동','M',500,'VIP');
*/
-- 데이터(행, 튜플, 레코드) 삽입하기
INSERT INTO member VALUES
(1,'홍길동',35,'M',500,'VIP','2023-01-01'),
(2,'이순신',22,'M',200,'BRONZE','2022-01-01'),
(3,'김영희',19,'F',0,'BRONZE','2025-01-01'),
(4,'박철수',45,'M',900,'GOLD','2021-01-01'),
(5,'최민수',31,'F',700,'SILVER','2024-01-01');

-- 조회하기
-- SELECT * FROM [스키마.]테이블; 
-- *는 테이블에 정의된 모든 필드
-- 서로 다른 스키마에서 같은 이름의 테이블이 없다면 스키마명은 생략!
SELECT * FROM mydb.member;
SELECT * FROM board;
SELECT * FROM product;
SELECT * FROM orders;

-- member 테이블
-- 1. member 테이블의 모든 데이터를 조회하시오.
-- *는 모든 컬럼
SELECT * FROM member;

-- 2. member 테이블에서 회원(member)의 이름과 나이만 조회하시오.
-- SELECT 컬럼1, 컬럼2, ... FROM 테이블;
SELECT name, age FROM member;

-- 3. member 테이블에서 등급이 VIP인 회원을 조회하시오.
-- SELECT 컬럼, ... FROM 테이블 WHERE 조건;
SELECT * FROM member
-- 등급이 VIP와 같은
WHERE grade = 'VIP'; 
-- 문자열은 ' 또는 "로 묶는다.

-- 4. member 테이블에서 나이가 30 이상인 회원을 조회하시오.
SELECT * FROM member
WHERE age >= 30;

-- 5. member 테이블에서 성별이 여자이고 포인트가 500 이상인 회원을 조회하시오.
SELECT * FROM member
WHERE gender = "F" AND point >= 500;


/* 
    MySQL에서 문자열 데이터를 조회할 때 대소문자 구분 여부
    -> 데이터 타입과 콜레이션(Collation) 설정에 따라 결정된다.

    utf8mb4_general_ci
      1) _ci(Case Insensitive): 대소문자 구별x
      2) _cs(Case Sensitive): 대소문자 구별
      3) _bin(Binary): 데이터를 이진값으로 비교, 대소문자 구별
    
    BLOB, BINARY 데이터 타입은 콜레이션 설정과 관계없이 대소문자를 구분한다.
    부울값(TRUE, FALSE)은 TINYINT(1) 데이터 타입이므로
    -> 콜레이션 설정과 관계없이 대소문자를 구분하지 않는다.


 */
-- 6. member 테이블에서 등급(grade)이 GOLD 또는 VIP인 회원을 조회하시오.
-- 실행: ctrl+enter
SELECT * FROM member
WHERE grade = 'GOLD' OR grade = 'VIP';
SELECT * FROM member
WHERE grade IN ('gold', 'Vip');


/* 
      범위/집합 연산자
        BETWEEN A AND B     A와 B 사이(A, B 포함)
        IN (A, B, ...)      A 또는 B, ...
 */
-- 7. member 테이블에서 포인트(point)가 200~800 사이인 회원을 조회하시오.
SELECT * FROM member
WHERE point >= 200 AND point <= 800;
SELECT * FROM member
WHERE point BETWEEN 200 AND 800;


-- 8. member 테이블에서 등급(grade)이 BRONZE, SILVER인 회원의 이름(name)과 등급만 조회하시오.
SELECT name, grade FROM member
WHERE grade IN('BRONZE', 'SILVER');


-- board 테이블
CREATE TABLE board (
  board_no INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(200),
  writer VARCHAR(50),
  view_cnt INT,
  regdate DATE
);

INSERT INTO board VALUES
(1,'테스트 글','hong',0,'2022-01-01'),
(2,'공지사항','admin',200,'2023-01-01'),
(3,'자유글','hong',10,'2025-01-01'),
(4,'테스트 게시글','kim',5,'2021-01-01');

/* 
      패턴 연산자
        %   0개 이상의 문자
        _   1개 문자

        예) '테스트'가 포함된                 %테스트%
        예) '테스트'로 시작하는               테스트%
        예) '테스트'로 끝나는                 %테스트
        예) '테스트'로 시작하는 6자리 문자    테스트___
 */
-- 9. board 테이블에서 제목(title)에 '테스트'가 포함된 게시글을 조회하시오.
SELECT * FROM board
WHERE title LIKE '%테스트%';

-- product 테이블
CREATE TABLE product (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(100),
  price INT,
  stock INT,
  category VARCHAR(50)
);

INSERT INTO product VALUES
(1,'노트북',150000,10,'전자제품'),
(2,'마우스',20000,0,NULL),
(3,'키보드',30000,50,'전자제품');

/* 
      NULL 관련 연산자
        IS NULL       NULL 이다
        IS NOT NULL   NULL이 아니다.
 */
-- 10. product 테이블에서 카테고리(category)가 NULL인 상품을 조회하시오.
SELECT * FROM product
WHERE category IS NULL;

/* 
    SELECT 컬럼1, 컬럼2, ...
    FROM 테이블
    [WHERE 조건]
    [ORDER BY 컬럼 [ASC|DESC]]

        - 정렬: ASC(오름차순, 생략), DESC(내림차순)
*/
-- 11. member 테이블에서 회원을 포인트(point)를 기준으로 내림차순으로 조회하시오.
SELECT * FROM member
ORDER BY point; -- 오름차순
SELECT * FROM member
ORDER BY point DESC; -- 내림차순

/* 
    SELECT 컬럼1, 컬럼2, ...
    FROM 테이블
    [WHERE 조건]
    [ORDER BY 컬럼 [ASC|DESC]]
    [LIMIT 행수];
*/
-- 12. member 테이블에서 포인트(point) 상위 3명의 회원을 조회하시오.
SELECT * FROM member
LIMIT 3; -- 3명의 회원 조회
SELECT * FROM member
ORDER BY point DESC
LIMIT 3; -- 포인트(point) 상위 3명의 회원 조회


/* 
    집계 함수
      1. count(컬럼)      행의 수(NULL 제외)
          - count(*)      전체 행 수(NULL 포함)
      2. sum(숫자컬럼)    합계(NULL 제외)
      3. avg(숫자컬럼)    평균(NULL 제외)
      4. max(컬럼)        최댓값
      5. min(컬럼)        최솟값
*/

/* 
    SELECT 컬럼1 [AS 별칭], 컬럼2 [AS 별칭], ...
    FROM 테이블;

 */
-- 13. member 테이블에서 회원의 평균 포인트(point)를 조회하시오.
SELECT AVG(point) AS 평균 FROM member;


/* 
      DML: select, insert, update, delete

      SELECT 컬럼1, 컬럼2, ...
      FROM 테이블
      [WHERE 조건]
      [GROUP BY 컬럼 [HAVING 그룹조건]]
      [ORDER BY 컬럼 [ASC|DESC]]
      [LIMIT 행수]

        - LIMIT는 MySQL 전용!
 */
-- 14. member 테이블에서 등급별(grade, 그룹) 회원 수를 조회하시오.
SELECT COUNT(member_id) AS `회원 수` FROM member; -- 전체 행 수 -> 회원 수
SELECT grade, COUNT(*) FROM member
GROUP BY grade;

-- 15. member 테이블에서 회원 수가 2명 이상인 등급만 조회하시오.
SELECT grade AS 등급, CONCAT(COUNT(*), '명') AS 인원수
FROM member
GROUP BY grade HAVING COUNT(*) >= 2;

/* 
    서브쿼리
      1. 반드시 괄호()로 감싼다.
      2. 안쪽 쿼리(서브쿼리)가 먼저 실행된다.
      3. select, from, where 등 여러 위치에서 사용된다.
      4. 스칼라 서브쿼리 -> select 절의 서브쿼리
      5. 인라인 뷰 -> from 절의 서브쿼리
      6. AS 절: 별칭(Alias) 부여
        - 테이블의 별칭은 생략 권장, 컬럼의 별칭은 사용 권장 (관례)

      SELECT 컬럼
      FROM 테이블
      WHERE 컬럼 = (SELECT 문장);

      SELECT 컬럼
      FROM (SELECT 문장)
      WHERE 컬럼

      SELECT 컬럼, (SELECT 문장) AS 별칭
      FROM 테이블
      WHERE 컬럼

*/
-- 16. member 테이블에서 평균(AVG) 포인트(point) 이상(>=)인 회원을 조회하시오.
-- 기록순서: SELECT 절 -> FROM 절 -> WHERE 절
-- 실행순서: FROM 절 -> WHERE 절 -> SELECT 절
-- member 테이블로부터 point가 평균(member 테이블로 부터 point의 평균을 조회한다.) 이상인 모든 컬럼(*)을 조회한다.
SELECT * FROM member
WHERE point >= (SELECT AVG(point) FROM member);
SELECT AVG(point) FROM member;


-- orders 테이블
CREATE TABLE orders (
  order_id INT PRIMARY KEY AUTO_INCREMENT,
  member_id INT,
  total_price INT,
  status VARCHAR(30),
  order_date DATE
);

INSERT INTO orders VALUES
(1,1,120000,'주문완료','2025-01-01'),
(2,2,50000,'취소','2023-01-01'),
(3,3,0,'취소','2024-01-01'),
(4,5,300000,'주문완료','2025-02-01');

-- 17. 주문을 한 회원의 정보만 조회하시오.
SELECT * FROM member;
SELECT member_id FROM orders; -- 1, 2, 3, 5
SELECT * FROM member
WHERE member_id IN(SELECT member_id FROM orders);


/* 
    조인(JOIN) 
      - 둘 이상의 테이블을 연결
      - 키(Key): PK(기본키), FK(외래키)
      
      1. [INNER] JOIN(내부 조인)
      2. 외부 조인
        - LEFT OUTER JOIN(왼쪽 외부 조인)
        - RIGHT OUTER JOIN(오른쪽 외부 조인)

      SELECT 컬럼
      FROM 테이블a [INNER] JOIN 테이블b 
      [ON 테이블a.컬럼 = 테이블b.컬럼]
      [WHERE 조건]

      SELECT 컬럼
      FROM 테이블a LEFT JOIN 테이블b 
      [ON 조인조건]
      [WHERE 조건]

 */
-- 18. 주문 정보와 회원 이름을 함께 조회하시오.
-- 단, 이름과 주문 번호와 총 가격만 출력한다.
SELECT * FROM orders;
SELECT m.member_id, m.name, o.order_id, o.total_price 
FROM member m JOIN orders o
on m.member_id = o.member_id;

-- 19. 주문이 없는 회원도 포함하여 조회하시오.
SELECT m.member_id, m.name, o.order_id, o.total_price 
FROM member m LEFT JOIN orders o
on m.member_id = o.member_id;

/* 
    SELECT 컬럼1, [DISTINCT] 컬럼2, ...
    FROM 테이블1 
    [JOIN 테이블2 ON 조인조건]
    [WHERE 조건]
    [GROUP BY 컬럼 [HAVING 그룹조건]]
    [ORDER BY 컬럼 [ASC|DESC]]
    [LIMIT 행수];
*/
-- 20. 주문 상태의 종류를 중복 없이(distinct) 조회하시오.
SELECT DISTINCT status FROM orders;

-- 21. board 테이블의 열(column) 정보를 확인하시오.
SHOW COLUMNS FROM board;
