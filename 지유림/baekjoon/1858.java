import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1058_친구 {
    static int N;
    static char[][] friends;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                friends[i][j] = str.charAt(j);
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(friends[i][j] == 'Y') {
                    visited[i][j] = true;
                    for (int k = 0; k < N; k++) {
                        if (friends[j][k] == 'Y') {
                            visited[i][k] = true;
                        }
                    }
                }
            }
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(visited[i][j]) count++;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
