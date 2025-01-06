import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M;
    static int[] tree;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new int[N];
		
		int min = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			if(max < tree[i]) {    // 나무 중 최대값 구하기
				max = tree[i];
			}
		}
		
		// 이분 탐색 
		while(min < max) {
			
			int mid = (min + max) / 2;
			long sum = 0;
            
            // 트리 잘린 길이 합 구하기
            for(int i = 0; i < tree.length; i++) {
                if(tree[i] - mid > 0) {
                    sum += (tree[i] - mid);
                }
            }

            // M보다 높으면 자르는 위치가 높은거 -> 높이 줄이기
			if(sum < M) {
				max = mid;
			}
            // M보다 크면 높이가 낮은거 -> 높이 올리기
			else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
		
	}
}
