import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개미가 방향을 꺾지 않고 가상의 공간으로 직선운동 한다고 생각.

public class Main_10158 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		// p+t가 w이거나 q+t가 h일때 좌표는 w 혹은 h이어야 하기 때문에 2*w로 나눠야 값이 나온다.
		if(((p+t)/w)%2 == 0) {
			p = (p+t)%(2*w);
		}else if(((p+t)/w)%2 == 1) {
			p = w - ((p+t)%(2*w)-w);
		}
		
		if(((q+t)/h)%2 == 0) {
			q = (q+t)%(2*h);
		}else if(((q+t)/h)%2 == 1) {
			q = h - ((q+t)%(2*h)-h);
		}
		sb.append(p).append(" ").append(q);
		System.out.println(sb);
	}

}
