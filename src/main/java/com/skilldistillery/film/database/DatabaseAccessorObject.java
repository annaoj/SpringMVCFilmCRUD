package com.skilldistillery.film.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Inventory;

@Component
public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {

		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration,"
				+ "film.rental_rate,length, replacement_cost, rating, special_features, "
				+ "language.name from film"
				+ " JOIN language ON language.id=film.language_id "
				+ "WHERE film.id=?";
		Film filmObj = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);

			// set parameter
			ps.setInt(1, filmId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				filmObj = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"), findActorsByFilmId(rs.getInt("id")),
						rs.getString("language.name"), findCategorybyFilmId(rs.getInt("id")));
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}

		return filmObj;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actorObj = null;

		String sql = "SELECT  id, first_name, last_name FROM actor WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);

			// set parameter
			ps.setInt(1, actorId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actorObj = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}

		return actorObj;
	}

//	Select a.first_name, a.last_name,film.title from actor a Join film_actor ON film_actor.actor_id=a.id JOin film ON film_actor.film_id=film.id where film.id=2;

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> la = new ArrayList<Actor>();
		String sql = "Select a.id, a.first_name, a.last_name,film.title from actor a Join film_actor ON film_actor.actor_id=a.id JOin film ON film_actor.film_id=film.id where film.id=?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);

			// set parameter
			ps.setInt(1, filmId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				la.add(new Actor(rs.getInt("a.id"), rs.getString("a.first_name"), rs.getString("a.last_name")));
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}

		return la;

	}

	@Override
	public List<Category> findCategorybyFilmId(int filmId) {
		List<Category> categories = new ArrayList<Category>();
		String sql = "Select category.name from category Join film_category ON film_category.category_id=category.id JOIN film ON film_category.film_id=film.id where film.id=?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);

			// set parameter
			ps.setInt(1, filmId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				categories.add(new Category(rs.getString("category.name")));
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}

		return categories;

	}

	// Select title, description, l.name from film JOIN language l ON
	// film.language_id=l.id WHERE title LIKE "%test%" OR description LIKE "%test%";
	@Override
	public List<Film> findfilmByKeyword(String keyword) throws SQLException {
		List<Film> filmList = new ArrayList<Film>();

		String sql = "SELECT film.id, title, description," + " release_year, language_id, rental_duration,"
				+ " rental_rate,length, replacement_cost, rating, special_features, language.name  from film JOIN language ON language.id=film.language_id WHERE title LIKE ? OR description LIKE ? ORDER BY title ASC";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);

			// set parameter
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				filmList.add(new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getString("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"), findActorsByFilmId(rs.getInt("id")),
						rs.getString("language.name"), findCategorybyFilmId(rs.getInt("id"))));
			}
				System.out.println(filmList);
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error in findfilmByKeyword " + e.getMessage());
			System.err.println(e);
		}
		return filmList;
	}

	@Override
	public List<Inventory> getInventoryAndCondition(int filmId) {
		List<Inventory> inventoryList = new ArrayList<Inventory>();

		String sql = "SELECT film.title, media_condition, store_id FROM film JOIN inventory_item on film.id = film_id WHERE film.id = ? ORDER BY store_id ASC;";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);

			// set parameter
			ps.setInt(1, filmId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				inventoryList.add(new Inventory(rs.getString("media_condition"), rs.getInt("store_id")));
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error in findfilmByKeyword " + e.getMessage());
			System.err.println(e);
		}
		return inventoryList;
	}

	@Override
	public boolean createFilm(Film film) throws SQLException {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, language_id) " + " VALUES (?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setInt(2, film.getLanguage_id());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setId(newFilmId);

					System.out.println(newFilmId + "newfilmid");
				}
			} else {
				return false;
			}
			conn.commit(); // COMMIT TRANSACTION
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
					return false;
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
					return false;
				}
			}
			//throw new RuntimeException("Error inserting actor " + film);
		}
//		finally {
//			return filmObj;
//		}
		return true;

//		return filmObj;
	}

	@Override
	public boolean deleteFilm(int filmId) throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			int updateCount = stmt.executeUpdate();

			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean saveFilm(Film film, int filmId) throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE film SET "
					+ "title=?, "
					+ "language_id=?, "
					+ "description=?, "
					+ "release_year=?, "
					+ "rental_duration=?, "
					+ "rental_rate=?,"
					+ " length=?,"
					+ " replacement_cost=?,"
					+ " rating=?,"
					+ " special_features=?"
					+ " WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, film.getTitle());
			stmt.setInt(2, film.getLanguage_id());
			stmt.setString(3, film.getDescription());
			stmt.setString(4, film.getRelease_year());
			stmt.setInt(5, film.getRental_duration());
			stmt.setDouble(6, film.getRental_rate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacement_cost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecial_features());
			stmt.setInt(11, filmId);

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				sql = "DELETE FROM film WHERE id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, film.getId());
				updateCount = stmt.executeUpdate();
				sql = "INSERT INTO film (title, language_id, description, release_year, rental_duration, rental_rate, length, replacement_cost, rating, special_features, language) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);

				conn.commit(); // COMMIT TRANSACTION
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}
	public Actor createActor(Actor actor) {
		  Connection conn = null;
		  try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "INSERT INTO actor (first_name, last_name) "
		                     + " VALUES (?,?)";
		    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    stmt.setString(1, actor.getFirst_name());
		    stmt.setString(2, actor.getLast_name());
		    int updateCount = stmt.executeUpdate();
		    if (updateCount == 1) {
		      ResultSet keys = stmt.getGeneratedKeys();
		      if (keys.next()) {
		        int newActorId = keys.getInt(1);
		        actor.setId(newActorId);
		        if (actor.getFilms() != null && actor.getFilms().size() > 0) {
		          sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
		          stmt = conn.prepareStatement(sql);
		          for (Film film : actor.getFilms()) {
		            stmt.setInt(1, film.getId());
		            stmt.setInt(2, newActorId);
		            updateCount = stmt.executeUpdate();
		          }
		        }
		      }
		    } else {
		      actor = null;
		    }
		    conn.commit(); // COMMIT TRANSACTION
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    throw new RuntimeException("Error inserting actor " + actor);
		  }
		  return actor;
		}
}