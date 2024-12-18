import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int T, N, M;
    static char[][] flagColor;
    static int minColor;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        T = Integer.parseInt(br.readLine());
         
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            minColor = 100000;
             
            // 깃발 색상
            // 0 - 흰색
            // 1 - 파랑
            // 2 - 빨강
            flagColor = new char[N][3];
             
            // 각 줄에 흰색과 파랑, 빨강이 몇개씩 있는지 확인
            for(int i = 0; i < N; i++) {
                String s = br.readLine();
                for(int j = 0; j < s.length(); j++) {
                    if(s.charAt(j) == 'W') {
                        flagColor[i][0]++;
                    } else if(s.charAt(j) == 'B') {
                        flagColor[i][1]++;
                    } else {
                        flagColor[i][2]++;
                    }
                }
            }
 
            backtracking(1, 0, (M - flagColor[0][0]) + (M - flagColor[N-1][2]));
             
            System.out.println("#" + t + " " + minColor);
 
        }
    }
 
 
    // color가 0 : 흰색
    // 1 : 파랑
    // 2 : 빨강
    static int count = 0;
    static void backtracking(int cnt, int color, int sum) {
         
        if(cnt == N-1) {
            minColor = Math.min(minColor, sum);     
            return;
        }
         
         
        // 전에 깃발 색이 흰색이고, N-2 값보다는 작을 때 => 흰색 칠하기
        if(cnt < (N-2) && color == 0) {
            backtracking(cnt+1, 0, sum + (M - flagColor[cnt][0]));
        }
         
        // 전에 깃발 색이 흰색이거나, 파랑이면 -> 파랑 칠할 수 있음! 
        if(color == 0 || color == 1) {
            backtracking(cnt+1, 1, sum + (M -flagColor[cnt][1]));
        }
         
        // 전에 깃발 색이 레드일 때 => 레드만
        if(color == 1|| color == 2) {
            backtracking(cnt+1, 2, sum + (M - flagColor[cnt][2]));
        }
         
    }
}
