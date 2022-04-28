-- DB切り替え
\c db

-- テーブル作成
CREATE TABLE myschema.users (
    id SERIAL NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY(id)
);

-- 権限追加
GRANT ALL PRIVILEGES ON myschema.users TO hoge;
GRANT ALL PRIVILEGES ON myschema.users_id_seq TO hoge;

-- サンプルレコード作成
INSERT INTO myschema.users (name, email, password) VALUES('jiro', 'a@ahgy', 'dg3th');
INSERT INTO myschema.users (name, email, password) VALUES('yamada', 'alk@b', 'hfsar');
INSERT INTO myschema.users (name, email, password) VALUES('satou', 'r@c', 'aaasdg');
INSERT INTO myschema.users (name, email, password) VALUES('sou', 'rdsa@c', 'sgagredg');
INSERT INTO myschema.users (name, email, password) VALUES('osoiudh', 'asgasd@example.com', 'pafhordgdh');
INSERT INTO myschema.users (name, email, password) VALUES('rhsosgoi', 'bbb@example.com', 'passwoghfh');