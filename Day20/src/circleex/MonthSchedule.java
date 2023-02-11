package circleex;

import java.util.*;

public class MonthSchedule {

	private Scanner sc = new Scanner(System.in);
	private int nDays;
	private Day[] days; // Day 객체 배열

	public MonthSchedule(int nDays) {
		this.nDays = nDays;
		this.days = new Day[nDays];
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day();
		}
	}

	private void input() {

		System.out.print("날짜(1 ~ 30): ");
		int day = sc.nextInt();

		System.out.println("할일(빈칸없이 입력): ");
		String work = sc.next();

		day--;

		if (day < 0 || day > 29) {
			System.out.println("날짜를 잘못 입력하셨습니다.");
			return;
		}
		days[day].set(work);

		System.out.println((day + 1) + "일의 할 일은");
		days[day].show();
	}

	private void view() {
		System.out.print("날짜(1 ~ 30): ");
		int day = sc.nextInt();

		day--;

		if (day < 0 || day > 29) {
			System.out.println("날짜를 잘못 입력하셨습니다.");
			return;
		}

		System.out.println((day + 1) + "일의 할 일은");
		days[day].show();
	}

	

	private void finish() {
		System.out.println("프로그램을 종료 합니다.");
	}

	public void run() {

		System.out.println("글로벌인 IT4기 11월 스케쥴 관리 프로그램");
		while (true) {
			System.out.println("할일(입력: 1, 보기: 2, 종료:3 ");
			int menu = sc.nextInt();
			switch (menu) {
			
			case 1:
				input();
				break;
			case 2:
				view();
				break;
			case 3:
				finish();
				return;
			default:
				System.out.println("잘못 입력 하셨습니다");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		MonthSchedule m = new MonthSchedule(30);
		m.run();

	}

}
