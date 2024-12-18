import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	// -1: 가로, 0: 세로, 1: 대각
	static int flag;
	static int count;
	static int n;
	static int[][] arr;
	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 1, 0 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		flag = -1;
		dfs(0, 1, -1);
		System.out.println(count);
	}

	public static void dfs(int y, int x, int flag) {
		if (y == n - 1 && x == n - 1) {
			count++;
			return;
		}
		// 가로
		if (flag == -1) {
			// 오른쪽으로
			if (y < n && x + 1 < n && arr[y][x + 1] == 0 && arr[y][x + 1] != 1) {
				dfs(y, x + 1, -1);
			}
		}
		// 세로
		else if (flag == 0) {
			// 밑으로
			if (y + 1 < n && x < n && arr[y + 1][x] == 0 && arr[y + 1][x] != 1) {
				dfs(y + 1, x, 0);
			}
		}
		// 대각
		else {
			// 오른쪽으로
			if (y < n && x + 1 < n && arr[y][x + 1] == 0 && arr[y][x + 1] != 1) {
				dfs(y, x + 1, -1);
			}
			// 밑으로
			if (y + 1 < n && x < n && arr[y + 1][x] == 0 && arr[y + 1][x] != 1) {
				dfs(y + 1, x, 0);
			}
		}

		// 대각 무조건 확인
		if (y + 1 < n && x + 1 < n && arr[y + 1][x + 1] == 0 && arr[y + 1][x] != 1 && arr[y][x + 1] != 1) {
			dfs(y + 1, x + 1, 1);
		}
	}
}
