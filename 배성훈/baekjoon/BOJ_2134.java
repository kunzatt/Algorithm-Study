import java.io.*;
import java.util.StringTokenizer;

// 2134. 창고 이전 / 실버4 / 43분
// 그리디 구현
// 문제가 굉장히 불친절해서 테스트 케이스 생각하는 시간이 더 걸린 문제
public class BOJ_2134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long count = 0;
        long cost = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] oldCon = new int[n + 1];
        int[] newCon = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            oldCon[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= m; i++) {
            newCon[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (oldCon[i] == 0) break;
                if (newCon[j] == 0) continue;
                int temp = oldCon[i] - newCon[j];
                if (temp < 0) {
                    count += oldCon[i];
                    cost += i * (long) oldCon[i];
                    cost += j * (long) oldCon[i];
                    oldCon[i] = 0;
                    newCon[j] = Math.abs(temp);
                    break;
                } else {
                    count += newCon[j];
                    cost += i * (long) newCon[j];
                    cost += j * (long) newCon[j];
                    oldCon[i] = Math.abs(temp);
                    newCon[j] = 0;
                }
            }
        }
        System.out.println(count + " " + cost);
    }
}