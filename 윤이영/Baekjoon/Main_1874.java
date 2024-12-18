import java.util.Scanner;
import java.util.Stack;

public class Main_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Integer> s = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for(int i=1; i<=N; i++) {
			s.push(i);
			sb.append("+"+'\n');
			if(s.peek() == arr[idx]) {
				while(true) {
					if(s.isEmpty() || s.peek() != arr[idx] )
						break;
					s.pop();
					sb.append("-"+'\n');
					idx++;
				}
				
			}
			if(!(s.isEmpty()) && s.peek() > arr[idx]) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}

		System.out.println(sb);
	}
}
