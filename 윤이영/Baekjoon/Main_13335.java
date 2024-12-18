import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335 {
	static int n, w, L;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// n개의 트럭
		w = Integer.parseInt(st.nextToken());	// 다리의 길이
		L = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new LinkedList<Integer>();	// 큐를 활용하여 문제 풀이!
		
		for(int i=0; i<w; i++) {
			q.add(0);
		}
		
		int bw = 0;	// 다리 위의 트럭 무게 합
		int time = 0;	// 시간을 저장할 변수
		

		for(int i=0; i<n; i++) {
			while(bw + arr[i] > L) {	// 만약 다음 트럭을 실었을 때 무게가 초과한다면:
				bw-= q.peek();	// 맨 앞의 무게를 빼보고
				if(bw+arr[i] <= L) {	// 만약 다음 트럭을 실을 수 있다면	
					bw+= q.peek();	// 맨 앞의 무게를 더한 뒤에
					break;	// 반복문 탈출
				}	
				q.poll();	// 만약 여전히 다음 트럭을 실을 수 없는 경우:
				q.add(0);	// 현재 다리 위에 있는 트럭만 이동
				time++;
			}
			q.add(arr[i]);	// 다음 트럭은 다리 위로
			bw-= q.poll();	// 맨 앞의 트럭만큼 무게를 빼주기
			bw += arr[i];	// 새로 실은 트럭의 무게만큼 더해주기
			time++;	// 시간 증가
		}
		
		while(!q.isEmpty()) {
			q.poll();
			time++;
		}
		
		System.out.println(time);
		
	}

}
