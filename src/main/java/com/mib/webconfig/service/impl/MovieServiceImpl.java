package com.mib.webconfig.service.impl;

import com.mib.webconfig.entity.Jurusan;
import com.mib.webconfig.entity.Movie;
import com.mib.webconfig.repository.MovieRepository;
import com.mib.webconfig.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> showAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie create(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public Movie update(String kodeMovie, Movie movie) {
        Movie savedMovie = movieRepository.findBykodeMovie(kodeMovie);
        savedMovie.setNamaFilm(movie.getNamaFilm());
        movieRepository.save(savedMovie);
        return savedMovie;
    }

    @Override
    public void delete(String kodeMovie) {
        Movie movie = movieRepository.findBykodeMovie(kodeMovie);
        movieRepository.deleteById(movie.getId());
    }

    @Override
    public Movie findByKodeMovie(String kodeMovie) {
        Movie movie = movieRepository.findBykodeMovie(kodeMovie);
        return movie;
    }

//    public List<Movie> getByKeyword(String keyword) {
//        return movieRepository.findByKeyword(keyword);
//    }


}
