
INSERT INTO `books_counter`.`book`
(`title`, `publish_year`, `author`)
VALUES
('The Kite Runner', 2003, 'Khaled Hosseini'),
('Mrs. Dalloway', 1925, 'Virginia Woolf'),
('Insurgent', 2012, 'Veronica Roth'),
('A Christmas Carol', 1843, 'Charles Dickens'),
('Paper Towns', 2008, 'John Green'),
('The Da Vinci Code', 2003, 'Dan Brown'),
('Dracula', 1897, 'Bram Stoker'),
('Twilight', 2005, 'Stephenie Meyer'),
('Alice in Wonderland', 1865, 'Jane Carruth'),
('The Book Thief', 2005, 'Markus Zusak'),
('The Fellowship of the Ring', 1954, 'J.R.R. Tolkien'),
('Of Mice and Men', 1937, 'John Steinbeck'),
('A Tale of Two Cities', 1859, 'Charles Dickens'),
('Emma', 1815, 'Jane Austen'),
('Fahrenheit 451', 1953, 'Ray Bradbury'),
('A Clash of Kings', 1998, 'George R.R. Martin'),
('Looking for Alaska', 2005, 'John Green'),
('In The Mignight Hour', 2006, 'Reggie Ridgway'),
('Crochet Shawls', 1995, 'Wilma Green'),
('Evol', 1998, 'Jess Wygle'),
('New Life', 2004, 'Mia Owen'),
('A cute love story', 2006, 'Jess Wygle'),
('Nidhi Agrawal', 1998, 'Nidhi Agrawal'),
('Ultimate Pleasure', 2008, 'Rachel G'),
('A Howl In The Night', 2000, 'Lorelei Sutton');


INSERT INTO `books_counter`.`book`
(`title`,`publish_year`,`author`)
VALUES
('Java in action',2013,'Craig Walls'),
('Harry Potter and the Sorcerer Stone', 1997,'Joanne Rowling'),
('Animal Farm', 1945,'George Orwell'),
('Pride and Prejudice', 1813,'Jane Ostin'),
('Harry Potter and the Chamber of Secrets', 1998,'Joanne Rowling'),
('Harry Potter and the Deathly Hallows', 2007,'Joanne Rowling'),
('Harry Potter and the Prisoner of Azkaban', 1999,'Joanne Rowling'),
('Harry Potter and the Half-Blood Prince', 2005,'Joanne Rowling'),
('Harry Potter and the Goblet of Fire', 2000,'Joanne Rowling'),
('To Kill a Mockingbird', 1960,'Harper Lee'),
('The Great Gatsby', 1925,'Scott Fitzgerald'),
('The Fault in Our Stars', 2012,'John Green'),
('The Hunger Games', 2008,'Suzanne Collins'),
('The Picture of Dorian Gray', 1890,'Oscar Wilde'),
('Wuthering Heights', 1847,'Emily Bronte'),
('Brave New World', 1932,'Aldous Huxley'),
('Lord of the Flies', 1954,'William Golding'),
('Romeo and Juliet', 1595,'William Shakespeare'),
('Hamlet', 1600,' William Shakespeare'),
('The Hunger Games: Catching Fire', 2009,'Suzanne Collins'),
('The Hunger Games: Mockingjay', 2010,'Suzanne Collins'),
('The Perks of Being A Wallflower', 1999,'Stephen Chbosky'),
('Macbeth', 1606,'William Shakespeare'),
('Harry Potter and the Cursed Child', 2016,'John Tiffany'),
('Divergent', 2011,' Veronica Roth'),
('Java in action 3-d edition',2013,'Craig Walls'),
('Java in action 4-th edition',2015,'Craig Walls');




INSERT INTO `books_counter`.`employee`
(`name`,`date_of_birth`,`email`)
VALUES
('Igor Boroda','1967-03-30','igor_boroda@gmail.com'),
('Lieka Smith','1995-06-10','like@gmail.com'),
('Veronica Green','1978-03-23','v_green@gmail.com'),
('Sergei Suzdal','1973-01-01','suzdal@mail.ru'),
('Mariya Pashkevich','1996-08-27','pashkevich@mail.ru'),
('Vladimir Lukush','1987-03-10','lukush@gmail.com'),
('Michail Nalibok','1986-12-09','nolibok@yandex.ru'),
('Andrey Klimov','1996-12-19','klimov@yandex.ru'),
('Arseni Vorgan','1993-08-23','vorgan@gmail.com'),
('Track Sao','1987-08-23','cao@gmail.com'),
('Kim Sao','1987-04-23','kim@gmail.com'),
('Oleg Popko','1997-02-23','popko@gmail.com'),
('Irina Petrova','1993-04-21','irina@gmail.com');


INSERT INTO `books_counter`.`employee_book`
(`book_id`,
`employee_id`,
`id`)
VALUES
(2, 2, 1),
(7, 2, 2),
(9, 2, 3),
(13, 2, 4),
(20, 12, 5);



