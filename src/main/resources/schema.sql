DROP TABLE IF EXISTS satellites;

CREATE TABLE satellites (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250),
  pos_x DOUBLE,
  pos_y DOUBLE,
  distance DOUBLE,
  message VARCHAR(250)
);

INSERT INTO SATELLITES (name, pos_x, pos_y, distance) VALUES ('Kenobi', -500, -200, 0);
INSERT INTO SATELLITES (name, pos_x, pos_y, distance) VALUES ('Skywalker', 100, -100, 0);
INSERT INTO SATELLITES (name, pos_x, pos_y, distance) VALUES ('Sato', 500, 100, 0);