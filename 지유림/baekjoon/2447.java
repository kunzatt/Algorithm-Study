import java.io.*;
import java.util.*;

public class Main2447_별찍기10 {
    static int N;
    static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        star = new char[N][N];

        makeStar(0, 0, N, false);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    // flag == true : 공백
    static void makeStar(int r, int c, int num, boolean flag) {

        if(flag) {
            for(int i = r; i < r+num; i++) {
                for(int j = c; j < c+num; j++) {
                    star[i][j] = ' ';
                }
            }

            return;
        }

        if(num == 1) {
            star[r][c] = '*';
            return;
        }

        // N = 27이면 한 블록 사이즈 9
        // N = 9면 한 블록 사이즈 3

        int size = num/3;
        int count = 0;  // 현재 채울 영역 구분하기
        for(int i = r; i < r+num; i+=size) {
            for(int j = c; j < c+num; j+=size) {
                count++;
                if(count == 5) {    // 공백 칸이면
                    makeStar(i, j, size,true);
                } else {
                    makeStar(i, j, size,false);
                }
            }
        }
    }
}
