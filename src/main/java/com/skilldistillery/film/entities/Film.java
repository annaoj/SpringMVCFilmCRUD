package com.skilldistillery.film.entities;

import java.util.ArrayList;
import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private String release_year;
	private int language_id;
	private int rental_duration;
	private double rental_rate;
	private int length;
	private double replacement_cost;
	private String rating;
	private String special_features;
	private List<Actor> laCast;
	private String language;
	private List<Category> category;

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public Film() {
		
	}
	
	public Film(int id, String title, String description, String release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacement_cost, String rating, String special_features,
			List<Actor> laCast, String language, List<Category> category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_features = special_features;
		this.laCast = laCast;
		this.language = language;
		this.category = category;
	}

	public Film(int id, String title, String description, String release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacement_cost, String rating, String special_features,
			List<Actor> laCast) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_features = special_features;
		this.laCast = laCast;
	}

	public Film(int id, String title, String description, String release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacement_cost, String rating, String special_features,
			List<Actor> laCast, String language) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_features = special_features;
		this.laCast = laCast;
		this.language = language;
	}

	public Film(String title, int language_id) {
		this.title = title;
		this.language_id = language_id;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", release_year=" + release_year
				+ ", language_id=" + language_id + ", rental_duration=" + rental_duration + ", rental_rate="
				+ rental_rate + ", length=" + length + ", replacement_cost=" + replacement_cost + ", rating=" + rating
				+ ", special_features=" + special_features + ", laCast=" + laCast + ", language=" + language + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((laCast == null) ? 0 : laCast.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + language_id;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((release_year == null) ? 0 : release_year.hashCode());
		result = prime * result + rental_duration;
		long temp;
		temp = Double.doubleToLongBits(rental_rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacement_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((special_features == null) ? 0 : special_features.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (laCast == null) {
			if (other.laCast != null)
				return false;
		} else if (!laCast.equals(other.laCast))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (language_id != other.language_id)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (release_year == null) {
			if (other.release_year != null)
				return false;
		} else if (!release_year.equals(other.release_year))
			return false;
		if (rental_duration != other.rental_duration)
			return false;
		if (Double.doubleToLongBits(rental_rate) != Double.doubleToLongBits(other.rental_rate))
			return false;
		if (Double.doubleToLongBits(replacement_cost) != Double.doubleToLongBits(other.replacement_cost))
			return false;
		if (special_features == null) {
			if (other.special_features != null)
				return false;
		} else if (!special_features.equals(other.special_features))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public int getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}

	public double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public List<Actor> getLaCast() {
		return this.laCast = new ArrayList<Actor>(laCast);
	}

	public void setLaCast(List<Actor> laCast) {
		this.laCast = laCast;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
