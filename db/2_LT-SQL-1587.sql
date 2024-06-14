-- QUES: Write a solution to report the name and balance of users with a balance higher than 10000. 
-- The balance of an account is equal to the sum of the amounts of all transactions involving that account.
-- create tables
CREATE TABLE users (account int, name varchar(20));
CREATE TABLE transactions (trx_id int, account int, amount int, transacted_on date);

-- insert data
insert into users (account, name) values ('900001', 'Alice');
insert into users (account, name) values ('900002', 'Bob');
insert into users (account, name) values ('900003', 'Charlie');

insert into transactions (trx_id, account, amount, transacted_on) values ('1', '900001', '7000', '2020-08-01');
insert into transactions (trx_id, account, amount, transacted_on) values ('2', '900001', '7000', '2020-09-01');
insert into transactions (trx_id, account, amount, transacted_on) values ('3', '900001', '-3000', '2020-09-02');
insert into transactions (trx_id, account, amount, transacted_on) values ('4', '900002', '1000', '2020-09-12');
insert into transactions (trx_id, account, amount, transacted_on) values ('5', '900003', '6000', '2020-08-07');
insert into transactions (trx_id, account, amount, transacted_on) values ('6', '900003', '6000', '2020-09-07');
insert into transactions (trx_id, account, amount, transacted_on) values ('7', '900003', '-4000', '2020-09-11');

-- view data
SELECT us.name, SUM(tr.amount) as balance
FROM users as us
    RIGHT JOIN transactions as tr ON us.account = tr.account
GROUP BY
    us.account,
    us.name
HAVING
    SUM(tr.amount) > 10000;
