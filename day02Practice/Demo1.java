package day02Practice;

import java.util.Scanner;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ոݔ��W���ČW���ɿ���");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		if(score>=100||score<=0)
		{
			ouput("Error");
		}
		else if (score>=90) {
			ouput("ԓͬ�W�ČW���ɿ���A��");
		}
		else if (score>=60&&score<=90) {
			ouput("ԓͬ�W�W���ɿ���B��");
		}
		else {
			ouput("ԓ��r��������r");
		}
		scanner.close();
	}
	public static void ouput(String s) {
		System.out.println(s);
	}

}
