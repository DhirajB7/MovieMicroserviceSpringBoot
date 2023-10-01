CREATE TABLE IF NOT EXISTS ratings (
    movie_id VARCHAR(255) NOT NULL,
    rating INT NOT NULL,
    CONSTRAINT ratings_pkey PRIMARY KEY (movie_id)
);