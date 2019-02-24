package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.database.DatabaseAccessor;
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
	public String createFilm(Film film) throws SQLException {
		dbAccessor.createFilm(film);

		return "WEB-INF/result.jsp";
	}

	@RequestMapping(path = "deleteFilm.do", params = "filmId", method = RequestMethod.POST)
	public ModelAndView deleteFilm(int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		boolean isSuccessful = dbAccessor.deleteFilm(filmId);
		mv.addObject("removed", isSuccessful);
		mv.setViewName("WEB-INF/result.jsp");
		System.out.println(isSuccessful + "resssssssssssssss");
		if (!isSuccessful) {
			System.out.println(isSuccessful + "53resssssssssssssss");

			return null;
		}
		return mv;
	}

	@RequestMapping(path = "editFilm.do", method = RequestMethod.POST)
	public ModelAndView editFilm(Film film) throws SQLException {
		ModelAndView mv = new ModelAndView();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"); // For testing
		System.out.println(film);
		mv.addObject("film", dbAccessor.saveFilm(film));
		mv.setViewName("WEB-INF/result.jsp");

		return mv;

	}
}
