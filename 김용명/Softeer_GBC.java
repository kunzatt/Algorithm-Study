import java.io.*;
import java.util.*;

public class Softeer_GBC {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sspeed = new int[101];
        int height = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int theight = Integer.parseInt(st.nextToken());
            int tspeed = Integer.parseInt(st.nextToken());
            for (int j = height; j < height + theight; j++) {
                sspeed[j] = tspeed;
            }
            height += theight;
        }

        int[] mspeed = new int[101];
        height = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int theight = Integer.parseInt(st.nextToken());
            int tspeed = Integer.parseInt(st.nextToken());
            for (int j = height; j < height + theight; j++) {
                mspeed[j] = tspeed;
            }
            height += theight;
        }

        int max = 0;
        for (int i = 0; i < 101; i++) {
            max = Math.max(max, mspeed[i] - sspeed[i]);
        }

        System.out.println(max);

    }
}