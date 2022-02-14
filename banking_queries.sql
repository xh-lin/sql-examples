use Banking;
/*
1. For each product, show the product name "Product" and the product type name "Type".
*/
SELECT name as "Product", product_type_cd as "Type"
FROM product;
/*
2. For each branch, list the branch name and city, plus the last name and title of each employee who works in that branch.
*/
SELECT name, city, e.last_name, e.title
FROM branch AS b
JOIN employee AS e ON b.branch_id = e.assigned_branch_id;
/*
3. Show a list of each unique employee title.
*/
SELECT DISTINCT title
FROM employee;
/*
4. Show the last name and title of each employee, along with the last name and title of that employee's boss.
*/
SELECT e.last_name, e.title, s.last_name, s.title
FROM employee AS e
LEFT JOIN employee AS s on e.superior_emp_id = s.emp_id;
/*
5. For each account, show the name of the account's product, the available balance, and the customer's last name.
*/
SELECT p.name, a.avail_balance, i.last_name
FROM account AS a
LEFT JOIN product AS p ON a.product_cd = p.product_cd
JOIN individual as i ON a.cust_id = i.cust_id;
/*
6. List all account transaction details for individual customers whose last name starts with 'T'.
*/
SELECT at.*
FROM individual AS i
JOIN account AS a ON i.cust_id = a.cust_id
JOIN acc_transaction AS at ON a.account_id = at.account_id
WHERE SUBSTR(i.last_name, 1, 1) = 'T';

