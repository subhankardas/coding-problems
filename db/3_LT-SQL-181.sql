
-- QUES: Write a solution to find the employees who earn more than their managers.
-- create table
CREATE TABLE employee (id INT, name VARCHAR(100), salary INT, manager_id INT);

-- insert data
INSERT INTO employee (id, name, salary, manager_id) VALUES (1, 'Joe', '70000', 3);
INSERT INTO employee (id, name, salary, manager_id) VALUES (2, 'Henry', '80000', 4);
INSERT INTO employee (id, name, salary) VALUES (3, 'Sam', '60000');
INSERT INTO employee (id, name, salary) VALUES (4, 'Max', '90000');

-- view data
SELECT em.name AS employee
FROM employee as em
    INNER JOIN employee as mn ON em.manager_id = mn.id
WHERE
    em.salary > mn.salary;