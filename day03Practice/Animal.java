package day03Practice;

class Animal {
	
	String name;
	int age;
	
	public Animal(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	void sleep(){
		System.out.println("����������˯����.......");
	}
	
	void eat(){
		System.out.println("�����������Զ�����......");
	}
	
	public static void main(String[] args) {
		Animal animal = new Animal("tiger",5);
		animal.sleep();
		animal.eat();
		String string = animal.name+"������˯������";
		System.out.println(string);
	}

}
