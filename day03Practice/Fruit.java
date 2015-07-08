package day03Practice;

public class Fruit {

	String name;
	int singlePrice;
	String place;
	
	Fruit() {
	}
	Fruit(String str1,int i,String Str2){
		name=str1;
		singlePrice = i;
		place = Str2;
	}
	
	public static void main(String[] args) {
		Fruit f1 = new Fruit();
		f1.name = "Banana";
		f1.place = "FuJian";
		System.out.println("ﬂ@ «"+f1.name+","+"Æaµÿ «£∫"+f1.place+";");
//		System.out.println(f1.place);
	}
	

}
