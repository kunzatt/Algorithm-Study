import java.io.*;
import java.util.*;

public class Main_17298 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
 
		// 어려운 개념
		// 입력값을 스택에 넣는것이 아닌 인덱스를 스택에 넣고 비교 
		for(int i = 0; i < N; i++) {
			
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		for (int i : arr) {
			bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
	}
}