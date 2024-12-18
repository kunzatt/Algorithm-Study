import java.io.BufferedReader;
import java.io.InputStreamReader;
 
 
public class Solution {
    static int T, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        T = Integer.parseInt(br.readLine());
         
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
             
            // N의 최대 수가 10밖에 안되니까 2차원배열
            int[][] pascal = new int[N][N];
             
            for(int r = 0; r < N; r++) {
                pascal[r][0] = 1;
                pascal[r][r] = 1;
                for(int c = 0; c < r; c++) {
                    pascal[r][c+1] = pascal[r-1][c] + pascal[r-1][c+1];
                }
            }
             
            System.out.println("#" + t);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < i+1; j++) {
                    System.out.print(pascal[i][j] + " ");
                }
                System.out.println();
            }
             
        }
         
         
    }
}
