
public class Main_4673 {
	static int D = 10000;
	public static void main(String[] args) {
		int arr[] = new int[D+1];
		for(int i=1; i<=D; i++) {
			if(arr[i] != 0)
				continue;
			int n = i;
			while(n <= D) {
				int temp = n;
				while(temp != 0) {
					n += temp%10;
					temp/=10;
				}
				if(n > D)
					continue;
				arr[n]++;
			}

		}
		
		for(int i=1; i<=D; i++) {
			if(arr[i] == 0)
				System.out.println(i);
		}
		
	}
	
	
}
