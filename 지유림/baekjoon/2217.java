import java.io.*;
import java.util.*;

public class Main2217_로프 {
    static int N;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        for(int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weight);
        int result = 0;
        for(int i = 0; i < N; i++) {
            result = Math.max(result, weight[i] * (N-i));
        }
        System.out.println(result);
    }
}
