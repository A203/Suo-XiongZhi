package day02Practice;

import java.util.Scanner;

public class Demo6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������˷����������");
		Scanner inputScanner = new Scanner(System.in);
		int input = inputScanner.nextInt();
		//i��ʾ��������������仯����
		for(int i=1;i<input;i++){
		//j��ʾ��Ӧ��iֵ����
			for(int j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
			System.out.println(" ");
		}
		//������ɨ�����Ĺرչ���
		inputScanner.close();
	}

}
