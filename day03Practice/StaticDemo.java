package day03Practice;

public class StaticDemo {

	int age;
	
	void hello(){
		System.out.println("Hello......");
	}
	
	static void hi(){
		System.out.println("Hi.....");
	}
	
	public static void main(String[] args) {
		StaticDemo s = new StaticDemo();
		s.hello();
		StaticDemo.hi();
		//調用靜態的hi方法，但是需要注意的是：慎用
		StaticDemo.hi();
	}

}
