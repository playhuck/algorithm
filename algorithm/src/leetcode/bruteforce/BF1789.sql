# +---------------+---------+
# | 컬럼명        | 타입    |
# +---------------+---------+
# | employee_id   | int     |
# | department_id | int     |
# | primary_flag  | varchar |
# +---------------+---------+
#
# (employee_id, department_id)가 기본키(중복되지 않는 유일한 값의 조합)입니다.
# employee_id는 직원의 ID입니다.
# department_id는 직원이 속한 부서의 ID입니다.
# primary_flag는 ('Y', 'N') 타입의 ENUM입니다. 'Y'면 해당 부서가 직원의 주요 부서이고, 'N'이면 주요 부서가 아닙니다.
#
# 직원들은 여러 부서에 속할 수 있습니다. 직원이 다른 부서에 속할 때, 어느 부서가 주요 부서인지 결정해야 합니다. 단, 직원이 하나의 부서에만 속한 경우 primary_flag는 'N'입니다.
# 모든 직원의 주요 부서를 보고하는 쿼리를 작성하세요. 한 부서에만 속한 직원의 경우 해당 부서를 보고하면 됩니다.
# 결과 테이블은 어떤 순서로 반환해도 됩니다.

CREATE TABLE Employee (
    employee_id INT,
    department_id INT,
    primary_flag VARCHAR(1) CHECK (primary_flag IN ('Y', 'N')),
    PRIMARY KEY (employee_id, department_id)
);

# +-------------+---------------+--------------+
# | employee_id | department_id | primary_flag |
# +-------------+---------------+--------------+
# | 1           | 1             | N            |
# | 2           | 1             | Y            |
# | 2           | 2             | N            |
# | 3           | 3             | N            |
# | 4           | 2             | N            |
# | 4           | 3             | Y            |
# | 4           | 4             | N            |
# +-------------+---------------+--------------+
# Output:
# +-------------+---------------+
# | employee_id | department_id |
# +-------------+---------------+
# | 1           | 1             |
# | 2           | 1             |
# | 3           | 3             |
# | 4           | 3             |
# +-------------+---------------+

/*
    같은 컬럼에 다른 조건으로 가져와야할 때
 */
SELECT e.employee_id,department_id
FROM Employee AS e
WHERE e.primary_flag = 'Y' OR (
        employee_id IN (
            SELECT employee_id
            FROM Employee
            GROUP BY employee_id
            having count(Employee.employee_id) = 1
            )
    )
GROUP BY e.employee_id