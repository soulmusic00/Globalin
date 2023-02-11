package classexam;

public class JavaPizza {

	public static void main(String[] args) {
	
		Circle pizza = new Circle(7);
		Circle donut = new Circle();
		
		//pizza.radius = 7;

		pizza.name = "자바피자";
		
		double pizzaSize = pizza.getArea();
		
		System.out.println(pizza.radius);
		
		
		
		
		System.out.println("크기가 " + pizzaSize + "인" + pizza.name + "입니다.");
		System.out.println("맛있게 드세요.");  
		
		
	}

}
