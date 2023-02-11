package dicex;

import java.util.*;

public class DictionaryMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("한영 단어 검색 프로그램");

		while (true) {

			System.out.println("한글 단어 입력: ");
			String kor = sc.next();
			if (kor.equals("그만")) {
				break;
			}

			String eng = Dictionary.kor2Eng(kor);

			if (eng == null) {
				System.out.println("입력하신 " + kor + "는 사전에 없습니다.");
			}else {
				System.out.println(kor + "은 " + eng +" 입니다.");
			}

		}

	}

}
