import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 하나씩 다 돌리니까 계속 에러남..ㅠㅠ
// R, C가 무엇인지에 따라서 몇사분면에 있는지 위치하고 거기에 맞는 수를 더해주는 방식으로
public class Main1074_Z {
	static int N;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		N = (int) Math.pow(2, n);
		count = 0;
		
		findNum(r, c, N);
	}
	
	// 예시로 N = 8, n = 4
	
	static void findNum(int r, int c, int size) {
		if(size == 1) {
			System.out.println(count);
			return;
		}
		
		int n = size/2;
		
		if(r < n && c < n) { // 2사분면 , r과 c가 0~3이면 그냥 다시 돌림
			findNum(r, c, n);
		} else if(r < n && c < n*2) { // 1사분면 r이 0~3, c가 4~7 까지일때는 c에 n만큼빼서 다시 분할
			count += n*n;
			findNum(r, c-n, n);
		} else if(r < n*2 && c < n) { // 3사분면
			count += (n*n*2);
			findNum(r-n, c, n);
		} else if(r < n*2 && c < n*2) {	// 4사분면
			count += (n*n*3);
			findNum(r-n, c-n, n);
		}
	}
}
