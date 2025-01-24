import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2110 {

	static int N, C;
	static List<Integer> port;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		port = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			port.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(port);
		
		int left = 1; // 공유기 간 최소 거리
		int right = port.get(N-1)-port.get(0)+1; // 공유기 간 최대 거리
		
		while (left < right) {
			int mid = (left+right)/2;
			
			// 공유기의 수가 M보다 작으면 최소거리를 줄임
			if (install(mid) < C) {
				right = mid;
			} else {
				left = mid+1;
			}
		}
		
		System.out.println(left-1);
		
	}

	private static int install(int mid) {
		int cnt = 1;
		int start = port.get(0); // 공유기 설치 시작점
		
		for (int i = 1; i < N; i++) {
			int end = port.get(i); // 공유기 설치 마지막점
			
			// 두 공유기 간의 거리가 최소 거리를 넘겼다면
			// 마지막 공유기로부터 다시 거리 카운트
			if (end - start >= mid) {
				cnt++;
				start = end; // 
			}
		}
		
		return cnt;
	}

	

}
