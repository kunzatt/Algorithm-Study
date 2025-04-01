import java.util.*;
import java.io.*;

class Main_12891 {
    static int S, P, a, c, g, t;
    static int[] base, cnt;
    static String dna; 
    static int ans;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        P = sc.nextInt();
        dna = sc.next();
        base = new int[4];
        cnt = new int[4];
        ans = 0;
        
        for(int i=0; i<4; i++){
            base[i] = sc.nextInt();
        }

        for(int i=0; i<P; i++){
        	char c = dna.charAt(i);
        	if(c == 'A') cnt[0]++;
        	if(c == 'C') cnt[1]++;
        	if(c == 'G') cnt[2]++;
        	if(c == 'T') cnt[3]++;
        }
        if(check()) ans++;
        
        for(int i=1; i+P-1<S; i++) {
            // 빠지는 문자
            char out = dna.charAt(i-1);
            if(out == 'A') cnt[0]--;
            if(out == 'C') cnt[1]--;
            if(out == 'G') cnt[2]--;
            if(out == 'T') cnt[3]--;

            // 새로 추가되는 문자
            char in = dna.charAt(i+P-1);
            if(in == 'A') cnt[0]++;
            if(in == 'C') cnt[1]++;
            if(in == 'G') cnt[2]++;
            if(in == 'T') cnt[3]++;

            if(check()) ans++;
        }
        System.out.println(ans);
        }

	private static boolean check() {
		for(int i=0; i<4; i++) {
			if(base[i] > cnt[i]) return false;
		}
		return true;
	}
}
