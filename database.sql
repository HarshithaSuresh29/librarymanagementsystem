-- Create database
CREATE DATABASE lms_db;
USE lms_db;

-- Users table (vulnerable: plaintext passwords + role manipulation possible)
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100),
    role VARCHAR(20)
);

-- Books table (vulnerable to SQLi + XSS)
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(255),
    author VARCHAR(255)
);

-- Default admin user (vulnerable credentials)
INSERT INTO users (username, password, role)
VALUES ('admin', 'admin123', 'admin');

-- Normal user
INSERT INTO users (username, password, role)
VALUES ('user1', 'user123', 'user');

-- Sample book
INSERT INTO books (book_name, author)
VALUES ('Java Basics', 'James');
