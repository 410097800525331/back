
/* 
    서브쿼리
        - 쿼리 안의 쿼리
        - 서브쿼리는 반드시 괄호()로 감싼다.

        1. SELECT 절의 컬럼으로 사용 -> 스칼라 서브쿼리
        2. FROM 절의 테이블로 사용 -> 인라인 뷰
        3. WHERE 절의 값으로 사용 -> 서브쿼리
        4. GROUP BY 컬럼 HAVING 절의 값으로 사용
*/

-- 1. 평균 급여보다 급여(salary)가 높은(>) 사원(emp_name)을 조회하시오.
/* 
    SELECT 컬럼, ...
    FROM 테이블
    WHERE 컬럼 연산자 (
        SELECT 컬럼 
        FROM 테이블 
        [WHERE 조건]
    );

    단일 행 서브쿼리
        - 예를들어 평균값을 딱 하나(단일 행)만 나오므로
          비교 연산자(=, >, <, >=, <=, <>)를 사용한다.
*/
SELECT AVG(salary)
FROM employee; -- 3875.0000

SELECT emp_name, salary
FROM employee
WHERE salary > (
    SELECT AVG(salary) 
    FROM employee
);

/* 
    다중 행 서브쿼리
        - 여러 행을 반환할 수 있으므로
          IN, ANY, ALL 연산자를 사용한다.
        - IN: 서브쿼리가 반환하는 값들 중 하나와 일치하는 경우
        - ANY: 서브쿼리가 반환하는 값들 중 하나라도 조건을 만족하는 경우
        - ALL: 서브쿼리가 반환하는 모든 값이 조건에 만족하는 경우
*/
-- 2. 개발 또는 인사 부서에 속한 사원을 조회하시오.
-- IN: ~또는, ~중에 하나
-- IN ("개발", "인사")
SELECT emp_name, dept_id
FROM employee
WHERE dept_id IN (
    SELECT dept_id
    FROM department
    WHERE dept_name IN ("개발", "인사")
);

SELECT dept_id
FROM department
WHERE dept_name IN ("개발", "인사");


SELECT * FROM employee;
INSERT INTO employee VALUES
(5, '김철수', 3700, 20),
(6, '안중근', 4600, 20),
(7, '이용식', 3200, 20);

-- 3. 인사 부서 사원 중 최소 급여보다 급여가 높은 사원을 조회하시오.
SELECT emp_name, salary, dept_id
FROM employee
WHERE salary > ANY (
    SELECT salary
    FROM employee
    WHERE dept_id = 20
);


-- 4. 인사 부서 사원 중 최대 급여보다 급여가 높은 사원을 조회하시오.

SELECT emp_name, salary, dept_id
FROM employee
WHERE salary > ALL (
    SELECT salary
    FROM employee
    WHERE dept_id = 20
);

SELECT dept_name, dept_id
FROM department
WHERE dept_id = 20;

SELECT emp_name, salary, dept_id
FROM employee
WHERE dept_id = 20;

/* 
    EXISTS 서브쿼리
        - 서브쿼리의 결과가 존재하는지 여부를 확인
        - 서브쿼리가 하나 이상의 행을 반환하면 TRUE,
          아니면 FALSE를 반환
        - 서브쿼리 내 SELECT 1에서 숫자 1은 
          특별한 기능적 의미가 있는 것이 아니라,
          단순히 "해당 조건을 만족하는 행(Row)이 존재하는지"만
          확인하기 위한 관용적 표현이다.

            SELECT 컬럼
            FROM 테이블1 별칭1
            WHERE EXISTS (
                SELECT 1
                FROM 테이블2 별칭2
                WHERE 별칭1.공통컬럼1 = 별칭2.공통컬럼2
            );


*/
-- 5. 사원이 존재하는 부서만 조회하시오.
-- 10(개발), 20(인사)
-- 30(영업)은 사원이 없음
SELECT * FROM department;

SELECT dept_name
FROM department
WHERE dept_name <> "영업";

SELECT dept_name
FROM department d -- 10, 20, 30
WHERE EXISTS (
    SELECT 1
    FROM employee e
    WHERE e.dept_id = d.dept_id -- 10, 20 = 10, 20, 30
);

-- 조인으로 한다면
SELECT DISTINCT dept_name
FROM department d
JOIN employee e
ON d.dept_id = e.dept_id;

SELECT dept_name
FROM department
WHERE dept_id IN (SELECT DISTINCT dept_id FROM employee);
-- WHERE dept_id IN (10, 20, NULL);

SELECT dept_id FROM employee; -- 10, 10, 20, 20, 20, 20, NULL
SELECT DISTINCT dept_id FROM employee; -- 10, 20, NULL

-- 6. 사원이 없는 부서를 조회하시오.
-- 30(영업)은 사원이 없음
SELECT dept_name
FROM department d -- 10, 20, 30
WHERE NOT EXISTS (
    SELECT 1
    FROM employee e
    WHERE e.dept_id = d.dept_id -- 10, 20 = 10, 20, 30
);

/* 
    스칼라 서브쿼리
        - SELECT 절의 서브쿼리
        
        SELECT 컬럼 [AS] 별칭, ..., 
            (SELECT 컬럼, ... FROM 테이블 [WHERE 조건]) [AS] 별칭
        FROM 테이블
        [WHERE 조건]
*/
-- 7. 각 사원의 이름과 급여, 전체 평균 급여를 함께 조회하시오.
SELECT emp_name AS 이름 , salary AS 급여, 
    (SELECT AVG(salary) FROM employee) AS `평균 급여`
FROM employee;

SELECT AVG(salary)
FROM employee; -- 3685.7143

/* 
        인라인 뷰 서브쿼리
            - FROM 절에 임시 테이블을 생성한다.

            SELECT 컬럼
            FROM (SELECT 컬럼 FROM 테이블 [WHERE 조건]) [AS] 별칭
            [WHERE 조건]
 */
-- 8. 부서별 평균 급여가 4000 이상인 부서를 조회하시오.
SELECT dept_id, avg_salary
FROM (SELECT dept_id, AVG(salary) AS avg_salary
      FROM employee
      GROUP BY dept_id) t -- 4500, 3450, 3000 각 3개의 평균
WHERE avg_salary >= 4000;

-- 부서명을 조회하려면?
SELECT dept_name
FROM department d
WHERE (SELECT AVG(salary) AS avg_salary
       FROM employee e
       WHERE e.dept_id = d.dept_id) >= 4000;

SELECT AVG(salary) AS avg_salary
FROM employee
GROUP BY dept_id;


-- 9. 각 부서에서 평균 급여보다 많이 받는 사원을 조회하시오.
SELECT emp_name, salary, dept_id
FROM employee e1
WHERE salary > (
    SELECT AVG(salary)
    FROM employee e2
    WHERE e2.dept_id = e1.dept_id
);

SELECT AVG(salary)
FROM employee; -- 3685.7143

SELECT AVG(salary)
FROM employee
WHERE dept_id = 20; -- 3450.0000

-- 10. 평균 급여보다 높은 사원을 JOIN 방식으로도 조회하시오.
-- 서브쿼리 + 조인
SELECT e.emp_name, e.salary
FROM employee e
JOIN (SELECT AVG(salary) AS avg_salary
      FROM employee) AS t
ON e.salary > t.avg_salary;


SELECT * FROM employee;
SELECT * FROM department;