package com.mib.webconfig.repository;

import com.mib.webconfig.entity.Jurusan;
import com.mib.webconfig.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findBykodeMovie(String kodeMovie);

//    @Query(value = "SELECT * FROM movie s WHERE s.kodeMovie LIKE %:keyword% OR s. LIKE %:keyword%",
//            nativeQuery = true)
//
////    List<Movie> findByKeyword(String keyword);
//    List<Movie> findByKeyword(@Param("keyword") String keyword);
}
