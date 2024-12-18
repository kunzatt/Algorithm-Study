package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 2573. 빙산 / 골드4 / 10:14 ~
// 4방탐색 -> 0개수만큼 숫자 줄어듦
// 빙산 좌표만 저장해서 bfs ㄱ
public class BOJ_2573 {
	static final int[] dy = { -1, 1, 0, 0 };
	static final int[] dx = { 0, 0, -1, 1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] arr;
	static List<int[]> ice;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		ice = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0) {
					ice.add(new int[] { i, j });
				}
			}
		}
		int time = 0;
		while (true) {
			if (play()) {
				time++;
			} else {
				break;
			}
			if (check()) {
				System.out.println(time);
				return;
			}
		}
		System.out.println(0);
	}

	private static boolean check() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		int count = 0;
		for (int i = 0; i < ice.size(); i++) {
			int[] pos = ice.get(i);
			if (visited[pos[0]][pos[1]] || arr[pos[0]][pos[1]] == 0) {
				continue;
			}
			count++;
			if (count >= 2) {
				return true;
			}
			q.add(ice.get(i));
			visited[pos[0]][pos[1]] = true;
			while (!q.isEmpty()) {
				pos = q.poll();
				int y = pos[0];
				int x = pos[1];
				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if (ny < 0 || nx < 0 || ny >= n || nx >= m || arr[ny][nx] == 0 || visited[ny][nx]) {
						continue;
					}
					visited[ny][nx] = true;
					q.add(new int[] { ny, nx });
				}
			}
		}
		return false;
	}

	private static boolean play() {
		int[][] state = new int[n][m];
		for (int[] pos : ice) {
			int y = pos[0];
			int x = pos[1];
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m || arr[ny][nx] != 0) {
					continue;
				}
				count++;
			}
			state[y][x] = count;
		}
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0) {
					flag = true;
				}
				arr[i][j] = Math.max(0, arr[i][j] - state[i][j]);
			}
		}
		return flag;
	}
}
