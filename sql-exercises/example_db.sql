create database example_db;
use example_db;

create table employee (
	emp_id int(4) primary key auto_increment,
    name varchar(255) not null default 'MISSING',
    age tinyint check(age >= 0)
);
describe employee;

insert into employee (name, age) values('keith', 25);
insert into employee (name, age) values('jafer', 1);
insert into employee (name, age) values('reema', 45);

SELECT * FROM employee;

create table address (
	address_id int(11) primary key auto_increment,
    street varchar(255) not null default 'unknown',
    city varchar(255) not null default 'unknown',
    state char(2) not null default '??',
    timestamp TIMESTAMP not null default NOW(6),
    fk_emp_id int(4),
    constraint some_name foreign key(fk_emp_id) references employee(emp_id)
);
describe address;

insert into address (street, city, state, fk_emp_id)
values ('123 st', 'plano', 'TX', 2);

