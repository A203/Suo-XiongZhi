package day02Practice;

import java.util.Scanner;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("請輸入學生的學習成績：");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		if(score>=100||score<=0)
		{
			ouput("Error");
		}
		else if (score>=90) {
			ouput("該同學的學習成績為A級");
		}
		else if (score>=60&&score<=90) {
			ouput("該同學學習成績為B級");
		}
		else {
			ouput("該情況是其他情況");
		}
		scanner.close();
	}
	public static void ouput(String s) {
		System.out.println(s);
	}

}
