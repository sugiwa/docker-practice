-- テーブル作成
CREATE TABLE users (
    id SERIAL NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY(id)
);

-- サンプルレコード作成
INSERT INTO users (name, email, password) VALUES('jiro', 'a@ahgdy', 'dg3th');
INSERT INTO users (name, email, password) VALUES('yama', 'alk@b.com', 'hfsar');
INSERT INTO users (name, email, password) VALUES('satou', 'r@dag.com', 'aaasdg');
INSERT INTO users (name, email, password) VALUES('souta', 'rdsa@c', 'sgagredg');
INSERT INTO users (name, email, password) VALUES('osdh', 'asgasd@example.com', 'paordgdh');
INSERT INTO users (name, email, password) VALUES('rhsosgoi', 'bbb@example.com', 'wsswoghfh');