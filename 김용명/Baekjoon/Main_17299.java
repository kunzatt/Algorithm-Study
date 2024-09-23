import java.io.*;
import java.util.*;

public class Main_17299 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] ans = new int[N];
		int[] F = new int[1000001];
		Stack<Integer> stack = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			F[arr[i]]++;
		}
		
		for (int i = 0; i < N; i++) {
			
			while (!stack.isEmpty() && F[arr[stack.peek()]] < F[arr[i]]) {
				ans[stack.pop()] = arr[i];
			}
			
			stack.push(i);			
		}
		
		while (!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		
		for (int i : ans) {
			bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
 
	}

}
