import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3991 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        int[] input = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        int currentNum = 1;
        int remain = input[currentNum];
        
        for (int i = 0; i < r; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < c; j++) {
                    map[i][j] = currentNum;
                    remain--;
                    
                    if (remain == 0 && currentNum < n) {
                        currentNum++;
                        remain = input[currentNum];
                    }
                }
            } else {
                for (int j = c - 1; j >= 0; j--) {
                    map[i][j] = currentNum;
                    remain--;
                    
                    if (remain == 0 && currentNum < n) {
                        currentNum++;
                        remain = input[currentNum];
                    }
                }
            }
            
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}