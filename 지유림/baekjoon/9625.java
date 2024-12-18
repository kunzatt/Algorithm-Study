import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		// 처음에 List 사용해서 돌렸더니 시간초과;
		// 규칙이 있나보다......;;
		// 2번 누르면 A: 1, B: 1
		// 3번 누르면 A: 1, B: 2
		// 4번 누르면 A: 2, B: 3
		// 한번 누를 대마다 그 전의 B -> A, B+A -> B 로 감
		// 배열로 각 A, B의 값을 담아주기
		
		// K만큼만 찾으면 되니까 K + 1만큼 초기화하기
		int[] A = new int[K + 1];
		int[] B = new int[K + 1];
		
		// 처음엔 A로 시작하니까 고정값!
		A[0] = 1;
		B[0] = 0;
		
		for(int i = 1; i < K + 1; i++) {
			A[i] = B[i-1];
			B[i] = A[i-1] + B[i-1];
		}
		
		// K번째 출력~
		System.out.println(A[K] + " " + B[K]);
	}
}
