import com.afs.restapi.entity.Cinema;
import com.afs.restapi.entity.Location;
import com.afs.restapi.entity.Movie;
import com.afs.restapi.mappers.cinema.CinemaMapper;
import com.afs.restapi.mappers.cinema.CinemaResponse;
import com.afs.restapi.repository.CinemaRepository;
import com.afs.restapi.repository.LocationRepository;
import com.afs.restapi.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CinemaServiceTest {

    @Mock
    private CinemaRepository cinemaRepository;

    @Mock
    private CinemaMapper cinemaMapper;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private MovieRepository movieRepository;

    private CinemaService cinemaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cinemaService = new CinemaService(cinemaRepository, cinemaMapper, locationRepository, movieRepository);
    }

    @Test
    void should_get_cinemas_by_location_and_movie() {
        // Arrange
        Long locationId = 1L;
        Long movieId = 2L;
        List<Cinema> cinemas = new ArrayList<>();
        Cinema cinema1 = new Cinema(1L, new Location(locationId, "Location A"), new Movie(movieId, "Movie X",true,"wqery","qwrqwfas",4.9,"wdwsadas","wdqdas","dqadasdas", new BigDecimal(400.99)), "ciname1");
        cinemas.add(cinema1);
        when(cinemaRepository.findAllByLocationLocationIdAndMovieId(locationId, movieId)).thenReturn(cinemas);

        CinemaResponse cinemaResponse1 = new CinemaResponse();
        cinemaResponse1.setCinemaId(1L);
        cinemaResponse1.setLocationName("Location A");
        cinemaResponse1.setMovieTitle("Movie X");
        when(cinemaMapper.toResponse(cinema1)).thenReturn(cinemaResponse1);

        // Act
        List<CinemaResponse> result = cinemaService.getCinemasByLocationAndMovie(locationId, movieId);

        // Assert
        assertEquals(1, result.size());
        CinemaResponse response = result.get(0);
        assertEquals(1L, response.getCinemaId());
        assertEquals("Location A", response.getLocationName());
        assertEquals("Movie X", response.getMovieTitle());
    }

    @Test
    void should_get_all_cinemas() {
        // Arrange
        List<Cinema> cinemas = new ArrayList<>();
        Cinema cinema1 = new Cinema(1L, new Location(1L, "Location A"), new Movie(2L, "Movie X"));
        Cinema cinema2 = new Cinema(3L, new Location(4L, "Location B"), new Movie(5L, "Movie Y"));
        cinemas.add(cinema1);
        cinemas.add(cinema2);
        when(cinemaRepository.findAll()).thenReturn(cinemas);

        CinemaResponse cinemaResponse1 = new CinemaResponse();
        cinemaResponse1.setCinemaId(1L);
        cinemaResponse1.setLocationName("Location A");
        cinemaResponse1.setMovieTitle("Movie X");

        CinemaResponse cinemaResponse2 = new CinemaResponse();
        cinemaResponse2.setCinemaId(3L);
        cinemaResponse2.setLocationName("Location B");
        cinemaResponse2.setMovieTitle("Movie Y");

        when(cinemaMapper.toResponse(cinema1)).thenReturn(cinemaResponse1);
        when(cinemaMapper.toResponse(cinema2)).thenReturn(cinemaResponse2);

        // Act
        List<CinemaResponse> result = cinemaService.getAllCinemas();

        // Assert
        assertEquals(2, result.size());
        CinemaResponse response1 = result.get(0);
        CinemaResponse response2 = result.get(1);

        assertEquals(1L, response1.getCinemaId());
        assertEquals("Location A", response1.getLocationName());
        assertEquals("Movie X", response1.getMovieTitle());

        assertEquals(3L, response2.getCinemaId());
        assertEquals("Location B", response2.getLocationName());
        assertEquals("Movie Y", response2.getMovieTitle());
    }
}
