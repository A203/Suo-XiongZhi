package day03Practice;

class Animal {
	
	String name;
	int age;
	
	public Animal(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	void sleep(){
		System.out.println("动物是这样睡觉的.......");
	}
	
	void eat(){
		System.out.println("动物是这样吃东西的......");
	}
	
	public static void main(String[] args) {
		Animal animal = new Animal("tiger",5);
		animal.sleep();
		animal.eat();
		String string = animal.name+"是这样睡觉的吗？";
		System.out.println(string);
	}

}
