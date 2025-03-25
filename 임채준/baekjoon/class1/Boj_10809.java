package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10809 {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] nums = new int[26];
        Arrays.fill(nums, -1);

        for(int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            if(nums[index] == -1) {
                nums[index] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb);
    }
}