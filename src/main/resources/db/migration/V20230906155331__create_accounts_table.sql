CREATE TABLE accounts (
    account_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_name VARCHAR(255) NOT NULL,
    account_email VARCHAR(255) NOT NULL,
    account_password VARCHAR(255) NOT NULL
);
