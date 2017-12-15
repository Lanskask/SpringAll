SELECT vendors.vend_name, products.prod_name, products.prod_price
FROM Vendors, Products
    where Vendors.vend_id = products.vend_id;

SELECT vend_name, products.prod_name, products.prod_price
FROM Vendors INNER JOIN Products
    ON Vendors.vend_id = products.vend_id;

-- ===========
SELECT prod_name, vend_name, prod_price, quantity
FROM orderitems, Products, Vendors
WHERE Products.vend_id = Vendors.vend_id
      AND orderitems.prod_id = Products.prod_id
      AND order_num = 20007;