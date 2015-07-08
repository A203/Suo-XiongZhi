package day02Practice;

import java.util.Scanner;

public class Demo3 {

	/**
	 * 进行1到9的数字三角输出以及后面数字的转换字符的输出
	 * @param args
	 */
		public static void main(String[] args) {
			System.out.println("请输入数字：");
			Scanner input=new Scanner(System.in);
	        int num=input.nextInt();
	        for (int i=1;i<=num ;i++){
	        	for(int j=1;j<=num-i;j++){
	        		System.out.print(" ");
	        	}
	        	for (int j=1;j<=2*i-1;j++){
	        		if(i<=9){
	        			System.out.print(i);
	        		}else{
	        			//当行数在第九行之后进行一个数字与字符的转换和继续输出
	        			char s= (char) (i+55);
	        			System.out.print(s);
	        		}
	            }
	        	System.out.println();
	        }
	        //扫描器的关闭
	        input.close();
		}
}