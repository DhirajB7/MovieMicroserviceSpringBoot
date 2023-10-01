CREATE TABLE IF NOT EXISTS users (
    user_id VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age integer NOT NULL,
    phone bigint NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);