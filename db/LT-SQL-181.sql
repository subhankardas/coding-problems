
-- QUES: Write a solution to find the employees who earn more than their managers.
-- create table
CREATE TABLE Employee (id INT, name VARCHAR(100), salary INT, managerId INT);

-- insert data
INSERT INTO Employee (id, name, salary, managerId) VALUES (1, 'Joe', '70000', 3);
INSERT INTO Employee (id, name, salary, managerId) VALUES (2, 'Henry', '80000', 4);
INSERT INTO Employee (id, name, salary) VALUES (3, 'Sam', '60000');
INSERT INTO Employee (id, name, salary) VALUES (4, 'Max', '90000');

-- view data
SELECT em.name AS Employee
FROM Employee as em
INNER JOIN Employee as mn ON em.managerid = mn.id
WHERE em.salary > mn.salary;