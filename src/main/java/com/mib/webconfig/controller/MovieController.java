package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Movie;
import com.mib.webconfig.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;


    @RequestMapping(value = "/movie/create", method = RequestMethod.GET)
    public String showCreateForm(){
        return "movie/add-movie";
    }
    public String showSearchForm() {
        return "movie/search-movie";
    }

    @RequestMapping(value = "/movie/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String,String> data) throws URISyntaxException {
        ModelAndView modelAndView = new ModelAndView();
        Movie movie = new Movie();
        movie.setKodeMovie(data.get("kodeMovie"));
        movie.setNamaFilm(data.get("namaFilm"));
        movieService.create(movie);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("movie/add-movie");
        return modelAndView;
    }

    @RequestMapping(value = "/movie/list", method = RequestMethod.GET)
    public ModelAndView movieList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Movie> movieList = movieService.showAll();
        modelAndView.addObject("movieList", movieList);
        modelAndView.setViewName("movie/list-movie");
        return modelAndView;
    }

    @RequestMapping(value="/movie/edit/{kodeMovie}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("kodeMovie") String kodeMovie){
        ModelAndView modelAndView = new ModelAndView();
        Movie movie = movieService.findByKodeMovie(kodeMovie);
        modelAndView.addObject("movie", movie);
        modelAndView.setViewName("movie/edit-movie");
        return modelAndView;
    }

    @RequestMapping(value = "/movie/edit/{kodeMovie}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("kodeMovie") String kodeMovie, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        Movie movie = new Movie();
        movie.setKodeMovie(kodeMovie);
        movie.setNamaFilm(data.get("namaFilm"));
        movieService.update(kodeMovie,movie);
        modelAndView.setViewName("redirect:/movie/list");
        return modelAndView;
    }

    @RequestMapping(value = "/movie/delete/{kodeMovie}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("kodeMovie") String kodeMovie){
        ModelAndView modelAndView = new ModelAndView();
        movieService.delete(kodeMovie);
        modelAndView.setViewName("redirect:/movie/list");
        return modelAndView;
    }



//    @RequestMapping(path = {"/", "/search"})
//    public String modelAndView(Movie movie, Model model, @RequestParam(required = false) String keyword) {
//        if (keyword != null && !keyword.isEmpty()) {
//            List<Movie> list = MovieService.getByKeyword(keyword);
//            model.addAttribute("movieList", list); // Mengubah "list" menjadi "movieList"
//        } else {
//            List<Movie> list = movieService.getAllMovies();
//            model.addAttribute("movieList", list); // Mengubah "list" menjadi "movieList"
//        }
//        return "movie/list-movie";
//    }

//    @GetMapping("/movie/search")
//    public String searchMovies(@RequestParam(required = false) String keyword, Model model) {
//        List<Movie> movieList;
//        if (keyword != null && !keyword.isEmpty()) {
//            movieList = movieService.getByKeyword(keyword);
//        } else {
//            movieList = movieService.showAll();
//        }
//            model.addAttribute("movieList", movieList);
//            return "movie/list-movie";
//    }
    

}
