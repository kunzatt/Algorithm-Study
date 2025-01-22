import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        int num = 1;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                num++;
            }
            if (arr[i] != num) {
                stack.push(arr[i]);
            } else {
                num++;
            }
        }

        while (!stack.isEmpty() && stack.peek() == num) {
            stack.pop();
            num++;
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");

    }
}
