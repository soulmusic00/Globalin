package com.banking;

import java.util.*;
// static 변수 instance 변수 
// 메소드가 아닌 클래스 안에 소속된 변수가 멤버변수 (전역변수) 
// 전역 변수 <===> 지역변수
// 전역 변수 <static 변수 instance변수>
public class BankApplication {

	private static Scanner sc = new Scanner(System.in);
	private static Account[] accountArray = new Account[100];

	public static void main(String[] args) {

		boolean run = true;
		while (run) {

			System.out.println("-----------------------------------------------");
			System.out.println("1 계좌생성 l 2. 계좌목록 l 3.예금 l 4.출금 l 5. 종료");
			System.out.println("-----------------------------------------------");

			System.out.println("은행 업무선택: ");
			int selectNo = sc.nextInt();

//			switch(selectNo) {
//			case 1 : 
//			createAccount(); 
//				break;
//			case 2 :
//				break;
//			case 3 :
//				break;
//			case 4 :
//				break;
//			case 5; 
//				break;
//			}

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}

	}

	// 계좌 생성

	private static void createAccount() {

		System.out.println("-------------------");
		System.out.println("계좌 생성");
		System.out.println("-------------------");

		System.out.println("계좌번호 입력: ");
		String ano = sc.next();
		System.out.println("계좌 에금주 입력: ");
		String owner = sc.next();
		System.out.println("계좌 초기 금액 입력: ");
		int balance = sc.nextInt();

		Account newAccount = new Account(ano, owner, balance);

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}

	}

	private static void accountList() {

		System.out.println("------------");
		System.out.println("    계좌 목록");
		System.out.println("    계좌 번호    소유주    잔고");
		System.out.println("-------------");

		for (int i = 0; i < accountArray.length; i++) {

			Account account = accountArray[i];

			if (account != null) {
				System.out.println(account.getAno());
				System.out.println(" ");
				System.out.println(account.getOwner());
				System.out.println(" ");
				System.out.println(account.getBalance());
				System.out.println();
			}
		}
		System.out.println("---------------------------");
	}

	// 계좌 목록 보기

	// 예금

	private static void deposit() {

		System.out.println("-------------------");
		System.out.println("예금");
		System.out.println("--------------------");
		System.out.println("계좌번호 입력: ");
		String ano = sc.next();
		System.out.println("입금 금액 입력: ");
		int money = sc.nextInt();

		Account account = findAccount(ano);
		if (account == null) { // 계좌가 없을 경우
			System.out.println("결과: 계좌가 없습니다.");
			return;
		} else {
			account.setBalance(account.getBalance() + money);
			System.out.println("결과 : 예금이 성공 되었습니다.");
		}

	}

	// 출금
	private static void withdraw() {

		System.out.println("-------------------");
		System.out.println("출금");
		System.out.println("--------------------");
		System.out.println("계좌번호 입력: ");
		String ano = sc.next();
		System.out.println("입금 금액 입력: ");
		int money = sc.nextInt();

		Account account = findAccount(ano);
		if (account == null) { // 계좌가 없을 경우
			System.out.println("결과: 계좌가 없습니다.");
			return;
		} else {
			account.setBalance(account.getBalance() - money);
			System.out.println("결과 : 출금이 성공 되었습니다.");
		}

	}

	// 출금 Account 배열에서 ano와 동일한 Account 객체 찾기

	private static Account findAccount(String ano) {

		Account account = null;

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				String dbAno = accountArray[i].getAno();
				if (dbAno.equals(ano)) {
					account = accountArray[i];
					break;
				}

			}
		}

		return account;

	}// end findAccount

}
