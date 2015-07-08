package day02Practice;

import java.util.Scanner;

public class Demo6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入乘法表的行数：");
		Scanner inputScanner = new Scanner(System.in);
		int input = inputScanner.nextInt();
		//i表示输入的行数递增变化的量
		for(int i=1;i<input;i++){
		//j表示对应的i值个数
			for(int j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
			System.out.println(" ");
		}
		//最后进行扫描器的关闭管理
		inputScanner.close();
	}

}
