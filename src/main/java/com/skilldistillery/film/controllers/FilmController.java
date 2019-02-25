package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.database.DatabaseAccessor;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessor dbAccessor;

	public DatabaseAccessor getDbAccessor() {
		return dbAccessor;
	}

	public void setDbAccessor(DatabaseAccessor dbAccessor) {
		this.dbAccessor = dbAccessor;
	}

	@RequestMapping(path = "FilmbyId.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView getFilmById(int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", dbAccessor.findFilmById(filmId));
		mv.setViewName("WEB-INF/result.jsp");

		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();
		boolean isFillmAddedSuccessful = dbAccessor.createFilm(film);

		if (!isFillmAddedSuccessful ) {
			mv.setViewName("WEB-INF/errorPage.jsp");
			return mv;
		}else {
			mv.setViewName("WEB-INF/result.jsp");
			return mv;
		}

	}

	@RequestMapping(path = "deleteFilm.do", params = "filmId", method = RequestMethod.POST)
	public ModelAndView deleteFilm(int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		boolean isSuccessful = dbAccessor.deleteFilm(filmId);
		mv.addObject("removed", isSuccessful);
		mv.setViewName("WEB-INF/result.jsp");
		if (!isSuccessful) {
			return null;
		}
		return mv;
	}

	@RequestMapping(path = "editFilm.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView editFilm(Film film, int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film filmObj = dbAccessor.findFilmById(filmId);
		System.out.println(filmObj);
		mv.addObject("film", filmObj);
		mv.setViewName("WEB-INF/editFilm.jsp");

		return mv;
	}
	
	@RequestMapping(path = "saveFilm.do", params = "filmId", method = RequestMethod.POST)
	public ModelAndView editFilm(Film film,int filmId,   RedirectAttributes redir) throws SQLException {
		ModelAndView mv = new ModelAndView();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"); // For testing
		
		boolean isSuccessful = dbAccessor.saveFilm(film, filmId);
		System.out.println(isSuccessful + "76");
		mv.addObject("isFilmUpdated", isSuccessful);
		mv.setViewName("WEB-INF/editFilmResult.jsp");

		return mv;

	}
	
	@RequestMapping(path = "searchFilmByKeyword.do", params = "keyWord", method = RequestMethod.GET)
	public ModelAndView findfilmByKeyword(String keyWord) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Film> filmList = dbAccessor.findfilmByKeyword(keyWord);
		System.out.println(filmList);
		mv.addObject("filmList", filmList);
		mv.setViewName("WEB-INF/result.jsp");

		return mv;

	}
	@RequestMapping(path = "addActor.do", method = RequestMethod.POST)
	public ModelAndView createActor(Actor actor) throws SQLException {
		ModelAndView mv = new ModelAndView();
		boolean isActormAddedSuccessful = dbAccessor.createActor(actor);
		
		if (!isActormAddedSuccessful) {
			mv.setViewName("");
			return mv;
		}else {
			mv.setViewName("");
			return mv;
		}
	
}
}
