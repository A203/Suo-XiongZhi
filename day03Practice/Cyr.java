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
		return "ˮ��";
	}
}

class Apple extends Fruit01{
	public String toString(){
		return "ƻ��";
	}
}

class Mango extends Fruit01{
	public String toString(){
		return "â��";
	}
}
class  Juicer{
	public void juice(Fruit01 fruit01){
		System.out.println("ե"+fruit01+"֭");
		}
}