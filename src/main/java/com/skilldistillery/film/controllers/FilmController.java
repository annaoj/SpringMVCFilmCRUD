package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String createFilm(Film film, RedirectAttributes redir) throws SQLException {
		dbAccessor.createFilm(film);
		redir.addFlashAttribute("film", film);

		return "redirect:filmCreated.do";
	}

	@RequestMapping("filmCreated.do")
	public ModelAndView filmCreated() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/result.jsp");
		return mv;

	}
//	@RequestMapping(path = "FilmbyId.do", params = "filmId", method = RequestMethod.GET)
//	public ModelAndView getFilmById(@Valid int filmId, Errors errors) throws SQLException {
//		ModelAndView mv = new ModelAndView();
//		Film filmResponse = dbAccessor.findFilmById(filmId);
//		if (filmResponse == null) {
//			errors.rejectValue("filmId", "error.filmId", "Film Id not found");
//
//		} else {
//			mv.addObject("film", dbAccessor.findFilmById(filmId));
//			mv.setViewName("WEB-INF/result.jsp");
//
//		}
//		return mv;
//	}

}
