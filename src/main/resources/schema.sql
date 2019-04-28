CREATE TABLE book
(
    id     long AUTO_INCREMENT PRIMARY KEY,
    title  varchar(255),
    author varchar(255),
    isbn   varchar(255)
);

INSERT INTO book (title, author, isbn)
VALUES ('Effective Java', 'Joshua Bloch', '978-0134685991');
INSERT INTO book (title, author, isbn)
VALUES ('Java 9 for Programmers', 'Harvey Deitel', '978-0134777566');
INSERT INTO book (title, author, isbn)
VALUES ('Core Java SE 9', 'Cay S. Horstmann', '978-0134694726');

CREATE TABLE comment
(
    id           long AUTO_INCREMENT PRIMARY KEY,
    date         timestamp,
    comment_text varchar(255),
    book_id      long
);

ALTER TABLE comment
    ADD FOREIGN KEY (book_id)
        REFERENCES book (id);