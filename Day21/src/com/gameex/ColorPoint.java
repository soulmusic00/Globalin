package com.gameex;

public class ColorPoint extends Point {

	private String color;

//	public ColorPoint(int x, int y, String color) {
//		super(x, y);
//		this.color = color;
//

	public ColorPoint() {
		this(0, 0);
	}

//	}
	public ColorPoint(int x, int y) {
		super(x, y);
		this.color = "BLACK";

	}

	public void setXY(int x, int y) {
		move(x, y);
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return color + "색의(" + getX() + "," + getY() + ")의 점입니다.";
	}

	public static void main(String[] args) {

		ColorPoint zeroPoint = new ColorPoint(); // 0,0위치의 black
		System.out.println(zeroPoint.toString() + "입니다.");

		ColorPoint cp = new ColorPoint(10, 10); // 10,10 위치의 BLACK
		cp.setXY(5, 5);
		cp.setColor("Red");
		System.out.println(cp.toString() + "입니다.");

		// Black색의 (0,0)의 점입니다.
		// RED 색의(5,5)입니다.

//		String str = cp.toString();
//		System.out.println(str);

//		ColorPoint cp = new ColorPoint(5, 5, "YELLO");
//		cp.setXY(10, 20);
//		cp.setColor("Red");
//
//		String str = cp.toString();
//		System.out.println(str);

	}

}
