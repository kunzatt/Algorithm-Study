import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] cows;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cows = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cows, (a, b) -> Integer.compare(a[0], b[0]));
        
        int currentTime = 0; // 현재 시간
        
        for(int i = 0; i < N; i++) {
            int arrivalTime = cows[i][0]; // 소 도착시간
            int inspectionTime = cows[i][1]; // 소 검문시간
            
            if(currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }
            
            currentTime += inspectionTime;
        }
        
        System.out.println(currentTime);
    }
}
