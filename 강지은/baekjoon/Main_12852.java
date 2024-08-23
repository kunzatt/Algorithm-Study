import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main_12852 {

	static int N;
	static int min = Integer.MAX_VALUE;
	static List<Integer> nums = new ArrayList<>();
	static List<Integer> tmp = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		tmp.add(N);
		
		minCount(N, 0);
		
		System.out.println(min);
		for (Integer num : nums) {
			System.out.print(num+" ");
		}
		
	}

	private static void minCount(int n, int cnt) {
		// n이 1이 됐을 경우 최소값 비교
		if (n == 1) {
			if (cnt < min) {
				min = cnt;
				// 최소값이 바뀌면 해당 배열을 nums에 담는다.
				nums.clear();
				nums.addAll(tmp);
			}
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			// 1번 규칙: n이 3으로 나뉘는지
			if (i == 0 && n%3 == 0) {
				n /= 3;
			}
			// 2번 규칙: n이 2로 나뉘는지
			else if (i == 1 && n%2 == 0) {
				n /= 2;
			}
			// 3번 규칙: n에서 1 빼기
			else if (i == 2){
				n--;
			}
			
			// 카운트가 최소값을 넘기면 패스
			if (++cnt >= min) {
				cnt--;
				return;
			}

			tmp.add(n);
			minCount(n, cnt);
			tmp.remove(cnt--);
			n = tmp.get(cnt);
		}
	}
}
