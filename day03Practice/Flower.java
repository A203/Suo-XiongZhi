package day03Practice;

import zuoYe.Plant;

class Flower extends Plant{
	
	public static void main(String[] args) {
		Flower flower = new Flower();
		flower.eat("õ��", "�Լ��ĸ��ͻ�Ҷ");
		flower.sleep();
	}

	public void sleep() {
		System.out.println("���ǻ�����˯��......");
	}

	public void eat(String name, String food) {
		System.out.println(name+"��ϲ����"+food);
	}
}