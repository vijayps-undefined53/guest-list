
 CREATE TABLE IF NOT EXISTS guests (
   id INT AUTO_INCREMENT  PRIMARY KEY,
   name VARCHAR(250) NOT NULL,
   room INT NOT NULL,
   roomtype  VARCHAR(250) NOT NULL,
   address  VARCHAR(250) NOT NULL,
   email  VARCHAR(250) NOT NULL
 ) ;


INSERT INTO guests (name, room,roomtype,address,email) VALUES('test2', 100,'deluxe','ker','test2@gmail.com');

CREATE TABLE  IF NOT EXISTS user (
  id INT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);


INSERT INTO user (id,name, password) VALUES(4,'test2', 'password');
INSERT INTO user (id,name, password) VALUES(5,'test3', 'bill');
INSERT INTO user (id,name, password) VALUES(6,'test4', '102');

