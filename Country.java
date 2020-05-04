package com.my.newproject;

public class Country  {
    private String countryName;
    private String continent; 
    
	public Country(String countryName, String continent){
		this.countryName = countryName;
		this.continent = continent;
    }
	
	public String getCountryName(){
		return countryName;
	}
	
	public String getContinent(){
		return continent;
	}
}
