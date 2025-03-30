package noclass;

import java.io.*;
import java.util.*;

public class Boj_1446_지름길 {
	
	static int N, D;
	static int[] dist;
	static class Shortcut {
	    int start, end, length;
	    public Shortcut(int start, int end, int length) {
	        this.start = start;
	        this.end = end;
	        this.length = length;
	    }
	}
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	D = Integer.parseInt(st.nextToken());
        List<Shortcut> shortcuts = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            
            if (end <= D && end - start > length) {
                shortcuts.add(new Shortcut(start, end, length));
            }
        }
        
        dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        for (int i = 0; i <= D; i++) {
            if (i > 0) dist[i] = Math.min(dist[i], dist[i - 1] + 1);
            
            for (Shortcut s : shortcuts) {
                if (s.start == i && dist[i] + s.length < dist[s.end]) {
                    dist[s.end] = dist[i] + s.length;
                }
            }
        }
        
        System.out.println(dist[D]);
    }
}
