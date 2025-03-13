package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_11101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();
        Map<String,Integer> time=new HashMap<>();
        while(T-->0){
            String[] s=sc.nextLine().split(",");
            for(int i=0;i<s.length;i++){
                String[] ss=s[i].split(":");
                time.put(ss[0], Integer.parseInt(ss[1]));
            }
            String[] conditions=sc.nextLine().split("\\|");
            int minTime=Integer.MAX_VALUE;
            for(int i=0;i<conditions.length;i++){
                String[] condition=conditions[i].split("&");
                int t=0;
                for(int j=0;j<condition.length;j++){
                    t=Math.max(t,time.get(condition[j]));
                }
                minTime=Math.min(minTime,t);
            }
            System.out.println(minTime);
        }
    }
}
