package day03Practice;

class Person1 {

	String name;
	String gender;
	int age;
	
	Person1(){
		System.out.println("this is a person named hehe");
	}
	
	//³õÊ¼‰K
		{
			System.out.println(1222);
		}
	
	public static void main(String[] args) {
		Person1 p = new Person1();
		p.age = 12;
		p.gender = "male";
		System.out.println(p.age);
		System.out.println(p.gender);
	}

}
