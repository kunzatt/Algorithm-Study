import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] kg = new int[N];
        int[] cm = new int[N];
        int[] rank = new int[N];
        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            kg[n] = Integer.parseInt(st.nextToken());
            cm[n] = Integer.parseInt(st.nextToken());
            int count = 1;

            for(int i = 0; i < rank.length; i++) {
                if(i == n) continue;

                if(kg[i] > kg[n] && cm[i] > cm[n]) {
                    count++;
                } else if(kg[i] < kg[n] && cm[i] < cm[n]) {
                    rank[i]++;
                }
            }

            rank[n] = count;
        }


        for(int i = 0; i < rank.length; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}
