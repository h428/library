drop table if exists admin;
CREATE TABLE admin
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(256) NOT NULL,
	salt       VARCHAR(256) NOT NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

drop table if exists reader;
CREATE TABLE reader
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    username       VARCHAR(255) NOT NULL UNIQUE,
    password       VARCHAR(255) NOT NULL,
    email          VARCHAR(255) UNIQUE,
    max_borrow_num TINYINT      NOT NULL DEFAULT 10,
    create_time     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    update_time     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

drop table if exists category;
CREATE TABLE category
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    parent_id   INT       DEFAULT NULL,
    description TEXT,
    create_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

drop table if exists book;
CREATE TABLE book
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    author           VARCHAR(255),
    publisher        VARCHAR(255),
    publication_date DATE,
    ISBN             VARCHAR(13) UNIQUE,
    summary          TEXT,
    create_time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    category_id      INT NOT NULL
);

drop table if exists borrow;
CREATE TABLE borrow
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    reader_id     INT,
    book_id     INT,
    borrow_date DATE NOT NULL,
    due_date    DATE NOT NULL,
    return_date DATE
);