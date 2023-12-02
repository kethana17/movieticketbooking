package com.hexaware.movieticketbooking.dto;

public class TheatreDTO {
	
	 private int id;
	 private String name;

	    public TheatreDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
		// Constructors, getters, setters

	    public TheatreDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		// Getters and setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

}
