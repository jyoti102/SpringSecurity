DROP TABLE IF EXISTS User;

CREATE TABLE User (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

INSERT INTO User (username, password) VALUES
  ('jyoti@gmail.com', '123@asd'),
  ('jsingh@gmail.com', 'MTIzQGFzZA==');