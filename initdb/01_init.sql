-- DB作成
CREATE DATABASE db;

-- 作成したDBへ切り替え
\c db

-- スキーマ作成
CREATE SCHEMA myschema;

-- ロールの作成
CREATE ROLE hoge WITH LOGIN PASSWORD 'root';

-- 権限追加
GRANT ALL PRIVILEGES ON SCHEMA myschema TO hoge;