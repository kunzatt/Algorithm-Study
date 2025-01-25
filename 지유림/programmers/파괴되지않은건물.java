import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {

        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] sum = new int[N+1][M+1];
        
        for(int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if(type == 1) {
                sum[r1][c1] -= degree;
                sum[r2+1][c1] += degree;
                sum[r1][c2+1] += degree;
                sum[r2+1][c2+1] -= degree;
            } else {
                sum[r1][c1] += degree;
                sum[r2+1][c1] -= degree;
                sum[r1][c2+1] -= degree;
                sum[r2+1][c2+1] += degree;
            }
        }
    
        
        
        for(int i = 0; i < N+1; i++) {
            int result = 0;
            for(int j = 0; j < M+1; j++) {
                result += sum[i][j];
                sum[i][j] = result;
            }
        }
        
        for(int i = 0; i < M; i++) {
            int result = 0;
            for(int j = 0; j < N; j++) {
                result += sum[j][i];
                sum[j][i] = result;
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(sum[i][j] + board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}
