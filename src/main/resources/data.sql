INSERT INTO book (id, title, author, isbn)
VALUES (1001, 'Effective Java', 'Joshua Bloch', '978-0134685991');
INSERT INTO book (id, title, author, isbn)
VALUES (1002, 'Java 9 for Programmers', 'Harvey Deitel', '978-0134777566');
INSERT INTO book (id, title, author, isbn)
VALUES (1003, 'Core Java SE 9', 'Cay S. Horstmann', '978-0134694726');

INSERT INTO comment (id, comment_text, date, book_id)
VALUES (2001, 'comment 1 to book 1', '2020-05-06 18:53:05.066', 1001);
INSERT INTO comment (id, comment_text, date, book_id)
VALUES (2002, 'comment 2 to book 1', '2020-05-07 9:12:37.777', 1001);
INSERT INTO comment (id, comment_text, date, book_id)
VALUES (2003, 'comment 1 to book 2', '2020-05-08 11:22:45.234', 1002);