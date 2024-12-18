import java.util.Scanner;

public class Main_14916 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		int count = 0;		
		
		while(money>0) {
			if(money%5 == 0) {
				count++;
				money-=5;
			}
			else {
				money-=2;
				count++;
			}
			
			if(money<0) {
				count=-1;
				break;
			}
		}
		
		System.out.println(count);
		
	}
}
