import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	static int N, M, o, ans = 0, known = 0;
	static char x;
	static int[] wordsMask;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wordsMask = new int[N];
        // N개의 단어 -> 비트마스킹으로 저장
        for(int i=0; i<N; i++) {
        	String S = br.readLine();
        	int mask = 0;
        	for(int j=0; j<S.length(); j++) {
        		char c = S.charAt(j);
        		mask |= (1 << (c-'a'));
        	}
        	known |= mask;
        	wordsMask[i] = mask;
        }
        
        for(int j=0; j<M; j++) {
        	st = new StringTokenizer(br.readLine());
        	o = Integer.parseInt(st.nextToken());
        	x = st.nextToken().charAt(0);
    		int bit = (1 << (x-'a'));
        	if(o == 1 && !isVowel()) {
        		// 잊는다.
        		known &= ~bit;
        	}else {
        		// 기억한다
        		known |= bit;
        	}
        	ans = 0;
        	for(int mask : wordsMask) {
        		if(mask == (known & mask)) {
        			ans++;
        		}
        	}
        	
        	System.out.println(ans);
        }
        
    }

	public static boolean isVowel() {
		return (x == 'a' || x == 'e' || x == 'o' || x == 'i' || x == 'u');
	}

}
