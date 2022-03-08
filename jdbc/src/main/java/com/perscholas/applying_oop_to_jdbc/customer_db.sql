DROP DATABASE IF EXISTS customer_db;
CREATE DATABASE customer_db;
USE customer_db;

CREATE TABLE customer (
    id int(4) primary key auto_increment,
    email varchar(32) not null,
    fname varchar(32) not null,
    lname varchar(32) not null
);
DESCRIBE customer;

CREATE TABLE item (
    id int(4) primary key auto_increment,
    name varchar(32) not null,
    price decimal(4,2) not null
);
DESCRIBE item;

INSERT customer VALUES(1, "test1@test.com", "Jotaro", "Kujo");
INSERT customer VALUES(2, "test2@test.com", "Jolyne", "Cujoh");
INSERT customer VALUES(3, "test3@test.com", "Josuke", "Higashikata");

INSERT item VALUES(1, "Stone Mask", 99.5);
INSERT item VALUES(2, "Stand Arrow", 9.5);