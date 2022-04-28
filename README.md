# Docker Practice

## Docker

コンテナに入る
- docker-compose up -d
- docker exec -ti <CONTAINER_ID> /bin/bash

コンテナ停止
- docker-compose down

ボリューム削除
- docker volume rm <CONTAINER_ID>


## PostgresSQL

接続
- psql -h localhost -U <NAME> -d <DB>