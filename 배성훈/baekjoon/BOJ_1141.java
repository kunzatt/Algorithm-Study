import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1141. 접두사 / 실버1 / 42분
// 정렬하고 앞에 문자열과 뒤에 문자열만 비교하면 된다.
// 사전순으로 되면, 앞의 문자열이 접두사가 되는 문자열은 어차피 뒤에 인덱스에 바로 오게 된다
// 그래서 만약 앞에 문자열로 시작하면 카운트만 하나 빼주면 된다(앞에 접두사를 포함하는 문자열은 당연히 뒤의 문자열보다 많을 수 밖에 없기 때문에 앞에꺼를 빼주는게 최적해이다.)
public class BOJ_1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
        int count = n;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1].startsWith(arr[i])) {
                count--;
            }
        }
        System.out.println(count);
    }
}
