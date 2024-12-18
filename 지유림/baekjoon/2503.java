import java.util.Scanner;

public class Main {
	static int N, S, B; // N: 질문, S: 스트라이크, B: 볼
	static int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 9};	// 1~9 안에서만 함
	static boolean[] visited;
	static int[][] arr; // 민혁이가 말하는 세자리 수 
	static int[][] bs;
	static int[] nums;
	static int result;
	// 1. 3개씩 뽑아보기
	// 2. 뽑아본거 조건 돌려서 맞은 횟수 세기
	public static void main(String[] args) {
		// 입력값이 최대 100개라 그냥 scanner
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// N개 만큼 3자리씩 들어오니까
		arr = new int[N][3];
		nums = new int[3];
		
		bs = new int[N][2];
		visited = new boolean[p.length];
		result = 0;
		
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			for(int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				arr[i][j] = c - '0';
			}
			
			bs[i][0] = sc.nextInt();
			bs[i][1] = sc.nextInt();
		}
		
		perm(0);

		System.out.println(result);
	}
	
	// npr -> 9p3
	static void perm(int cnt) {
		if(cnt == 3) {
			result += check(nums);
			
			return;
		}
		
		for(int i = 0; i < p.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = p[i];
			perm(cnt+1);
			visited[i] = false;
			
		}
	}

  // 조건 체크 -> strike or ball 개수세기
	static int check(int[] nums) {
		int cnt = 0;

		for(int i = 0; i < N; i++) {
			int strike = 0;
			int ball = 0;
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(arr[i][j] == nums[k] && j == k) {
						strike++;
					} else if(arr[i][j] == nums[k] && j != k) {
						ball++;
					}
				}
			}
			
			if(bs[i][0] == strike && bs[i][1] == ball) {
				cnt++;
			}
		}
		
		if(cnt == N) {
			return 1;
		} else {
			return 0;
		}
	}
}
