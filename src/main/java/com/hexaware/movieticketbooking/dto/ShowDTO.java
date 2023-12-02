package com.hexaware.movieticketbooking.dto;

import java.time.LocalDateTime;

public class ShowDTO {
	
	 private int showId;
	    private String showName;
	    private LocalDateTime showTime;
	    private int theatreId;
	    private int screenId;
	    private int movieId;

	    // Constructors, getters, setters
	 
	    public ShowDTO(int showId, String showName, LocalDateTime showTime, int theatreId, int screenId, int movieId) {
			super();
			this.showId = showId;
			this.showName = showName;
			this.showTime = showTime;
			this.theatreId = theatreId;
			this.screenId = screenId;
			this.movieId = movieId;
		}
	    
	    public ShowDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
		public int getShowId() {
	        return showId;
	    }


		public void setShowId(int showId) {
	        this.showId = showId;
	    }

	    public String getShowName() {
	        return showName;
	    }

	    public void setShowName(String showName) {
	        this.showName = showName;
	    }

	    public LocalDateTime getShowTime() {
	        return showTime;
	    }

	    public void setShowTime(LocalDateTime showTime) {
	        this.showTime = showTime;
	    }

	    public int getTheatreId() {
	        return theatreId;
	    }

	    public void setTheatreId(int theatreId) {
	        this.theatreId = theatreId;
	    }

	    public int getScreenId() {
	        return screenId;
	    }

	    public void setScreenId(int screenId) {
	        this.screenId = screenId;
	    }

	    public int getMovieId() {
	        return movieId;
	    }

	    public void setMovieId(int movieId) {
	        this.movieId = movieId;
	    }

}
