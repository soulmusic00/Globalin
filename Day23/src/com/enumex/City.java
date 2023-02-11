package com.enumex;

public enum City {

	
	SEOUL("서울", 1000),
	BUSAN("부산", 350),
	DAEGU("대구", 250),
	INCHON("인천", 200);
	
	private final String cityName;
	private final int ingu;
	
	private City(String cityName, int ingu) {
		this.cityName = cityName;
		this.ingu = ingu;
		
	}
	
	protected String getCityName() {
		return cityName;
	}
	protected int getIngu() {
		return ingu;
	}
	
	
	
	
	
	
	
	
	
}
