import java.util.Scanner;

public class Main_2018 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;		
		int tempN = N;
		
		while(tempN > 0) {
			int sum = 0;
			for(int t = tempN; t>0; t--) {
				sum+=t;
				if(sum >= N) {
					if(sum==N)
						count++;
					break;
				}
			}	
			tempN--;
		}
		
		System.out.println(count);
		
	}
}
