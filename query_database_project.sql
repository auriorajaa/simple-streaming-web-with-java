-- Drop tables if they exist
DROP TABLE IF EXISTS tbl_subs;
DROP TABLE IF EXISTS tbl_movies;
DROP TABLE IF EXISTS tbl_users;

-- Create database moviex_db if it doesn't exist
CREATE DATABASE IF NOT EXISTS moviex_db;

-- Use database moviex_db
USE moviex_db;

-- Create table tbl_users
CREATE TABLE IF NOT EXISTS tbl_users (
    email VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

-- Create table tbl_subs
CREATE TABLE IF NOT EXISTS tbl_subs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_email VARCHAR(255),
    type_subs VARCHAR(10),
    FOREIGN KEY (user_email) REFERENCES tbl_users (email)
);

-- Create table tbl_movies
CREATE TABLE IF NOT EXISTS tbl_movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    movie_title VARCHAR(255),
    movie_genre VARCHAR(50),
    movie_year CHAR(4),
    image VARCHAR(150),
    url_youtube VARCHAR(255)
);
