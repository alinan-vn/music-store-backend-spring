
INSERT INTO  category(id, category_name) VALUES (1,'djgear');
INSERT INTO  category(id, category_name) VALUES (2,'instruments');
INSERT INTO  category(id, category_name) VALUES (3,'albums');
INSERT INTO  category(id, category_name) VALUES (4,'lifestyle');
INSERT INTO  category(id, category_name) VALUES (5,'accessories');
INSERT INTO  category(id, category_name) VALUES (6,'audio');





INSERT INTO product(id,product_name,description,price) VALUES(2,'Guitar','Guitar made by music INC','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(3,'Drums','Drum set','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(4,'Flute','A flute to make music','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(1,'Cello','a really nice sounding cello','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(5,'Thank me Later','Album by Drake','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(6,'Thriller','Album by Michael Jackson','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(7,'Suga','Album by Meg Thee Stallion','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(8,'T-Shirt','T Shirt with music design','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(9,'Braclet','Music braclet','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(10,'Key-Chain','Keychain with music emblem','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(11,'Beats Solo','Beats by Dre from Apple','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(12,'Sony XM4','Sony over the ear headphones','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(13,'Airpods','Flex on em','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(14,'9mm Audio cable','Cable to plug things in','1000.99');
INSERT INTO product(id,product_name,description,price) VALUES(15,'Turntables','Just buy a Macbook','1000.99');

INSERT INTO  genre(id, genre_name) VALUES (1,'hiphop');
INSERT INTO  genre(id, genre_name) VALUES (2,'pop');
INSERT INTO  genre(id, genre_name) VALUES (3,'rb');
INSERT INTO  genre(id, genre_name) VALUES (4,'rock');
INSERT INTO  genre(id, genre_name) VALUES (5,'country');
INSERT INTO  genre(id, genre_name) VALUES (6,'techno');


INSERT INTO album(id, album_name) VALUES (1,'Thriller');
INSERT INTO album(id, album_name) VALUES (2,'SUGA');
INSERT INTO album(id, album_name) VALUES (3,'Fearless');
INSERT INTO album(id, album_name) VALUES (4,'Random Access Memories');
INSERT INTO album(id, album_name) VALUES (5,'Chilombo');
INSERT INTO album(id, album_name) VALUES (6,'Blame it on Baby');
INSERT INTO album(id, album_name) VALUES (7,'DAMN');
INSERT INTO album(id, album_name) VALUES (8,'The Dark Side of the Moon');
INSERT INTO album(id, album_name) VALUES (9,'Nevermind');

INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(1,'Micheal Jackson','1.99','Thriller',2,1);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(2,'Micheal Jackson','1.99','The girl is mine',2,1);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(3,'Meg Thee Stallion','1.99','Savage',1,1);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(4,'Meg Thee Stallion','1.99','What I need',1,1);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(5,'Taylor Swift','1.99','Hey Stephen',5,3);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(6,'Taylor Swift','1.99','Hey Stephen',5,3);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(7,'Daft Punk','1.99','Give Life Back to Music',6,4);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(8,'Daft Punk','1.99','Giorgio by Moroder',6,4);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(9,'Jhene Aiko','1.99','Triggered',3,5);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(10,'Jhene Aiko','1.99','Happiness Over Everything',3,5);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(11,'DaBaby','1.99','CANT STOP',1,6);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(12,'DaBaby','1.99','BLAME IT ON BABY',1,6);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(13,'Kendrick Lamar','1.99','DNA',1,7);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(14,'Kendrick Lamar','1.99','Duckworth',1,7);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(15,'Pink Floyd','1.99','Speak to Me / Breath',4,8);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(16,'Pink Floyd','1.99','Time',4,8);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(17,'Nirvana','1.99','Smells Like Teen Spirit',4,9);
INSERT INTO song(id,artist,price,song_name,genre_id,album_id) VALUES(18,'Nirvana','1.99','Come as you are',4,9);

INSERT INTO customer(id, customer_name, email, password, phone, role, username) VALUES (1,'Christopher Fulton','email@email.com','password','123-456-789','user','user');
INSERT INTO shopping_cart(id, customer_id) VALUES (1,1);