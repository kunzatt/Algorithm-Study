import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1417 {
	
	static int max;
	static int maxIdx;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];		
		int count = 0;
				
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}		
		
		while (true) {
			max = 0;
			maxIdx = 0;
			for (int i = 0; i < n; i++) {
				if(max <= arr[i]) {
					max = arr[i];
					maxIdx = i;
				}
					
			}
			if (maxIdx == 0) {
				break;
			}
			arr[maxIdx]--;
			arr[0]++;
			count++;
			
		}
//		for (int i = 0; i < n; i++) {
//			if(max < arr[i]) {
//				max = arr[i];
//			}			
//		}
//		for (int i = 1; i < n; i++) {
//			if(arr[0] >= max && arr[0] != arr[i]) {
//				break;
//			}
//			if(arr[0] != max || (arr[0] == max && arr[i] == max) || arr[0] == arr[i]) {
//					arr[i]--;
//					arr[0]++;
//					max = -1;
//					for (int h = 0; h < n; h++) {
//						if(max < arr[h]) {
//							max = arr[h];
//						}			
//					}
//					count++;
//			}
//			if (n == 1) {
//				count = 0;
//			}
//		}		
		System.out.println(count);
	}
}
