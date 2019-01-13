insert into customer (id, first_name, last_name, gender) values (1, 'John', 'Doe', 'male');
insert into customer (id, first_name, last_name, gender) values (2, 'Max', 'Zion', 'male');
insert into customer (id, first_name, last_name, gender) values (3, 'Jane', 'Murphy', 'female');

insert into phone_number (id, customer_id, phone_number, phone_type) values (1, 1, '303-987-6543', 'Cell');
insert into phone_number (id, customer_id, phone_number, phone_type) values (2, 1, '303-987-6542', 'Home');
insert into phone_number (id, customer_id, phone_number, phone_type) values (3, 2, '720-564-0001', 'Home');
insert into phone_number (id, customer_id, phone_number, phone_type) values (4, 3, '910-123-0001', 'Cell');
insert into phone_number (id, customer_id, phone_number, phone_type) values (5, 3, '910-123-0002', 'Home');
insert into phone_number (id, customer_id, phone_number, phone_type) values (6, 3, '910-123-0003', 'Work');
