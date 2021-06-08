INSERT IGNORE INTO users (id, username, password) VALUES ('1', 'user-1', '$2y$12$zKpA3uhnO4usvpKQQuLX/OQ4oSikwOAuq5IqOqlmwLBPUxJSmqIFS');
INSERT IGNORE INTO users (id, username, password) VALUES ('2', 'user-2', '$2y$12$U2tkVRD7kXvpU99V4Kr5Vu7lwv5JVyNB/a5Ftjs8CZFJJoXdpS6Uy');
INSERT IGNORE INTO users (id, username, password) VALUES ('3', 'user-3', '$2y$12$a95ZqV9QQx2R400RvAL9ee9yIO6s.2XC4dpzuWq1eB347//rXSwk2');

INSERT IGNORE INTO roles (user_id, name) VALUES ('1','ROLE_ADMIN');
INSERT IGNORE INTO roles (user_id, name) VALUES ('1', 'ROLE_CLIENT');
INSERT IGNORE INTO roles (user_id, name) VALUES ('2', 'ROLE_MANUFACTURER');
INSERT IGNORE INTO roles (user_id, name) VALUES ('3', 'ROLE_CLIENT');

INSERT IGNORE INTO addresses (id, street, city, country, phone_number) VALUES ('1','Vlad Tepes', 'Brasov', 'Romania', '0000');
INSERT IGNORE INTO addresses (id, street, city, country, phone_number) VALUES ('2', 'Calea Bucuresti' , 'Bucuresti', 'Romania', '0001');
INSERT IGNORE INTO addresses (id, street, city, country, phone_number) VALUES ('3', 'Ionel Fernic' , 'Targoviste', 'Romania', '0002');

INSERT IGNORE INTO orders (id, client_id, manufacturer_id, address_id, status) VALUES ('1', '3', '2', '2', 'NEW');
INSERT IGNORE INTO orders (id, client_id, manufacturer_id, address_id, status) VALUES ('2', '3', '2', '2', 'NEW');
INSERT IGNORE INTO orders (id, client_id, manufacturer_id, address_id, status) VALUES ('3', '1', '2', '1', 'NEW');

INSERT IGNORE INTO items (id, name) VALUES ('1', 'MERE');
INSERT IGNORE INTO items (id, name) VALUES ('2', 'PERE');
INSERT IGNORE INTO items (id, name) VALUES ('3', 'GUTUI');

INSERT IGNORE INTO orderitems (id, order_id, item_id, quantity) VALUES ('1', '1', '1', '10');
INSERT IGNORE INTO orderitems (id, order_id, item_id, quantity) VALUES ('2', '2', '1', '20');
INSERT IGNORE INTO orderitems (id, order_id, item_id, quantity) VALUES ('3', '2', '2', '15');
INSERT IGNORE INTO orderitems (id, order_id, item_id, quantity) VALUES ('4', '3', '3', '8');
INSERT IGNORE INTO orderitems (id, order_id, item_id, quantity) VALUES ('5', '1', '2', '5');