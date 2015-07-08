package day03Practice;

public class Person2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person person = new Person(90);
		System.out.println(person.age);
	}
}

class Person{
	public Person(int age) {
		this.age = age;
	}
	//初始塊在開始過程當中就已經執行在代碼塊中
	{
		age = 18;
	}
	{
		age = 8;
	}
	int age;
}