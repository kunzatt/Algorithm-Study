package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class 창고다각형2304 {
	static int N; // 기둥 개수
	static int[] L, H, map; // 위치, 높이
	static int sum, max, maxL, maxH, maxIdx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		L = new int[N];
		H = new int[N];
		map = new int[1001];
		maxL = 0;
		maxH = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a] = b;
			if(maxH < b) {
				maxH = b;
				maxL = a;
			}
		} // 입력
		// 연산
		int tmp = 0;
		int sum = 0;
		for(int i = 0; i <= maxL; i++) {
			if(map[i] != 0 && map[i] > tmp) {
				tmp = map[i];
			}
			sum += tmp;
		}
		tmp = 0;
		for(int i = map.length-1; i > maxL; i--) {
			if(map[i] != 0 && map[i] > tmp) {
				tmp = map[i];
			}
			sum += tmp;
		}

		System.out.println(sum);
	}
}
