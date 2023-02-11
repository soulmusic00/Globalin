package com.classex;

import java.io.*;  

public class MethodEx02 {

	public static int aaa() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("첫번째 수: ");

		int a = Integer.parseInt(br.readLine());
		System.out.println("두번째 수: ");

		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		if (a > b) {
			return a;
		}

		return b;

	}

	public static void bbb() throws IOException {
		// 두 수 사이의 합계를 구하는 방식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("첫번째 수: ");
		int a = Integer.parseInt(br.readLine());
		System.out.println("두번째 수: ");
		int b = Integer.parseInt(br.readLine());

		int sum = 0;

		if (a > b) {
			a = a ^ b;
			b = b ^ a;
			a = a ^ b;
		}

		for (int i = a; i <= b; i++) {
			sum += i;
		}

		System.out.println(a + " ~ " + b + "사이의 합계:" + sum);

	}

	public static String ccc(int x, int y, int z) {

		if (y >= x && y >= z) {
			int temp = x;
			x = y;
			y = temp;

		}
		if (z >= x && z >= y) {
			int temp = x;
			x = z;
			z = temp;
		}
		if (z >= y) {
			int temp = y;
			y = z;
			z = temp;
		}

		String abc = x + ">=" + y + ">=" + z;
		return abc;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 0;

//		MethodEx02 me = new MethodEx02();

		while (true) {
			System.out.println("1.큰수 2. 사이합계 3.큰 순서대로 4. 종료");
			x = Integer.parseInt(br.readLine());

			if (x == 1) {
				int k = aaa();
				System.out.println("두개의 수중 가장 큰 수는 " + k + "입니다.");
			} else if (x == 2) {
				bbb();
			} else if (x == 3) {

				System.out.println("첫번째 수: ");
				int FirstSu = Integer.parseInt(br.readLine());
				System.out.println("두번째 수: ");
				int SecondSu = Integer.parseInt(br.readLine());
				System.out.println("세번째 수: ");
				int ThirdSu = Integer.parseInt(br.readLine());

				String str = ccc(FirstSu, SecondSu, ThirdSu);
				System.out.println("큰 순서대로 출력:" + str);

			} else if (x == 4) {
				break;
			} else {
				System.out.println("잘못 입력");
			}
			System.out.println();
		}

	}

}
