package algol0805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_21921 {
	
	static int N; // 블로그 시작한 전체 일자
	static int X; // 원하는 기간
	static int[] map;
	static int[] sum_map;
	static int max;
	static int cnt;
	static int sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		map = new int[N];
		cnt=1;
		sum=0;

		// 입력
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		// 최대값 탐색
		for(int i = 0; i < X; i++) {
			sum += map[i];
		}
		max = sum;
		
		for(int i = 1; i < N-X+1; i++) {
			sum = sum - map[i-1] + map[i+X-1];
			if(max < sum) {
				max = sum;
				cnt = 1;
			} else if( max == sum) {
				cnt++;
			}
			
		}
		if (max == 0) {
			bw.write("SAD\n");
		}else {
			bw.write(Integer.toString(max) + "\n");
			bw.write(Integer.toString(cnt));
			
			
		}
		bw.flush();
		bw.close();
	}
}
