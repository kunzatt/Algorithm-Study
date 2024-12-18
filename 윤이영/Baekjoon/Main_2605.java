import java.util.ArrayList;
import java.util.Scanner;

public class Main_2605 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			int s = sc.nextInt();
			
			if(s == 0) {
				arr.add(i);
			}
			else {
				arr.add(s,i);
			}
			//System.out.println(arr.toString());
		}
		
		for(int i=arr.size()-1; i>=0; i--) {
			System.out.print(arr.get(i)+" ");
		}

		
	}
}
