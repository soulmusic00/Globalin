package circleex;

public class Circle {

	
	private double x, y;
	private int radius;
	
	
	public Circle(double x, double y, int radius) { //필드 초기화
		
		this.x = x;
		this.y = y;
		this.radius = radius;
		
	
	}
	

	

	
	public void show() {
		
		System.out.println("(" + x + "," + y + ")" + radius);
		 
	}
	
	
	//메소드 추가 
	public double getArea() {
		
		return radius * radius * Math.PI;
		
	}
	
}
