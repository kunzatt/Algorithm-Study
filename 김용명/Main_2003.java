import java.io.*;
import java.util.*;

public class Main_2003 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int sum = 0, s = 0, e = 0;
		
		while(true) {
			if(sum >= M) {
				sum -= arr[s++];	// M보다 sum이 클 경우 시작 포인트를 오른쪽으로 1씩 옮기면서 합을 구한다.
			}else if(e == N) break;
			else {
				sum += arr[e++];	// 오른쪽 포인터를 1씩 옮기면서 합을 구한다.
			}
			if(sum == M) {
				count++;
			}
			
		}
		
		System.out.println(count);

	}

}
