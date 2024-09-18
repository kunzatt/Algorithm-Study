import java.util.Scanner;
import java.util.Stack;

// 수열처럼 공식화 해야하는거 같다..
// hanoi(n) = 2 * hanoi(n-1) + 1;
// 1. 가장 큰 원판을 A -> C 로 옮기기 위해서는 n-1개의 원판이 A->B로 가야한다. -> n-1
// 2. A에 있는 가장 큰 원판이 C로 이동한다. -> 1
// 3. B에 있는 n-1개의 원판을 C로 이동시킨다. -> n-1
// => 2*n-1 + 1
// 점화식 어렵다..@_@

public class Main {
	static int K, N;
	static int count;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 최소값 공식 : 2^n-1
		sb.append((int)(Math.pow(2, N)-1)).append("\n");
		
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}
	
	// start : 1, mid: 2, to: 3
	// 처음 실행되면 1 -> 3
	static void hanoi(int n, int start, int mid, int end) {
		if(n == 0) {
			return;
		}
		
		// A -> B
		// 1. n-1개를 start -> mid로 이동
		hanoi(n-1, start, end, mid);
		// 2, 1, 3, 2
		// 1, 1, 3, 2
		
		
		// sb가 실행되면 원판이 이동된것!!
		sb.append(start).append(" ").append(end).append("\n");
		
		
		// 3. n-1개를 to -> mid로 이동
		hanoi(n-1, mid, start, end);
		// 
	}
}
