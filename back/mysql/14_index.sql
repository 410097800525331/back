SELECT * FROM employee;

/* 
1   홍길동  4000    10
2   이순신  5000    10
3   강감찬  3500    20
4   유관순  3000    NULL 
*/

SELECT * FROM department;
/* 
10  개발
20  인사
30  영업 
*/

/* 
1   홍길동  개발    4000
2   이순신  개발    5000
3   강감찬  인사    3500
4   유관순  NULL    3000
*/

-- 뷰 생성
CREATE VIEW vw_employee_info AS
SELECT e.emp_id, e.emp_name, d.dept_name, e.salary
FROM employee e
JOIN department d
ON e.dept_id= d.dept_id;

-- 뷰 조회
SELECT * FROM vw_employee_info;

-- 뷰 삭제
DROP VIEW vw_employee_info;

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
  grade VARCHAR(20),
  regdate DATE
);

-- 데이터 삽입
INSERT INTO member VALUES
(1, 'Hong Gildong', 35, 'M', 500, 3000000, 'VIP', '2023-01-01'),
(2, 'Yi Sunsin', 22, 'M', 200, 2500000, 'BRONZE', '2022-01-01'),
(3, 'Kim Younghee', 19, 'F', NULL, 1800000, 'BRONZE', '2025-01-01'),
(4, 'Park Cheolsu', 45, 'M', 900, 5000000, 'GOLD', '2021-01-01'),
(5, 'Choi Minsu', 31, 'F', 700, NULL, 'SILVER', '2024-01-01');


-- 1. member 테이블의 name 컬럼에 인덱스를 생성하시오.
-- 인덱스 생성
-- CREATE INDEX 인덱스 ON 테이블(컬럼);
CREATE INDEX idx_member_name ON member(name);

-- 2. member 테이블에 생성된 모든 인덱스를 확인하시오.
-- 테이블의 인덱스 전체 확인
-- SHOW INDEX FROM 테이블;
SHOW INDEX FROM member;

-- 3. 중복되면 안 되는 값(예: 회원 이름이 유일하다고 가정)에 대해 name 컬럼에 UNIQUE 인덱스를 생성하시오.
--  UNIQUE 인덱스
-- CREATE UNIQUE INDEX 인덱스 ON 테이블(컬럼);
CREATE UNIQUE INDEX idx_member_name_unique ON member(name);

-- 4. gender와 age 컬럼을 묶은 복합 인덱스를 생성하시오.
-- 복합 인덱스
-- CREATE INDEX 인덱스 ON 테이블(컬럼, ...);
CREATE INDEX idx_member_gender_age ON member(gender, age);

-- 5. 나이(age)가 35세인 회원을 조회하시오.
SELECT *
FROM member
WHERE age = 35;

-- 6. name 컬럼에 함수가 적용되어 인덱스를 사용할 수 없는 조회 SQL을 작성하시오.
SELECT *
FROM member
WHERE UPPER(name)='HONG GILDONG';

SELECT *
FROM member
WHERE name='HONG GILDONG';

-- 7. 실행 계획을 확인하여 name 인덱스 사용 여부를 판단하시오.
/* 
    실행 계획 확인
        - name 컬럼의 인덱스 사용 여부에 따라 검사 횟수가 달라진다.
        - EXPLAIN SELECT * FROM member WHERE name='Hong Gildong';

        1) 인덱스 사용: type=ref -> rows=1 -> 한 번에 찾음
        2) 인덱스 사용x: type=all -> rows=5 -> 레코드 전체를 검사
*/
EXPLAIN
SELECT *
FROM member
WHERE name='Hong Gildong';

SELECT * FROM member;

-- 8. name 컬럼에 생성한 인덱스를 삭제하시오.
-- 인덱스 삭제
-- DROP INDEX 인덱스 ON 테이블;
DROP INDEX idx_member_name ON member;
DROP INDEX idx_member_name_unique ON member;

-- 9. member 테이블의 기본 키가 자동으로 생성한 인덱스를 확인하시오.
-- 조건에 만족하는 인덱스 확인
-- SHOW INDEX FROM member WHERE 조건;
SHOW INDEX FROM member WHERE Key_name='PRIMARY';

-- 10. 다음과 같은 조회가 자주 발생한다고 가정한다. 
SELECT *
FROM member
WHERE regdate>='2024-01-01'
ORDER BY regdate DESC;

-- 이 쿼리를 빠르게 하기 위한 인덱스를 생성하시오.
CREATE INDEX idx_member_regdate ON member(regdate);