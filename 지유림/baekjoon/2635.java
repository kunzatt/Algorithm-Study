import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 로직
		// N - i의 값을 리스트에 담았을 때 가장 긴 리스트가 최대 개수인 것 -> 그대로 출력
		
		// 최대값 담을 리스트
		ArrayList<Integer> maxList = new ArrayList<>();
		// 최대값 변수
		int max = 0;
		
		// i부터 ~ N까지 (N 포함 해야함)
		for(int i = 1; i <= N; i++) {
			// 지금 사용할 리스트
			ArrayList<Integer> list = new ArrayList<>();
			// 현재 값을 리스트에 담음
			list.add(N);		
			list.add(i);
			
			int a = N;
			int b = i;
			
			while(true) {
				// a - b 를 빼줌
				int c = a - b;
				// c의 값이 음수일 때 그만~
				if(c < 0) break; 
				else list.add(c);
				
				// a 에 b, b에 c를 넣어야 계속 돌아감
				a = b;
				b = c;
			}
			
			// 최대값 보다 현재 리스트 길이가 더 길 때 수정
			if(max < list.size()) {
				max = list.size();
				maxList = list;
			}
		}
		
		System.out.println(max);
		
		for(int i = 0; i < maxList.size(); i++) {
			System.out.print(maxList.get(i) + " ");
		}
		
		
	}
}
