import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_23322 {
    static int N, K;
    static int[] arr;
    static int totalc = 0;
    static int minday = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[0]) {
                totalc += arr[i] - arr[0];
                minday++;
            }
        }

        System.out.println(totalc + " " + minday);
    }
}
