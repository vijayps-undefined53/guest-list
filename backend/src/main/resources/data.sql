
 CREATE TABLE IF NOT EXISTS guests (
   id INT AUTO_INCREMENT  PRIMARY KEY,
   name VARCHAR(250) NOT NULL,
   room INT NOT NULL,
   roomtype  VARCHAR(250) NOT NULL,
   address  VARCHAR(250) NOT NULL,
   email  VARCHAR(250) NOT NULL
 ) ;


INSERT INTO guests (name, room,roomtype,address,email) VALUES('vijay', 100,'deluxe','ker','c@gmail.com');

CREATE TABLE user (
  id INT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);


INSERT INTO user (id,name, password) VALUES(1,'vijay', 'password');
INSERT INTO user (id,name, password) VALUES(2,'bill', 'bill');
INSERT INTO user (id,name, password) VALUES(3,'three', '102');

