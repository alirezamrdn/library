DROP TABLE IF EXISTS tbl_book;
DROP TABLE IF EXISTS tbl_borrow;
DROP TABLE IF EXISTS tbl_user;
DROP TABLE IF EXISTS tbl_membership;
DROP TABLE IF EXISTS tbl_book_publisher;
DROP TABLE IF EXISTS tbl_book_genre;
DROP TABLE IF EXISTS tbl_book_author;

CREATE TABLE IF NOT EXISTS tbl_user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  gender INT NOT NULL
);

CREATE TABLE IF NOT EXISTS tbl_membership (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  membership_from DATETIME NOT NULL,
  membership_to DATETIME NULL
);

CREATE TABLE IF NOT EXISTS tbl_book_publisher (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS tbl_book_genre (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS tbl_book_author (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS tbl_book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  publisher_id INT NOT NULL,
  genre_id INT NOT NULL,
  author_id INT NOT NULL,
  name VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS tbl_borrow (
  id INT AUTO_INCREMENT PRIMARY KEY,
  borrower_id INT NOT NULL,
  book_id INT NOT NULL,
  borrow_from DATETIME NOT NULL,
  borrow_to DATETIME NOT NULL
);