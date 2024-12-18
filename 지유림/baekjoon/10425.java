import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static int N, T;
	static BigInteger[] fibo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		fibo = new BigInteger[100001];
		
		fibo[0] = new BigInteger("0");
		fibo[1] = new BigInteger("1");
		
		for(int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
		
		for(int i = 0; i < N; i++ ) {
			BigInteger num = new BigInteger(br.readLine());
			sb.append(bs(num, 0, fibo.length-1) + "\n");
		}
		System.out.println(sb.toString());
		
		
	}
	
	static int bs(BigInteger key, int left, int right) {
		int mid;
		
		if(left <= right) {
			mid = (left + right) / 2;
			
			if(key.compareTo(fibo[mid]) == 0) {
				return mid;
			} else if(key.compareTo(fibo[mid]) == -1) {
				return bs(key, left, mid-1);
			} else {
				return bs(key, mid+1, right);
			}
		}
		
		return -1;
		
	}
}
