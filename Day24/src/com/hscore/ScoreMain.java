package com.hscore;

public class ScoreMain {

	public static void main(String[] args) throws Exception {
		
		
		char ch;
		//디형성(Que)
		Score score = new ScoreImpl();
		
		while(true) {
			
			
			do {
				
				System.out.println("1.추가 2.수정 3. 삭제 4. 전체목록 보기 5. 학번 검색 6. 이름 검색 7.종료");
				ch = (char)System.in.read();
				System.in.read();
				System.in.read();
				
				
			}while(ch < '1' || ch > '7');   
			
			switch(ch) {
			
			case '1' : score.insert(); break;			
			case '2' : score.update(); break;			
			case '3' : score.delete(); break;			
			case '4' : score.listAll(); break;			
			case '5' : score.searchHak(); break;			
			case '6' : score.searchName(); break;			
			case '7' : System.exit(0);		
			
			
			}
			
			
		}
		
		
		

	}

}
