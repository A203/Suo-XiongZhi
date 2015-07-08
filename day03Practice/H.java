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
		System.out.println("这是I在嗨");
		System.out.println(123);
	}
}

class J extends I{
	public void high() {
		super.high();
		System.out.println("这是J在嗨");
		System.out.println(456);
	}
}

class K extends J{
	public void high() {
		super.high();
		System.out.println("这是K在嗨");
		System.out.println(789);
	}
}