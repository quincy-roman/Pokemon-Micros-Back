package com.pokemaster.PokemonMicroservices.models;

public class NewsFeedWrapper {
	NewsFeed newsfeed;
	String month;
	String day;
	String year;
	
	public NewsFeedWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	

	public NewsFeedWrapper(NewsFeed newsfeed, String month, String day, String year) {
		super();
		this.newsfeed = newsfeed;
		this.month = month;
		this.day = day;
		this.year = year;
	}



	public NewsFeed getNewsfeed() {
		return newsfeed;
	}

	public void setNewsfeed(NewsFeed newsfeed) {
		this.newsfeed = newsfeed;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "NewsFeedWrapper [newsfeed=" + newsfeed + ", month=" + month + ", day=" + day + ", year=" + year + "]";
	}
	
	
}
