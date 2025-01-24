import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_23322 {
    
	static int N, K;
	static int[] arr;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        
        int min = 2000;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, arr[i]);
		}
        
        Arrays.sort(arr);
        
        int cnt = 0;
        int eat = 0;
        
        for (int i = 0; i < N; i++) {
			if (arr[i] > min) {
				eat += arr[i]-min;
				cnt++;
			}
		}
        
        System.out.println(eat+" "+cnt);
        
    }

}
