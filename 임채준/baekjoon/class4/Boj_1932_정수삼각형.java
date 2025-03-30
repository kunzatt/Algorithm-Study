package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1932_정수삼각형 {

    static int N, temp;
    static int[][] map;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        temp = 1;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < temp; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            temp++;
        }

        temp = N - 1;
        for(int i = N - 2; i >= 0; i--){
            for(int j = 0; j < temp; j++){
                int cur = map[i][j];
                int left = map[i + 1][j];
                int right = map[i + 1][j + 1];
                map[i][j] = Math.max(cur + left, cur + right);
            }
            temp--;
        }

        System.out.println(map[0][0]);

    }

}
