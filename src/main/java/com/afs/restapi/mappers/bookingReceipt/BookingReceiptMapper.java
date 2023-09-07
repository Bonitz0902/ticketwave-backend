package com.afs.restapi.mappers.bookingReceipt;

import com.afs.restapi.entity.Account;
import com.afs.restapi.entity.BookingReceipt;
import com.afs.restapi.entity.Cinema;
import com.afs.restapi.entity.Movie;
import com.afs.restapi.repository.AccountRepository;
import com.afs.restapi.repository.CinemaRepository;
import com.afs.restapi.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingReceiptMapper {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    public BookingReceiptMapper(){

    }

    public BookingReceiptResponse toResponse(BookingReceipt bookingReceipt){
        BookingReceiptResponse bookingReceiptResponse = new BookingReceiptResponse();
        Account account = accountRepository.findByAccountId(bookingReceipt.getAccountId());
        Optional<Movie> movie = movieRepository.findById(bookingReceipt.getMovieId());
        Optional<Cinema> cinema = cinemaRepository.findById(bookingReceipt.getCinemaId());

        bookingReceiptResponse.setAccountName(account.getAccountName());
        bookingReceiptResponse.setMovieName(movie.get().getMovieTitle());
        bookingReceiptResponse.setCinemaName(cinema.get().getCinemaName());

        BeanUtils.copyProperties(bookingReceipt, bookingReceiptResponse);
        return bookingReceiptResponse;

    }
}
