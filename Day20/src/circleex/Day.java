package circleex;

public class Day {

	private String work;
	
	public void set(String work) {
		this.work = work;
	}
	
	public void show() {
		if(work == null) System.out.println("할일이 없습니다.");
		else System.out.println(work + "입니다.");
	}
	
	
	
	
}
