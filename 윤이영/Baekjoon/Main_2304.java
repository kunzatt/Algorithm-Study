import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2304 {
	static int N;
	static int L, H;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int maxidx=0;
		int maxh=0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			if(maxh < H) {
				maxidx = L;
				maxh = H;
			}
		}
		int area = maxh;	// 가장 높은 기둥을 더해주기
		int height = 0;
		int width = 0;
		// 가장 높은 기둥을 기준으로 반복문을 반으로 나눠서 풀이
		for(int i=0; i<maxidx; i++) {	
			if(height < arr[i])
				height = arr[i];
			area += height;
		}
		height = 0;
		for(int i= 1000; i>maxidx; i--) {
			if(height < arr[i])
				height = arr[i];
			area += height;
		}
		System.out.println(area);
	}
}
