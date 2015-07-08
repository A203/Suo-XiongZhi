package day03Practice;

public class Tiger extends Animal {
	
	public Tiger(String name, int age) {
		super(name, age);
		System.out.println("这是继承时候老虎的地盘");
	}
	
	//继承了Animal过后，方法进行重写
	void sleep(){
		System.out.println("老虎是这样睡觉的........");
	}
	//继承了Animal过后，方法进行重写
	void eat(){
		System.out.println("老虎是这样吃东西的......");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tiger tiger= new Tiger("guguo", 4);
		tiger.sleep();
		tiger.eat();
		
		//对这个老虎进行名字和年龄的打印
		System.out.println(tiger.name);
		System.out.println(tiger.age);
		tiger.name = "baobao";
		tiger.age = 5;
		
		//修改过后进行老虎新的名字和年龄的打印和输出
		System.out.println(tiger.name);
		System.out.println(tiger.age);
		System.out.println("hehe");
		
		//实现动物的动态绑定
		Animal animal2 = new Tiger("wao", 56);
		System.out.println(animal2.name);
		System.out.println(animal2.age);
		
	}

}
