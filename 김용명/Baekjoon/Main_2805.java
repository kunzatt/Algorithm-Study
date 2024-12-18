import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        
        long start = 0;
        long end = max;
        long ans = 0;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            
            for (int tree : arr) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }
            
            if (sum >= K) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        
        System.out.println(ans);
    }
}
