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
	//��ʼ�K���_ʼ�^�̮��о��ѽ������ڴ��a�K��
	{
		age = 18;
	}
	{
		age = 8;
	}
	int age;
}