-- テーブル作成
CREATE TABLE users (
    id SERIAL NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY(id)
);

-- サンプルレコード作成
INSERT INTO users (name, email, password) VALUES('jiro', 'a@ahgy', 'dg3th');
INSERT INTO users (name, email, password) VALUES('yamada', 'alk@b', 'hfsar');
INSERT INTO users (name, email, password) VALUES('satou', 'r@c', 'aaasdg');
INSERT INTO users (name, email, password) VALUES('sou', 'rdsa@c', 'sgagredg');
INSERT INTO users (name, email, password) VALUES('osoiudh', 'asgasd@example.com', 'pafhordgdh');
INSERT INTO users (name, email, password) VALUES('rhsosgoi', 'bbb@example.com', 'passwoghfh');
