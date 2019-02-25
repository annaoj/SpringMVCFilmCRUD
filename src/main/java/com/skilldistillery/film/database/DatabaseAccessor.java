package com.skilldistillery.film.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Inventory;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId) throws SQLException;
  public Actor findActorById(int actorId) throws SQLException;
  public List<Actor> findActorsByFilmId(int filmId);
  public List<Film> findfilmByKeyword(String keyword) throws SQLException;
  public List<Category> findCategorybyFilmId(int filmId);
  public List<Inventory> getInventoryAndCondition(int filmId);
  public boolean createFilm(Film film) throws SQLException;
  public boolean deleteFilm(int filmId) throws SQLException;
  public boolean saveFilm(Film film, int filmId) throws SQLException;
  public boolean createActor(Actor actor) throws SQLException;
  
}