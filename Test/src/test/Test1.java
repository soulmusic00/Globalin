package test;

public class Test1 {

	public static void main(String[] args) {

		int n = 1;
		int cnt = 1;
		int[][] aa = new int[4][];

		for (int i = 0; i < aa.length; i++) {
			aa[i] = new int[cnt+i];
			for (int j = 0; j < aa[i].length; j++) {
				aa[i][j] = n++;
			}
			System.out.println();
		}

		for (int i = 0; i < aa.length; i++) {

			for (int j = 0; j < aa[i].length; j++) {
				System.out.printf("%3d", aa[i][j]);
			}
			System.out.println();
		}

	}

}
