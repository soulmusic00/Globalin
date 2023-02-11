package com.gameex;

public class km2Mile extends Converter{

	
	public km2Mile(double ratio) {
		
		this.ratio = ratio;
		
		
	}
	
	

	@Override
	protected double convert(double src) {
		
		
		
		return src/ratio;
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "km";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "mile";
	}
	
	public static void main(String[] args) {
		
		km2Mile toMile = new km2Mile(1.6);
		toMile.run();
		
		
		
	}

}
