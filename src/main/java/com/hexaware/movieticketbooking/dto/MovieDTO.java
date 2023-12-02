package com.hexaware.movieticketbooking.dto;

import com.hexaware.movieticketbooking.entity.Show;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class MovieDTO {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int movieId;

	    private String movieName;
	    private String genre;
	    private String description;
	    private double rating;

	    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Show show;

		public MovieDTO() {
			super();
		}

		public MovieDTO(int movieId, String movieName, String genre, String description, double rating, Show shows, Show show) {
			super();
			this.movieId = movieId;
			this.movieName = movieName;
			this.genre = genre;
			this.description = description;
			this.rating = rating;
			this.show = show;
		}

		public int getMovieId() {
			return movieId;
		}

		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}

		public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		public Show getShow() {
			return show;
		}

		public void setShows(Show show) {
			this.show = show;
		}

	    // Constructors, getters, setters

}
