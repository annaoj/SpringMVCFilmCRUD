package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
//	@RequestMapping(path="addFilm.do", method=RequestMethod.POST)
//	public String createFilm(Film film) {
//		System.out.println("*************************************");
//		System.out.println(film);
////		Film filmObj;
//		try {
//			dbAccessor.createFilm(film);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println("Errorr");
//		}
////		if(filmObj.getTitle() == null || "".equals(filmObj.getTitle())) {
////			System.out.println("Errorr");
////			return  "";
////		}
//		return "WEB-INF/result.jsp";
//	  
//
//	}
 
	@RequestMapping(path="addFilm.do", method=RequestMethod.POST)
	public String createFilm(Film film) throws SQLException {
		System.out.println("*************************************");
		System.out.println(film);
		dbAccessor.createFilm(film);
	  
		return "WEB-INF/result.jsp";
	}

}



