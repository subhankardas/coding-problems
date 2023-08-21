-- QUES: Write a solution to find the nth highest salary from the Employee table. 
-- If there is no nth highest salary, return null.
-- create table
Create table Employee (Id int, Salary int);

-- insert data
insert into Employee (id, salary) values ('1', '100');
insert into Employee (id, salary) values ('2', '200');
insert into Employee (id, salary) values ('3', '300');

-- view data
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE result INT;
    SET result = NULL;
    SET N = N-1;
    
    SELECT DISTINCT salary INTO result
    from Employee 
    order by salary DESC
    LIMIT 1 OFFSET N;
    
    RETURN result;
END