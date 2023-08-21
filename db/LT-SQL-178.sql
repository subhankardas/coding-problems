-- QUES: Write a solution to find the rank of the scores. 
-- create table
Create table Scores (id int, score DECIMAL(3,2));

-- insert data
insert into Scores (id, score) values ('1', '3.5');
insert into Scores (id, score) values ('2', '3.65');
insert into Scores (id, score) values ('3', '4.0');
insert into Scores (id, score) values ('4', '3.85');
insert into Scores (id, score) values ('5', '4.0');
insert into Scores (id, score) values ('6', '3.65');

-- view data
SELECT score, DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'
FROM Scores;

-- Here RANK() - would assign ranks to identical values, so there might be gaps in the ranks.
-- But DENSE_RANK() - handles tied ranks maintaining the sequence without any gaps.
