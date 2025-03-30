package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11723_집합 {
	
	static int M, S, num;

	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());        
        S = 0;
        
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    S |= (1 << (num - 1));
                    break;                    
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    S &= ~(1 << (num - 1));
                    break;                   
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((S & (1 << (num - 1))) != 0 ? 1 : 0).append('\n');
                    break;                   
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    S ^= (1 << (num - 1));
                    break;                   
                case "all":
                    S = (1 << 20) - 1;
                    break;                   
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.print(sb);
    }

}
