package day02Practice;

public class Demo7 {

	/**
	 * @param arg
	 */
	
	//������Ĵ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		for(int i=2;i<=100;i++)
			for(int j=2;j<i;j++){
				if(i%j==0){
					num++;
				}
				System.out.println(num);
			}
	}

}
