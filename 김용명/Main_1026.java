import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1026 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] aarr = new int[N];
        Integer[] barr = new Integer[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            aarr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            barr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(aarr);
        Arrays.sort(barr, Comparator.reverseOrder());
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += aarr[i] * barr[i];
        }
        
        System.out.println(ans);
        
    }
}
