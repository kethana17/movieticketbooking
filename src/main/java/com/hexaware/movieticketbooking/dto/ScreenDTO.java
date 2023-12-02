package com.hexaware.movieticketbooking.dto;

public class ScreenDTO {
	
	private int id;
    private String screenName;

    // Constructors, getters, setters

    // Getters and setters
    
    public ScreenDTO(int id, String screenName) {
		super();
		this.id = id;
		this.screenName = screenName;
	}
   
    public ScreenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }
    
	public void setId(int id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

}
