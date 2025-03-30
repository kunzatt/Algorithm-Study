package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018_체스판다시칠하기 {
	
	static int N, M, count, min;
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        
        min = Integer.MAX_VALUE;
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                int count = cal(board, i, j);
                min = Math.min(min, count);
            }
        }
        
        System.out.println(min);
    }
    
    private static int cal(char[][] board, int sr, int sc) {
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                char current = board[sr + i][sc + j];
                
                if((i + j) % 2 == 0) {
                    if(current != 'W') count1++;
                    if(current != 'B') count2++;
                } else {
                    if(current != 'B') count1++;
                    if(current != 'W') count2++;
                }
            }
        }
        
        return Math.min(count1, count2);
    }

}
