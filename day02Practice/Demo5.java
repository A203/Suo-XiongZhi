package day02Practice;

//while 和 do while循环的使用
public class Demo5 {

	/**
	 * @param args
	 *找到1到99的所有能被5整除的整数
	 */
	public static void main(String[] args) {
		
		//for method
//		for(int i=1;i<=99;i++){
//			if(i%5 == 0)
//			System.out.println(i);
//		}
		
		//while method
//		int i = 1;
//		while(i<=99){
//			if(i%5==0){
//				System.out.println(i);
//			}
//			i++;
//		}
		//do-while method

		for(int i=1;i<=10;i++){
			for(int j=2;j<i;)
			{
				if(i%j==0){
					continue;
				}
			}
			System.out.println(i);
		}
	}

}
