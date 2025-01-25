import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_10425 {
    
	static int T, N;
	static BigInteger Fn;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        N = 100000;
        
        BigInteger[] fib = new BigInteger[N+1];
        
        fib[0] = new BigInteger("0");
        fib[1] = new BigInteger("1");
        
        for (int i = 2; i <= N; i++) {
			fib[i] = fib[i-1].add(fib[i-2]);
		}
        
        for (int t = 0; t < T; t++) {
        	Fn = new BigInteger(br.readLine());
        	
        	int lo = 1;
        	int hi = N;
        	while (lo <= hi) {
        		int mid = (lo+hi)/2;
        		
        		if (fib[mid].compareTo(Fn)==0) {
        			System.out.println(mid);
        			break;
        		}
        		
        		if (fib[mid].compareTo(Fn)==1) {
        			hi = mid;
        		} else {
        			lo = mid+1;
        		}
        	}
		}
        
        
    }

}
