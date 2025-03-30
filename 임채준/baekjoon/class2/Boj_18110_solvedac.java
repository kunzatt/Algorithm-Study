package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_18110_solvedac {
	
	static int N, sub, sum;
	static int[] nums;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        
        sub = (int) Math.round(N * 0.15);
        sum = 0;
        
        for(int i = sub; i < N-sub; i++) {
            sum += nums[i];
        }
        
        double avg = (double)sum / (N - 2*sub);
        System.out.println(Math.round(avg));
    }
}