package test;

public class Test5 {

	public static void main(String[] args) {

//		int[][] aa = new int[4][3];
////		aa[0].length = 4;
////		aa[1].length = 3;
////		aa[2].length = 2;
////		aa[3].length = 1;
//
//		int n = 1;
//		int s = 2;
//
//		for (int i = 0; i < aa.length; i++) {
//
//			System.out.print(n);
//			n += 1;
//			for (int j = 0; j < aa[i].length; j++) {
//
//				System.out.print(s);
//				s += 1;
//			}
//			System.out.println();
//		}
		
		
		
//		int n = 1;
//		int cnt = 4;
//		int[][] aa = new int[cnt][];
//
//		for (int i = 0; i < aa.length; i++) {
//			aa[i] = new int[cnt+i];
//			for (int j = 0; j < aa[i].length; j++) {
//				aa[i][j] = n++;
//			}
//			System.out.println();
//		}
//
//		for (int i = 0; i < aa.length; i++) {
//
//			for (int j = 0; j < aa[i].length; j++) {
//				System.out.printf("%3d", aa[i][j]);
//			}
//			System.out.println();
//		}
		
		
		
		int n = 1;
		int cnt = 4;
		int[][] aa = new int[cnt][];

		for (int i = 0; i < aa.length; i++) {
			aa[i] = new int[cnt-i];
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
