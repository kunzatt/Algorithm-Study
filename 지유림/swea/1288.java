import java.io.*;
import java.util.*;

public class Solution1288_새로운불면증치료법 {
    static int T, N;
    static String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static HashSet<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            set = new HashSet<>();

            boolean flag = false;
            int k = 1;
            while(true) {
                String str = String.valueOf(N*k);
                for(int i = 0; i < str.length(); i++) {
                    set.add(String.valueOf(str.charAt(i)));
                }
                k++;
                if(Arrays.equals(nums, set.toArray())) {
                    break;
                }
            }

            sb.append("#" + t + " " + N*(k-1) + "\n");
        }

        System.out.println(sb.toString());
    }
}
