package day02Practice;

import java.util.Scanner;

public class Demo3 {

	/**
	 * ����1��9��������������Լ��������ֵ�ת���ַ������
	 * @param args
	 */
		public static void main(String[] args) {
			System.out.println("���������֣�");
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
	        			//�������ڵھ���֮�����һ���������ַ���ת���ͼ������
	        			char s= (char) (i+55);
	        			System.out.print(s);
	        		}
	            }
	        	System.out.println();
	        }
	        //ɨ�����Ĺر�
	        input.close();
		}
}