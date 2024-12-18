import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14719_빗물 {
	static int H, W;
	static int[] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		

		
		int result = 0;
		
		// 현재 위치가 왼쪽 & 오른쪽 보다 낮아야 빗물이 담길 수 있음
		// 왼쪽에서 가장 큰거에서 멈춰있기...
		// 맨 첫번째, 마지막이 0일 때는 X 
		
		for(int i = 1; i < W-1; i++) {
			
			int first = 0;
			int last = 0;
			
			// 처음부터 시작해서 가장 큰 값 찾기
			for(int j = 0; j < i; j++) {
				first = Math.max(first, map[j]);
			}
			
			// 마지막꺼에서 가장 큰 값 찾기
			for(int j = i+1; j < W; j++) {
				last = Math.max(last, map[j]);
			}
			
			// 현재 위치가 처음이랑 마지막보다 작을 때
			if(map[i] < first && map[i] < last) {
				// first or last보다 작은거에서 현재 높이 빼기
				result += Math.min(first, last) - map[i];
			}
			
		}
		
		System.out.println(result);
	}
}
