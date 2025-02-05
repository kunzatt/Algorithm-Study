import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15702 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int num = Integer.MAX_VALUE;
		int score = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tnum = Integer.parseInt(st.nextToken());
			int tscore = 0;

			for (int j = 0; j < N; j++) {
				String str = st.nextToken();
				if (str.equals("O")) {
					tscore += arr[j];
				}
			}

			if (tscore > score) {
				num = tnum;
				score = tscore;
			} else if (tscore == score && tnum < num) {
				num = tnum;
			}

		}

		System.out.println(num + " " + score);


	}
}
