import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403 {
	static int N;
	static int[][] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		
		// 모든 정점 i->j 이므로 플로이드워셜로 푼다!
		for(int k=0; k<N; k++) {	// 경유지
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// 경유했을 때 경로가 있다면 경로에 추가
					if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
}
