USE mock_sba_db;
/*
1. Create a query to return all orders made by users with the first name of “Marion”
*/
SELECT o.*
FROM orders AS o
JOIN users AS u ON o.user_id = u.user_id
WHERE u.first_name = "Marion";
/*
2. Create a query to select all users that have not made an order
*/
SELECT *
FROM users
WHERE user_id NOT IN (SELECT user_id FROM orders);
/*
3. Create a Query to select the names and prices of all items that have been part of 2 or 
more separate orders.
*/
SELECT i.*
FROM items AS i
JOIN order_items AS oi ON i.item_id = oi.item_id
GROUP BY i.item_id
	HAVING count(oi.order_id) > 1;
/*
4. Create a query to return the Order Id, Item name, Item Price, and Quantity from orders 
made at stores in the city “New York”. Order by Order Id in ascending order.
*/
SELECT o.order_id, i.name, i.price, oi.quantity
FROM orders AS o
JOIN order_items AS oi ON o.order_id = oi.order_id
JOIN items AS i ON oi.item_id = i.item_id
WHERE o.store_id IN (
	SELECT store_id FROM stores WHERE city = "New York")
ORDER BY o.order_id;
/*
5. Your boss would like you to create a query that calculates the total revenue generated 
by each item. Revenue for an item can be found as (Item Price * Total Quantity 
Ordered). Please return the first column as ‘ITEM_NAME’ and the second column as 
‘REVENUE’.
*/
SELECT i.name AS `ITEM_NAME`, SUM(tot_quantity*i.price) AS `REVENUE`
FROM items AS i
JOIN (
	SELECT item_id, SUM(quantity) AS tot_quantity
    FROM order_items
    GROUP BY item_id
) AS oi ON i.item_id = oi.item_id
GROUP BY i.name;
/*
6. Create a query with the following output:
	a. Column 1 - Store Name
		i. The name of each store
	b. Column 2 - Order Quantity
		i. The number of times an order has been made in this store
	c. Column 3 - Sales Figure
		i. If the store has been involved in more than 3 orders, mark as ‘High’
		ii. If the store has been involved in less than 3 orders but more than 1 order, mark as ‘Medium’
		iii. If the store has been involved with 1 or less orders, mark as ‘Low’
	d. Should be ordered by the Order Quantity in Descending Order
*/
SELECT s.name, COUNT(*) AS `ORDER_QUANTITY`, 
	(CASE
		WHEN COUNT(*) > 3 THEN "High"
        WHEN COUNT(*) > 1 THEN "Medium"
        ELSE "Low"
    END) AS `SALES_FIGURE`
FROM stores s
JOIN orders o ON s.store_id = o.store_id
GROUP BY s.name
ORDER BY `ORDER_QUANTITY` DESC;


