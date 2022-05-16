CREATE TABLE schedules(
    id SERIAL NOT NULL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id),
    title VARCHAR(255) NOT NULL,
    content TEXT,
    started_at TIMESTAMP,
    finished_at TIMESTAMP
)