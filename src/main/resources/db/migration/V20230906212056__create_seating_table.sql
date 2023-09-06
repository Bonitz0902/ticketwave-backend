CREATE TABLE seating (
    seating_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    schedule_id BIGINT NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    is_available BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (schedule_id) REFERENCES movie_schedule (schedule_id)
);