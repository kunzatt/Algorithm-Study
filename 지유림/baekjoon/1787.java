import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// S는 4,294,967,295만큼 주어짐! int값 벗어남 long으로 받아야됨
		S = Long.parseLong(br.readLine());
		
		// N은 중복되지 않은 값!
		// 1 부터 계속 더한 뒤 S보다 값이 커지면 -> 가장 큰 값을 빼주면서 개수찾기
		int N = 0; 
		long sum = 0;
		
		// 반복문 시작~
		while(true) {
			sum += ++N;
			
			if(sum > S) {
				while(true) {
					long ss = S - sum;
					if(ss > N) break;
					sum -= N--;
				}
				// 마지막에 -1 돼서 나오니까 여기서 +1 해주기
				N++;
				break;
			}
		}
		System.out.println(N);
	}
}
