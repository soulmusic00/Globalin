package test;

public class Test3 {

	public static void main(String[] args) {
		int n = 20;
		int s = 19;

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 5; j++) {

				if (n % 2 == 0) {
					System.out.printf("%3d ", n);
					n -= 4;
				}

			}

			System.out.println();

			for (int j = 0; j < 5; j++) {

				if (s % 2 == 1 && n % 2 == 0) {
					System.out.printf("%3d ", s);
					s -= 4;
				}

			}

			n = 18;
			s = 17;

			System.out.println();
		}
	}

}
