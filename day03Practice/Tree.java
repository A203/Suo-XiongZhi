package day03Practice;

import zuoYe.Plant;

	class Tree extends Plant{
		
		public void sleep() {
			System.out.println("这是树们在睡觉");
		}
		
		public static void main(String[] args) {
			Tree tree = new Tree();
			tree.sleep();
			tree.eat("杨柳", "树根");
		}

		public void eat(String nameString,String food) {
			Tree tree = new Tree();
			tree.name = "杨柳";
			tree.food = "树根";
			System.err.println("?????");
			System.out.println(nameString+"最喜欢吃"+food);
			System.out.println(tree.name+"和"+tree.food);
		}
		
	}