package day03Practice;

import zuoYe.Plant;

	class Tree extends Plant{
		
		public void sleep() {
			System.out.println("����������˯��");
		}
		
		public static void main(String[] args) {
			Tree tree = new Tree();
			tree.sleep();
			tree.eat("����", "����");
		}

		public void eat(String nameString,String food) {
			Tree tree = new Tree();
			tree.name = "����";
			tree.food = "����";
			System.err.println("?????");
			System.out.println(nameString+"��ϲ����"+food);
			System.out.println(tree.name+"��"+tree.food);
		}
		
	}