package test;

public class Test4 {

	public static void main(String[] args) {

		int n = 1;
		int s = 2;

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 5; j++) {

				if (n % 2 == 1) {
					System.out.printf("%3d ", n);
					n += 4;
				}

			}

			System.out.println();

			for (int j = 0; j < 5; j++) {

				if (s % 2 == 0 && n % 2 == 1) {
					System.out.printf("%3d ", s);
					s += 4;
				}

			}

			n = 3;
			s = 4;

			System.out.println();
		}
	}
}
