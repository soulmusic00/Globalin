package com.inher;

public class HospitalMain {

	public static void main(String[] args) {

		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal tiger = new Cat();
		
		Hospital hop = new Hospital();
		
		hop.inject(dog);
		hop.inject(cat);
		hop.inject(tiger);
		
	}

}
