package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_우물안개구리 {
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] w = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer>[] friends = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            friends[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }
        
        int ans = 0;
        
        for(int i = 1; i <= n; i++) {
            if(friends[i].isEmpty()) {
                ans++;
                continue;
            }
            
            boolean best = true;
            for(int friend : friends[i]) {
                if(w[i] <= w[friend]) {
                    best = false;
                    break;
                }
            }
            
            if(best) {
                ans++;
            }
        }
        
        System.out.println(ans);
    }
}