package day03Practice;

public class Phone {
	
	String name;
	String brand;
	int price;
	
	public Phone(String s1, String s2, int i) {
		name=s1;
		brand=s2;
		price=i;
	}

	public void phone() {
		System.out.println("hehe");
	}
	
	void call(){
		System.out.println("call.....");
	}

	void msg(){
		System.out.println("send message.....");
	}
	
	public static void outStr(String s) {
		System.out.println(s);
	}
	public static void outInt(int i) {
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone p1 = new Phone("Nokia","BaoMiHua",998);
//		p1.name = "nokia";
//		p1.brand = "BaoMiHua";
//		p1.price = 998;
		outStr(p1.name);
		outStr(p1.brand);
		outInt(p1.price);
		p1.call();
		p1.msg();
	}
	

}
