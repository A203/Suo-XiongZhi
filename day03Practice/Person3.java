package day03Practice;

public class Person3 {

	public static void main(String[] args) {
		new Person4();
		new Person4();
	}

}

class Person4{
	static{
		System.out.println(12);
	}
	{
		System.out.println(20);
	}
	Person4(){
		System.out.println("Person4");
	}
}