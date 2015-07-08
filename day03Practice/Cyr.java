package day03Practice;

public class Cyr {
	
	public static void main(String[] args) {
		
		Juicer j=new Juicer();	
	    Fruit01 fruit01=new Mango(); 
	    j.juice(fruit01);
	    System.out.println("hi");
	    
    }
	
}

class Fruit01 {
	public String toString(){
		return "水果";
	}
}

class Apple extends Fruit01{
	public String toString(){
		return "苹果";
	}
}

class Mango extends Fruit01{
	public String toString(){
		return "芒果";
	}
}
class  Juicer{
	public void juice(Fruit01 fruit01){
		System.out.println("榨"+fruit01+"汁");
		}
}