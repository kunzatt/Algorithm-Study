import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 모든 사람이 자신의 '가장' 왼쪽에 있는 햄버거부터 찾으며 햄버거를 먹는다.
 */

public class Main_19941 {
	static int N, K;
	static char[] arr;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		
		arr = br.readLine().toCharArray();
		
		for(int i=0; i<N;i++) {
			if(arr[i] == 'P') {
				boolean check = false;
				// 왼쪽부터 탐색
				for(int j=K; j>0; j--) {
					int idx = Math.max(0, i-j);	// 인덱스가 0보다 작아지는 것을 방지
					if(arr[idx] == 'H') {
						ans++;
						arr[idx] = 'X';
						check = true;
						break;
					}
				}
				// 오른쪽 탐색
				if(!check) {
					for(int j=1; j<=K; j++) {
						int idx = Math.min(i+j, N-1);	// 인덱스가 0보다 작아지는 것을 방지
						if(arr[idx] == 'H') {
							ans++;
							arr[idx] = 'X';
							check = true;
							break;
						}
					}
				}
			}
			//System.out.println(arr);
		}
		
		System.out.println(ans);
	}
}
