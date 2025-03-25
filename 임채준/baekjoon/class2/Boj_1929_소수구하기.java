package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1929_소수구하기 {
	
    static int N, M;
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb);
    }
}