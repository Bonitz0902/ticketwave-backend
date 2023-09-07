CREATE TABLE movies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_title VARCHAR(255) NOT NULL,
    is_available BOOLEAN NOT NULL DEFAULT TRUE,
    image_url VARCHAR(255),
    description VARCHAR(1000),
    rating FLOAT(9),
    director VARCHAR(255),
    genre VARCHAR(255),
    image_url_landscape VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL
);
