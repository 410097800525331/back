CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(30)
);

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(30),
    salary INT,
    dept_id INT
);

INSERT INTO department VALUES
(10, '개발'),
(20, '인사'),
(30, '영업');

INSERT INTO employee VALUES
(1, '홍길동', 4000, 10),
(2, '이순신', 5000, 10),
(3, '강감찬', 3500, 20),
(4, '유관순', 3000, NULL);

SELECT * FROM employee;
SELECT * FROM department;

/* 
    조인(JOIN)
        1. 내부 외부: [inner] join
        2. 외부 조인
            - 왼쪽 외부 조인: left [outer] join
            - 오른쪽 외부 조인: right [outer] join
            - FULL OUTER JOIN (MySQL8은 지원x) -> UNION
*/

-- 1. 사원(employee)이 속한 부서(department) 이름을 함께 조회하시오.
-- 직원명(emp_name), 부서명(dept_name)
/* 
    내부 조인(INNER JOIN)
        SELECT [테이블.]필드, ...
        FROM 테이블1 [AS] 별칭1
        [INNER] JOIN 테이블2 [AS] 별칭2
        ON 별칭1.컬럼 = 별칭2.컬럼;
*/

-- 내부 조인
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
JOIN department d
ON e.dept_id = d.dept_id;

-- 2. 부서가 없는 사원도 포함하여 사원명과 부서명을 조회하시오.
-- 왼쪽 외부 조인
/* 
    SELECT 테이블.컬럼 AS 별칭, 테이블.컬럼 AS 별칭
    FROM 테이블1 [AS] 별칭1 
    LEFT [OUTER] JOIN 테이블2 [AS] 별칭2
    ON 별칭1.컬럼 = 별칭2.컬럼;
*/

SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
LEFT JOIN department d
ON e.dept_id = d.dept_id;

SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
LEFT JOIN department d
ON e.dept_id = d.dept_id
WHERE d.dept_id IS NULL;

-- 3. 소속 사원이 없는 부서도 포함하여 조회하시오.
-- 오른쪽 외부 조인
/* 
    SELECT 테이블.컬럼 AS 별칭, 테이블.컬럼 AS 별칭
    FROM 테이블1 [AS] 별칭1 
    RIGHT [OUTER] JOIN 테이블2 [AS] 별칭2
    ON 별칭1.컬럼 = 별칭2.컬럼;
*/
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
RIGHT JOIN department d
ON e.dept_id = d.dept_id;

SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
RIGHT JOIN department d
ON e.dept_id = d.dept_id
WHERE e.emp_name IS NULL;

-- 4. 사원과 부서의 모든 조합을 조회하시오.
-- 
/* 
    교차 조인(CROSS JOIN, 카티션 곱)
        - 두 테이블의 모든 조합을 조회

            SELECT *
            FROM 테이블1 AS 별칭1
            CROSS JOIN 테이블2 AS 별칭2
*/
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
CROSS JOIN department d;


-- 5. 같은 테이블(employee)을 사용하여 이름이 다른 사원끼리 이름을 나란히 조회하시오.
-- 자기 조인(self join)
/* 
    같은 테이블을 별칭을 다르게하여 두 번 이상 사용하는 조인

        SELECT 컬럼, ...
        FROM 테이블1 AS 별칭1
        JOIN 테이블1 AS 별칭2
        ON 별칭1.컬럼 = 별칭2.컬럼
*/
SELECT e1.emp_name AS 이름1, e2.emp_name AS 이름2
FROM employee e1
JOIN employee e2
ON e1.emp_id <> e2.emp_id;

-- FULL OUTER JOIN (MySQL8은 지원하지 않음)
-- UNION 연산자로 LEFT와 RIGHT를 결합한다.
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
LEFT JOIN department d
ON e.dept_id = d.dept_id
UNION
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
RIGHT JOIN department d
ON e.dept_id = d.dept_id;

SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
LEFT JOIN department d
ON e.dept_id = d.dept_id
WHERE d.dept_id IS NULL
UNION
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
RIGHT JOIN department d
ON e.dept_id = d.dept_id
WHERE e.emp_name IS NULL;


-- 6. USING 절을 사용하여 사원과 부서를 조인하시오.
/* 
    USING 절
        - 공통 컬럼명이 동일할 경우 사용!
        
        SELECT 컬럼
        FROM 테이블1 [AS] 별칭1
        JOIN 테이블2 [AS] 별칭2
        USING (공통컬럼)
*/
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
JOIN department d
USING (dept_id);

-- 7. 공통 컬럼을 기준으로 자동 조인을 수행하시오.
/* 
    자연 조인(Natural Join)
        - 공통 컬럼을 기준으로 자동 조인

        SELECT 컬럼
        FROM 테이블1 AS 별칭1
        NATURAL JOIN 테이블2 AS 별칭2;
*/
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e
NATURAL JOIN department d;

-- 8. 개발 부서 사원만 조회하시오.
SELECT e.emp_name AS 이름, d.dept_name AS 부서
FROM employee e 
JOIN department d
ON e.dept_id = d.dept_id
WHERE dept_name = '개발';

-- 9. 부서별 평균 급여를 조회하시오.
SELECT d.dept_name AS 부서, AVG(e.salary) AS 평균급여
FROM employee e
NATURAL JOIN department d
GROUP BY d.dept_name;

SELECT d.dept_name, AVG(e.salary) AS avg_salary
FROM employee e
JOIN department d
ON e.dept_id = d.dept_id
GROUP BY d.dept_name;


