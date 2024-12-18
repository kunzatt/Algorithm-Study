import java.util.Scanner;

public class Main_1417 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt=0;
		int maxidx = -1;
		int max=-1;
		while(true) {
			max = -1;
			maxidx = -1;
			
			for(int i=0; i<N;i++) {
				if(max <= arr[i]) {
					max = arr[i];
					maxidx = i;
				}
			}
			
			if(maxidx == 0)
				break;
			
			arr[maxidx]--;
			arr[0]++;
			cnt++;
			

		}
		
		System.out.println(cnt);
		
	}
}

