import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1911 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] road = new int[N][2];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(road, (a,b) -> a[0]-b[0]);
        
        int ans = 0;
        int idx = 0;
        
        for (int i = 0; i < N; i++) {
			int left = road[i][0];
			int right = road[i][1];
			
			while (idx < right) {
				if (left <= idx) {
					idx += L;
					ans++;
				} else {
					idx++;
				}
			}
		}
        
        System.out.println(ans);
        
    }
    
}
