package day03Practice;

public class H {
	public static void main(String[] args) {
		I i = new J();
		i.high();
		J j = new K();
		j.high();
	}
}

abstract class I{
	public void high(){
		System.out.println("����I����");
		System.out.println(123);
	}
}

class J extends I{
	public void high() {
		super.high();
		System.out.println("����J����");
		System.out.println(456);
	}
}

class K extends J{
	public void high() {
		super.high();
		System.out.println("����K����");
		System.out.println(789);
	}
}