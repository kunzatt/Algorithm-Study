import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5052_전화번호목록 {
	static int T, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			String[] nums = new String[N];
			
			for(int i = 0; i < N; i++) {
				nums[i] = br.readLine();
			}

			Arrays.sort(nums);
			
			
			boolean isConsistent = true;
	
			// startsWith : String에 있는 접두어 확인하는 함수
			// 배열에서 인접한 것들 끼리 접두어인지 아닌지 확인하기~
			 for (int i = 0; i < N - 1; i++) {
	                // nums[i]가 nums[i+1]의 접두어인지 확인
                if (nums[i + 1].startsWith(nums[i])) {
                    isConsistent = false;
                    break;
                }
            }
			
			System.out.println(isConsistent ? "YES" : "NO");
		}
		
	}
}
