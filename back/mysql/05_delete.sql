/* 
    SQL
        1. DDL
            - DB(스키마) 생성, 삭제
            - 테이블 생성, 삭제, 변경
        2. DML
            - insert    Create
            - select    Read
            - update    Update
            - delete    Delete
        3. DCL+TCL
*/
/* 
    DELETE FROM 테이블
    [WHERE 조건];
 */

-- 1. member_id가 3인 회원을 삭제하시오.
DELETE FROM member
WHERE member_id = 3;

-- 2. 이름이 '중복회원'인 회원을 삭제하시오.
DELETE FROM member
WHERE name = '중복회원';

-- 3. 나이가 25 미만인 회원을 삭제하시오.
DELETE FROM member
WHERE age < 25;

-- 4. 성별이 F이고 등급이 SILVER인 회원을 삭제하시오.
DELETE FROM member
WHERE gender = 'F' AND grade = 'SILVER';

-- 5. 등급이 VIP 또는 GOLD인 회원을 삭제하시오.
DELETE FROM member
WHERE grade IN('VIP', 'GOLD');

-- 6. 주문 번호가 1~2 사이인 주문을 삭제하시오.
-- 날짜 데이터타입: DATE -> 문자열 처리
INSERT INTO member VALUES
(1, '홍길동',35,'M', 0, 'VIP','2023-01-01'),
(2, '이순신',22,'M', 0, 'BRONZE','2022-01-01'),
(3, '김영희',19,'F', 0, 'BRONZE','2025-01-01'),
(8, '박철수',45,'M', 0, 'GOLD','2021-01-01'),
(10, '최민수',31,'F', 0, 'SILVER','2024-01-01');

-- 7. 2022년 이전에 가입한 회원을 삭제하시오.
DELETE FROM member
WHERE regdate < '2022-01-01';


-- 8. 상품(product) 테이블의 카테고리가 NULL인 상품을 삭제하시오.
DELETE FROM product
WHERE category IS NULL;
SELECT * FROM product;

-- 9. 게시판(board) 테이블의 제목(title)에 '테스트'가 포함된 게시글을 삭제하시오.
DELETE FROM board
WHERE title LIKE '%테스트%';
SELECT * FROM board;


-- 10. 주문(orders) 테이블의 평균 주문 금액(total_price)보다 작은 주문을 삭제하시오.
-- 모든 파생 테이블은 고유한 별칭을 가져야 합니다.
DELETE FROM orders
WHERE total_price < (SELECT avg_price FROM (SELECT AVG(total_price) AS avg_price FROM orders) AS temp );

DELETE FROM orders
WHERE total_price < 117500;

SELECT AVG(total_price) AS avg_price FROM orders; -- 117500.0000
SELECT * FROM orders;

-- 11. 게시판(board) 테이블에서 게시글을 2개 이상 작성한 작성자의 게시글을 삭제하시오.
DELETE FROM board
WHERE writer IN (
    (SELECT writer 
     FROM (SELECT writer 
           FROM board
           GROUP BY writer 
           HAVING count(*) >= 2
    ) AS temp_writers)
);

SELECT writer FROM board
GROUP BY writer HAVING count(*) >= 2;
SELECT * FROM board;

-- INSERT INTO 테이블명 [(필드1, ...)] VALUES (값1, ...), (값1, ...), ...;
INSERT INTO board (title, writer, view_cnt, regdate) VALUES ("자유글3", 'hong', 10, '2020-01-03');

-- 12. 등급이 BRONZE인 회원(member)의 주문(orders)을 삭제하시오.
DELETE o
FROM orders o JOIN member m 
ON o.member_id = m.member_id
WHERE m.grade = 'BRONZE';

SELECT * FROM orders;

INSERT INTO orders VALUES
(1,1,120000,'주문완료','2025-01-01'),
(2,2,50000,'취소','2023-01-01'),
(3,3,0,'취소','2024-01-01'),
(5,5,300000,'주문완료','2025-02-01');

-- 13. 주문 테이블(orders)에서 주문 상태가 '주문완료'인 주문을 삭제하시오.
DELETE FROM orders
WHERE status = '주문완료';

-- 14. board 테이블의 모든 데이터를 삭제하시오.
DELETE FROM board;

-- 15. 같은 제목의 게시글이 여러 개일 경우, 가장 최근 글을 제외하고 삭제하시오.
-- 같은 테이블을 조인
DELETE b1
FROM board b1 JOIN board b2
ON b1.title = b2.title AND b1.regdate < b2.regdate;
DELETE b1
FROM board b1 JOIN board b2
ON b1.title = b2.title AND b1.board_no < b2.board_no;

INSERT INTO board VALUES
(1,'테스트 글','hong',0,'2022-01-01'),
(2,'공지사항','admin',200,'2023-01-01'),
(3,'공지사항','hong',10,'2025-01-01'),
(4,'테스트 게시글','kim',5,'2021-01-01');


select * FROM board;