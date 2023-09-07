CREATE TABLE booking_receipt (
    booking_id SERIAL PRIMARY KEY,
    account_id BIGINT NOT NULL,
    cinema_id BIGINT NOT NULL,
    movie_id BIGINT NOT NULL,
    schedule_id BIGINT NOT NULL,
    seating_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts (account_id),
    FOREIGN KEY (cinema_id) REFERENCES cinemas (cinema_id),
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (schedule_id) REFERENCES movie_schedule (schedule_id),
    FOREIGN KEY (seating_id) REFERENCES seating (seating_id)
);