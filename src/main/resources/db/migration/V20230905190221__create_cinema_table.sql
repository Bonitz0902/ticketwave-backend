CREATE TABLE cinemas (
    cinema_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    location_id BIGINT NOT NULL,
    movie_id BIGINT NOT NULL,
    cinema_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (location_id) REFERENCES locations (location_id),
    FOREIGN KEY (movie_id) REFERENCES movies (id)
);
