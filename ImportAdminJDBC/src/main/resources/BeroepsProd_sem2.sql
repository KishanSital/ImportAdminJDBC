
DROP SCHEMA if EXISTS Importadmin;
CREATE SCHEMA Importadmin;
USE Importadmin;

DROP TABLE IF EXISTS product;
CREATE TABLE product(
product_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
product_name VARCHAR(255) NOT NULL
);

INSERT INTO product (product_id, product_name) VALUES ( '1','Hand sanitizer');
INSERT INTO product (product_id, product_name) VALUES ( '2','Toilet paper');
INSERT INTO product (product_id, product_name) VALUES ( '3','n59 masks');
INSERT INTO product (product_id, product_name) VALUES ( '4','Gloves');
INSERT INTO product (product_id, product_name) VALUES ( '5','Multi-vitamins & minerals');

DROP TABLE IF EXISTS customer;
CREATE TABLE customer(
customer_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
customer_name VARCHAR(255) NOT NULL,
customer_address VARCHAR(255) NOT NULL,
customer_telephone VARCHAR(12) NOT NULL);

INSERT INTO customer (customer_id, customer_name, customer_address, customer_telephone ) VALUES ( '1','Kishan Sital','Garnizoenspad 4','005978544998');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_telephone ) VALUES ( '2','Merel Biswane','Saramaccastraat 179','005978835272');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_telephone ) VALUES ( '3','Zafilio Nijman','Garnizoenspad 99','005978809309');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_telephone ) VALUES ( '4','Juscelino Kartoebi','Kalloeweg ','005978762511');

DROP TABLE IF EXISTS product_order;
CREATE TABLE product_order(
product_order_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
product_order_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FK_product_id INT (11) NOT NULL,
FK_customer_id INT (11) NOT NULL,
FOREIGN KEY (FK_customer_id) REFERENCES customer(customer_id),
FOREIGN KEY (FK_product_id) REFERENCES product(product_id)
);

INSERT INTO product_order (product_order_id, product_order_date, FK_product_id, FK_customer_id ) VALUES ( '1','2020-06-07 09:06:00','1','1');
INSERT INTO product_order (product_order_id, product_order_date, FK_product_id, FK_customer_id ) VALUES ( '2','2020-06-08 09:07:00','1','2');
INSERT INTO product_order (product_order_id, product_order_date, FK_product_id, FK_customer_id ) VALUES ( '3','2020-06-09 09:08:00','2','1');
INSERT INTO product_order (product_order_id, product_order_date, FK_product_id, FK_customer_id ) VALUES ( '4','2020-06-10 09:09:00','2','2');




