import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution22979_문자열옮기기 {
    static int T, K;
    static String S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            S = br.readLine();
            K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            StringBuilder result = new StringBuilder(S);

            // 각 연산 처리
            for(int i = 0; i < K; i++) {
                int X = Integer.parseInt(st.nextToken());

                // 양수 연산: 앞에서 떼서 뒤로
                if(X > 0) {
                    X = X % result.length(); // 문자열 길이로 나눈 나머지만큼만 이동
                    for(int j = 0; j < X; j++) {
                        char first = result.charAt(0);
                        result.deleteCharAt(0);
                        result.append(first);
                    }
                }
                // 음수 연산: 뒤에서 떼서 앞으로
                else if(X < 0) {
                    X = (-X) % result.length(); // 음수를 양수로 변환
                    for(int j = 0; j < X; j++) {
                        char last = result.charAt(result.length()-1);
                        result.deleteCharAt(result.length()-1);
                        result.insert(0, last);
                    }
                }
                // X가 0인 경우는 아무 처리도 하지 않음
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
