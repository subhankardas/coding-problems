-- QUES: Write a solution to find the nth highest salary from the employee table.
-- If there is no nth highest salary, return null.
-- create table
CREATE TABLE employee (emp_id int, salary int);

-- insert data
INSERT INTO employee (emp_id, salary) values ('1', '100');

INSERT INTO employee (emp_id, salary) values ('2', '200');

INSERT INTO employee (emp_id, salary) values ('3', '300');

-- 1. create function
CREATE FUNCTION get_nth_highest_salary(N INT) RETURNS INT
BEGIN
    DECLARE result INT;
    SET result = NULL;
    SET N = N-1;
    
    SELECT DISTINCT salary INTO result
    from employee 
    order by salary DESC
    LIMIT 1 OFFSET N;
    
    RETURN result;
END

SELECT get_nth_highest_salary (1) as result;

--
--
--
-- 2. create procedure
CREATE PROCEDURE get_nth_highest_salary_proc(IN N INT, OUT nth_highest_salary INT)
BEGIN
    DECLARE nth_salary INT;

    SET @sql = CONCAT(
        'SELECT salary INTO @nth_salary FROM (',
        'SELECT DISTINCT salary FROM employee ORDER BY Salary DESC LIMIT ', N - 1, ', 1',
        ') AS t'
    );
    
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    
    SET nth_highest_salary = @nth_salary;

    DEALLOCATE PREPARE stmt;
        
    IF nth_highest_salary IS NULL THEN
        SET nth_highest_salary = NULL;
    END IF;
END

SET @N = 1;

CALL get_nth_highest_salary_proc (@N, @nth_highest_salary);

SELECT @nth_highest_salary as proc_result;