package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2775 {
	
	static int T, k, n;
	static int[][] apt;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine()); 
            n = Integer.parseInt(br.readLine());
            apt = new int[k + 1][n + 1];
            
            for(int j = 1; j <= n; j++) {
                apt[0][j] = j;
            }
            
            for(int floor = 1; floor <= k; floor++) {
                for(int room = 1; room <= n; room++) {
                    int sum = 0;
                    for(int l = 1; l <= room; l++) {
                        sum += apt[floor-1][l];
                    }
                    apt[floor][room] = sum;
                }
            }
 
            System.out.println(apt[k][n]);
        }
    }
}