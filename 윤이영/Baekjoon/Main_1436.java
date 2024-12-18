import java.util.Scanner;

public class Main_1436 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int num = 666;
		
		while(true) {
			String check = Integer.toString(num);
			if(check.contains("666")) {
				cnt++;
			}
			if(cnt == N) {
				break;
			}
			num++;
		}
		System.out.println(num);
	}
	
	
	
	
}