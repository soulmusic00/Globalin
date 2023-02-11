package test;

public class Test2 {

	public static void main(String[] args) {

		int n = 1;

		int s = 2;

		for (int i = 1; i <= 4; i++) {
			System.out.printf("%3d", n);
			for (int j = 1; j <= 4; j++) {

				if (s > 0 && s < 6) {
					System.out.printf("%3d", s);
					s += 1;
				} else if (s > 5 && s < 11) {
					System.out.printf("%3d", s);
					s -= 1;
				}

			}
			
			for (int j = 1; j <= 4; j++) {
				
				if (s > 0 && s < 6) {
					System.out.printf("%3d", s);
					s += 1;
				} else if (s > 5 && s < 11) {
					System.out.printf("%3d", s);
					s -= 1;
				}
				
			}
			
			
			
			
			
			System.out.println();

			n += 9;
			s += 3;

		}

	}

}
