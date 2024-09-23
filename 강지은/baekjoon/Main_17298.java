import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Stack<int[]> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= num) break;
				
				if (stack.peek()[1] < num) {
					arr[stack.peek()[0]] = num;
					stack.pop();
				}
			}
			
			stack.push(new int[] {i, num});
		}
		
		while (!stack.isEmpty()) {
			arr[stack.peek()[0]] = -1;
			stack.pop();
		}
		
		for (int idx : arr) {
			sb.append(idx+" ");
		}
		
		System.out.println(sb.toString());
		
	}

}
