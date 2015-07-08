package day03Practice;

import zuoYe.Plant;

class Flower extends Plant{
	
	public static void main(String[] args) {
		Flower flower = new Flower();
		flower.eat("玫瑰", "自己的根和花叶");
		flower.sleep();
	}

	public void sleep() {
		System.out.println("这是花儿在睡觉......");
	}

	public void eat(String name, String food) {
		System.out.println(name+"最喜欢吃"+food);
	}
}