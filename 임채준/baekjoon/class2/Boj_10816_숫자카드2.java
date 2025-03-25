package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10816_숫자카드2 {
	
	static int N, M;
	static int[] nums;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(nums, target) - lowerBound(nums, target)).append(" ");
        }
        
        System.out.println(sb);
    }
    
    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}