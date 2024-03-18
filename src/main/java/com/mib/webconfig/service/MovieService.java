package com.mib.webconfig.service;

import com.mib.webconfig.entity.Jurusan;
import com.mib.webconfig.entity.Movie;

import java.util.List;

public interface MovieService {
//    static List<Movie> getByKeyword(String keyword) {
//    }
//    static List<Movie> getByKeyword(String keyword) {
//    }

    List<Movie> showAll();

    Movie create(Movie movie);

    Movie update(String kodeMovie, Movie movie);

    void delete(String KodeMovie);

    Movie findByKodeMovie(String kodeMovie);

//    List<Movie> getByKeyword(String keyword);



}
