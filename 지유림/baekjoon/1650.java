import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11650_좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] xy = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());   // x
            xy[i][1] = Integer.parseInt(st.nextToken());   // y
        }

        Arrays.sort(xy, (x1, x2) -> {
           if(x1[0] == x2[0]) return x1[1] - x2[1]; // x가 같으면 y값 비교
           else return x1[0] - x2[0];
        });

        for(int i = 0; i < N; i++) {
            System.out.println(xy[i][0] + " " + xy[i][1]);
        }
    }
}
