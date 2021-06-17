CREATE DATABASE bank;

CREATE TABLE IF NOT EXISTS bank.bankAccount (
    id MEDIUMINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(60) NOT NULL,
    agency_number INT NOT NULL,
    agency_code INT NOT NULL,
    account INT NOT NULL,
    balance DOUBLE
) ENGINE=INNODB