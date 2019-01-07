use customers_db;

create table customer(
id int PRIMARY KEY AUTO_INCREMENT,
firstName varchar(40),
lastName varchar(40),
gender varchar(10)
);

drop table customer;