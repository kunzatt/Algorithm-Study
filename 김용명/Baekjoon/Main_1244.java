import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		int[] arr = new int[s];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < s; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(h == 1) {
				for (int j = 0; j < s; j++) {
					if((j+1) % num == 0) {
						arr[j] = (arr[j] == 0? 1 : 0);
					}
				}			
			}			
			else {
				arr[num - 1] = (arr[num - 1] == 0 ? 1 : 0);
				
				for(int j=1; j<s/2; j++) {					
					if(num - 1 + j >= s || num - 1 - j < 0)
						break;
					if(arr[num - 1 - j] == arr[num - 1 + j]) {
						arr[num - 1 - j] = (arr[num - 1 - j] == 0 ? 1 : 0);
						arr[num - 1 + j] = (arr[num - 1 + j] == 0 ? 1 : 0);
					}
					else break;
				}
			}
		}
		for (int i = 0; i < s; i++) {
			System.out.print(arr[i] + " ");
			if((i+1)%20 == 0) {
				System.out.println();
			}
		}
	}
}
