import java.io.*;
import java.util.*;

public class Main1339_단어수학 {
    static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 각 알파벳별 가중치를 저장할 Map
        map = new HashMap<>();

        // 각 단어를 처리하면서 알파벳별 가중치 계산
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            int len = str.length();

            // 각 알파벳의 자릿수에 따른 가중치 계산
            for(int j = 0; j < len; j++) {
                char alpha = str.charAt(j);
                int weight = (int)Math.pow(10, len - j - 1);
                map.put(alpha, map.getOrDefault(alpha, 0) + weight);
            }
        }

        // 가중치가 높은 순으로 정렬
        List<Character> alpha = new ArrayList<>(map.keySet());
        alpha.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));

        // 가중치가 높은 알파벳부터 9부터 차례로 숫자 할당하여 결과 계산
        int number = 9;
        long result = 0;
        for(char c : alpha) {
            result += map.get(c) * number--;
        }

        System.out.println(result);
    }
}
