insert into customer (id, first_name, last_name, gender, date_of_birth) values (1, 'John', 'Doe', 'male', '1985-08-26');
insert into customer (id, first_name, last_name, gender, date_of_birth) values (2, 'Max', 'Zion', 'male', '1972-12-15');
insert into customer (id, first_name, last_name, gender, date_of_birth) values (3, 'Jane', 'Murphy', 'female', '1960-04-30');

insert into phone_number (id, customer_id, phone_number, phone_type) values (1, 1, '303-987-6543', 'Cell');
insert into phone_number (id, customer_id, phone_number, phone_type) values (2, 1, '303-987-6542', 'Home');
insert into phone_number (id, customer_id, phone_number, phone_type) values (3, 2, '720-564-0001', 'Home');
insert into phone_number (id, customer_id, phone_number, phone_type) values (4, 3, '910-123-0001', 'Cell');
insert into phone_number (id, customer_id, phone_number, phone_type) values (5, 3, '910-123-0002', 'Home');
insert into phone_number (id, customer_id, phone_number, phone_type) values (6, 3, '910-123-0003', 'Work');

insert into drivers_license (id, customer_id, state, license_number, expiration_date) values (1, 1, 'Colorado', '987-652-332', '2023-09-30');
insert into drivers_license (id, customer_id, state, license_number, expiration_date) values (2, 2, 'Kansas', '871-22-345', '2028-08-31');
insert into drivers_license (id, customer_id, state, license_number, expiration_date) values (3, 3, 'Utah', '263-54-9729', '2025-12-31');
