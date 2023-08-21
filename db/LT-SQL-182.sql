-- QUES: Write a solution to report all the duplicate emails.
-- create table
CREATE TABLE Person (id INT, email VARCHAR(100) NOT NULL);

-- insert data
INSERT INTO Person (id, email) VALUES (1, 'a@b.com');
INSERT INTO Person (id, email) VALUES (2, 'c@d.com');
INSERT INTO Person (id, email) VALUES (3, 'a@b.com');

-- view data
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;