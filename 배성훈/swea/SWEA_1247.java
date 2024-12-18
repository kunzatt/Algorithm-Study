import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1247. 최적 경로 / D5 / 1시간
// 처음 풀어보는 외판원 순회 문제
// 문제에서 말한 것 처럼 효율적인 방법을 찾는게 아니라, 어떻게 체계적으로 모든 경우의 수를 따져 최단 경로를 찾을 지가 관건
class Solution {
	static int[][] pos;
	static boolean[] visited;
	static int n, sy, sx, ey, ex;
	static int minDist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			minDist = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			visited = new boolean[n];
			pos = new int[n][2];
			sy = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}

			dfs(sy, sx, 1, 0);
			System.out.println("#"+t+" "+minDist);
		}
	}

	public static void dfs(int y, int x, int depth, int total) {
		if (depth == n + 1) {
			total += Math.abs(y - ey) + Math.abs(x - ex);
			minDist = Math.min(minDist, total);
			return;
		}
		for (int i = 0; i < pos.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int ny = pos[i][0];
				int nx = pos[i][1];
				int dist = Math.abs(y - ny) + Math.abs(x - nx);
				dfs(ny, nx, depth + 1, total + dist);
				visited[i] = false;
			}
		}
	}

	
}
