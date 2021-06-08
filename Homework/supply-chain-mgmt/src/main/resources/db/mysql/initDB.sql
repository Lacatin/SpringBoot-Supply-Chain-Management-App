-- CREATE DATABASE IF NOT EXISTS supplychain;
--
-- ALTER DATABASE supplychain
--   DEFAULT CHARACTER SET utf8
--   DEFAULT COLLATE utf8_general_ci;
--
-- GRANT ALL PRIVILEGES ON supplychain.* TO 'supplychain'@'localhost' IDENTIFIED BY 'supplychain';
--
-- USE supplychain;

DROP TABLE IF EXISTS orderitems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS items;



CREATE TABLE IF NOT EXISTS addresses (
      id            int(11)         NOT NULL AUTO_INCREMENT,
      street        VARCHAR(50)     NOT NULL,
      city          VARCHAR(50)     NOT NULL,
      country       VARCHAR(50)     NOT NULL,
      phone_number  VARCHAR(50)     NOT NULL,
      PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS users (
      id int(11) NOT NULL AUTO_INCREMENT,
      username  VARCHAR(50)  NOT NULL,
      password  VARCHAR(100) NOT NULL,
      PRIMARY KEY (id)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS roles (
      id int(11)        NOT NULL AUTO_INCREMENT,
      user_id int(11)   NOT NULL,
      name varchar(20)  NOT NULL,
      PRIMARY KEY (id),
      CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS orders (
    id              int(11)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id       int(11)      NOT NULL,
    manufacturer_id int(11)      NOT NULL,
    address_id      int(11)      NOT NULL,
    status          varchar(20)  NOT NULL,
    CONSTRAINT fk_client_id       FOREIGN KEY (client_id)         REFERENCES users      (id) ON DELETE CASCADE,
    CONSTRAINT fk_manufacturer_id FOREIGN KEY (manufacturer_id)   REFERENCES users      (id),
    CONSTRAINT fk_address_id       FOREIGN KEY (address_id)       REFERENCES addresses  (id)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS items (
    id              int(11)         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name         varchar(20)        NOT NULL
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS orderitems (
    id              int(11)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id        int(11)      NOT NULL,
    item_id         int(11)      NOT NULL,
    quantity        int(11)      NOT NULL,
    CONSTRAINT fk_order_id       FOREIGN KEY (order_id)         REFERENCES orders     (id) ON DELETE CASCADE,
    CONSTRAINT fk_item_id        FOREIGN KEY (item_id )         REFERENCES items      (id)
    ) engine=InnoDB;

