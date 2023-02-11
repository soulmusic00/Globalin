package com.enumex;

public class EnumEx03 {

	public static void main(String[] args) {
		
		System.out.println(City.SEOUL.getIngu());
		
		for(City c : City.values()) {
			System.out.printf("%s(%s) : %d%n", c , c.getCityName(), c.getIngu());
		}
			
		
		
		
		
		

	}

}
