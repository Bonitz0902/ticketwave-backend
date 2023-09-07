CREATE TABLE movie_schedule (
    schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cinema_id BIGINT NOT NULL,
    schedule_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    FOREIGN KEY (cinema_id) REFERENCES cinemas (cinema_id)
);
