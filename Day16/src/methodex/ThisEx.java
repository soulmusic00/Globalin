package methodex;

/*
 * this 와 this()
 * - this란 특정 객체 내에서 자신이 생성되었을때의 참조변수를 의미함
 * -객체의 주소는 생성전까지는 모르기 때문에 객체 생성 후 자신의 주소로 대치됨
 * 
 * this()
 * -현재 객체의 생성자를 의미한다.
 * - 생성자 안에서 오버로딩 된 다른 생성자를 호출한 경우 this()라는 키워드로 호출함
 * 
 *   //set 변수 수정
 *   //get 변수 읽기
 *   //변수는 private 메소드는 public 
 * 
 */

public class ThisEx {

	String name, jumin, tel; // 멤버 필드

	// 생성자를 활용해서 초기화 함
	public ThisEx() { // 기본 생성자
		this.name = "Guest";
		this.jumin = "000000-0000000";
		tel = "000-0000-0000";
	}

	public ThisEx(String name) { // 생성자의 오버로딩
		this(); // 생성자 안에서 생성자를 호출할 때는 첫번째 라인에서 호출해야한다
		this.name = "name";
	}

	public ThisEx(String name, String jumin) { // 생성자의 오버로딩
		this(name); // 생성자 안에서 생성자를 호출할 때는 첫번째 라인에서 호출해야한다
		this.jumin = "jumin";
	}

	public ThisEx(String name, String jumin, String tel) { // 생성자의 오버로딩
		this(name, jumin); // 생성자 안에서 생성자를 호출할 때는 첫번째 라인에서 호출해야한다
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public String getJumin() {
		return jumin;
	}

	public String getTel() {
		return tel;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름:" + name + ", 주민번호:" + jumin + ", 전화번호:" + tel;
	}

}
