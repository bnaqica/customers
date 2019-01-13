CREATE TABLE if NOT EXISTS customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    gender VARCHAR(10)
);

CREATE TABLE if NOT EXISTS phone_number (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    phone_number VARCHAR(20),
    phone_type VARCHAR(20),
    FOREIGN KEY (customer_id)
    REFERENCES customer (id)
);