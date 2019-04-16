CREATE TABLE book
(
    id      long         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title   varchar(255) NOT NULL,
    author  varchar(255) NOT NULL,
    ISBN_13 varchar(255) NOT NULL,
);

INSERT INTO book (title, author, ISBN_13)
VALUES ('Effective Java', 'Joshua Bloch', '978-0134685991');
INSERT INTO book (title, author, ISBN_13)
VALUES ('Java 9 for Programmers', 'Harvey Deitel', '978-0134777566');
INSERT INTO book (title, author, ISBN_13)
VALUES ('Core Java SE 9', 'Cay S. Horstmann', '978-0134694726');
