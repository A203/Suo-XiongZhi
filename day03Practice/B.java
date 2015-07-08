package day03Practice;

public class B extends A{

	String str = "B";
	void hello(){
		System.out.println("B.......");
	}

	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.str);
		a.hello();//实现动态绑定
	}

}
