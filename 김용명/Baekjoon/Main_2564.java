import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int xdat = Integer.parseInt(st.nextToken());
		int ydat = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2]; // 제일 마지막 N번째에 경비원의 값을 넣는다.
		
		for (int i = 0; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for (int i = 0; i < N+1; i++) {
			// 시계방향, 반시계방향으로 돌면서 최소값을 구해야 하는 부분은 경비원과 마주보는 변에 위치한 상점이 존재할 때이다.
			// 나머지는 최소값을 구하는 방법이 확실하기 때문에 시계, 반시계 방향으로 둘다 돌면서 찾을 필요가 없다.
			if(arr[N][0] == 1) {
				if(arr[i][0] == 1) {
					result += Math.abs(arr[N][1] - arr[i][1]);
				}else if(arr[i][0] == 2) {
					result += Math.min(ydat+arr[N][1]+arr[i][1], 2*xdat+ydat-arr[N][1]-arr[i][1]);
				}else if(arr[i][0] == 3) {
					result += arr[N][1] + arr[i][1];
				}else {
					result += xdat - arr[N][1] + arr[i][1];
				}
			}else if(arr[N][0] == 2) {
				if(arr[i][0] == 1) {
					result += Math.min(ydat+arr[N][1]+arr[i][1], 2*xdat+ydat-arr[N][1]-arr[i][1]);
				}else if(arr[i][0] == 2) {
					result += Math.abs(arr[N][1] - arr[i][1]);
				}else if(arr[i][0] == 3) {
					result += arr[N][1] + ydat - arr[i][1];
				}else {
					result += xdat - arr[N][1] + ydat -arr[i][1];
				}
			}else if(arr[N][0] == 3) {
				if(arr[i][0] == 1) {
					result += arr[N][1] + arr[i][1];
				}else if(arr[i][0] == 2) {
					result += ydat - arr[N][1] + arr[i][1];
				}else if(arr[i][0] == 3) {
					result += Math.abs(arr[N][1] - arr[i][1]);
				}else {
					result += Math.min(xdat+arr[N][1]+arr[i][1], 2*ydat+xdat-arr[N][1]-arr[i][1]);
				}
			}else if(arr[N][0] == 4) {
				if(arr[i][0] == 1) {
					result += arr[N][1] + xdat - arr[i][1];
				}else if(arr[i][0] == 2) {
					result += ydat - arr[N][1] + xdat - arr[i][1];
				}else if(arr[i][0] == 3) {
					result += Math.min(xdat+arr[N][1]+arr[i][1], 2*ydat+xdat-arr[N][1]-arr[i][1]);
				}else {
					result += Math.abs(arr[N][1] - arr[i][1]);
				}
			}
		}
		System.out.println(result);
		
	}

}
