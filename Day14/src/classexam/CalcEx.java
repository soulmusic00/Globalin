package classexam;


import java.io.*;


public class CalcEx {

	public static void main(String[] args) throws IOException{
		
		
		Calc c = new Calc();
		
		c.input();
		
		int sum = c.cal();
		
		c.prt(sum);
		
		

	}

}
