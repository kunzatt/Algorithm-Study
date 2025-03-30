package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_7568_덩치 {
	
	static int N, rank;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            rank = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(map[i][0] < map[j][0] && map[i][1] < map[j][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }       
        System.out.println(sb);
    }

}
