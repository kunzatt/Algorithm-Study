package class3;

import java.io.*;

public class Boj_17626_FourSquares {
	
	static int n, sqrt;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(mins(n));
    }
    
    public static int mins(int n) {

        if (iss(n)) return 1;
        
        for (int i = 1; i * i <= n; i++) {
            if (iss(n - i * i)) return 2;
        }

        for (int i = 1; i * i <= n; i++) {
            for (int j = 1; j * j <= n - i * i; j++) {
                if (iss(n - i * i - j * j)) return 3;
            }
        }

        return 4;
    }
    
    private static boolean iss(int n) {
        sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}