import java.io.*;
import java.util.*;

public class Main {

    // 마주보는 면의 인덱스
    static int[] opp = {5, 3, 4, 1, 2, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dice = new int[n][6];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++)
                dice[i][j] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0;

        // 첫번째 주사위의 아랫면을 모든 경우로 시도 (0~5)
        for(int bottom = 0; bottom < 6; bottom++) {
            int sum = 0;
            int bottomNum = dice[0][bottom];
            int topNum = dice[0][opp[bottom]];
            
            // 첫번째 주사위 옆면 최대값 누적
            sum += getMax(dice[0], bottomNum, topNum);

            // 두번째 주사위부터
            for(int i = 1; i < n; i++) {
                for(int j = 0; j < 6; j++) {
                    if(dice[i][j] == topNum) {
                        bottomNum = dice[i][j];
                        topNum = dice[i][opp[j]];
                        sum += getMax(dice[i], bottomNum, topNum);
                        break;
                    }
                }
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }

    static int getMax(int[] die, int bottomNum, int topNum) {
        int max = 0;
        for(int num : die) {
            if(num != bottomNum && num != topNum) 
                max = Math.max(max, num);
        }
        return max;
    }
}
