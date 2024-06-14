-- QUES: Write a solution to report all the duplicate emails.
-- create table
CREATE TABLE users ( id INT, email VARCHAR(100) NOT NULL );

-- insert data
INSERT INTO users (id, email) VALUES (1, 'a@b.com');

INSERT INTO users (id, email) VALUES (2, 'c@d.com');

INSERT INTO users (id, email) VALUES (3, 'a@b.com');

-- view data
SELECT email AS duplicate_emails
FROM users
GROUP BY
    email
HAVING
    COUNT(email) > 1;