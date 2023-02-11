package circleex;

import java.util.Scanner;

public class CircleManager {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Circle[] c = new Circle[3];

		// 입력
		for (int i = 0; i < c.length; i++) {
			System.out.println("x,y,radius: ");
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			int radius = sc.nextInt();
			c[i] = new Circle(x, y, radius);
		}

		int max = 0;
		for (int i = 1; i < c.length; i++) {
			if (c[max].getArea() < c[i].getArea()) {
				max = i;
			}
		}

		// 출력
		for (int i = 0; i < c.length; i++) {
			c[i].show();
		}

		System.out.println("가장 면적이 큰 원은");
		c[max].show();

	}

}
