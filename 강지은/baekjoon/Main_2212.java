import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212 {

	static int N, K;
	static int[] port, dist;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		port = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			port[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(port);
		
		dist = new int[N-1];
		for (int i = 1; i < N; i++) {
			dist[i-1] = port[i]-port[i-1];
		}
		
		Arrays.sort(dist);
		
		int sum=0;
		for (int i = 0; i < N-K; i++) {
			sum += dist[i];
		}
		
		System.out.println(sum);
		
	}	

}
