CREATE TABLE IF NOT EXISTS movies (
    movie_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    CONSTRAINT movies_pkey PRIMARY KEY (movie_id)
);