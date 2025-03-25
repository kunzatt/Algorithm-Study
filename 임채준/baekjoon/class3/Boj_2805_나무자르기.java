package class3;

import java.io.*;
import java.util.*;

public class Boj_2805_나무자르기 {
	
	static int N, M, max;
	static long start, end, ans;
	static int[] trees;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        max = 0;
        
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        
        start = 0;
        end = max;
        ans = 0;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            
            for(int tree : trees) {
                if(tree > mid) {
                    sum += (tree - mid);
                }
            }
            
            if(sum < M) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        
        System.out.println(ans);
    }
}