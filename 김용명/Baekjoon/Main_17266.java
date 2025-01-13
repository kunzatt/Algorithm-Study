import java.io.*;
import java.util.*;

public class Main_17266 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] lights = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(N, lights));
    }

    static int binarySearch(int N, int[] lights) {
        int left = 1, right = N;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(canCover(N, lights, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean canCover(int N, int[] lights, int height) {
        int covered = 0;

        for(int pos : lights) {
            if(pos - height > covered) return false;
            covered = pos + height;
        }

        return covered >= N;
    }
}