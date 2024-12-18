import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 27172. 수 나누기 게임 / 골드4 / 12:38~1:07
// a랑 b를 뽑는다
// b%a==0 이면 승리
// a%b==0 이면 패배
// 이외 무승부
// 승리 -> +1
// 패배 -> -1
// 브루트포스로 돌아보면 반드시 시간초과가 난다
// 소수 판정으로 쉽게 해결 가능하다.
// 각 카드의 배수들이 배열에 포함되어 있으면 해당 카드는 +1, 배수의 카드는 -1을 해주면 된다
// O(n * m) => m 은 가장 큰 카드 값까지의 범위
public class BOJ_27172 {
    static int[] card;
    static int[] score;
    static Map<Integer, Integer> map = new HashMap<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        card = new int[n];
        score = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, card[i]);
            max = Math.max(max, card[i]);
            map.put(card[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = card[i] * 2; j <= max; j += card[i]) {
                if (map.containsKey(j)) {
                    score[i]++;
                    score[map.get(j)]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : score) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
