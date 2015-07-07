package day02;

public class Demo15 {

	/**
	 * @param args
	 */
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
