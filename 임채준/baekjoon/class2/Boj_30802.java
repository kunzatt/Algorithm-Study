package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_30802 {
	
	static int N, T, P, tn, pn, pm;
	static int[] size;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = new int[6];
        for(int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        tn = 0;
        for(int size : size) {
            tn += (size + T - 1) / T;
        }
        
        pn = N / P;
        pm = N % P;

        System.out.println(tn);
        System.out.println(pn + " " + pm);
    }
}