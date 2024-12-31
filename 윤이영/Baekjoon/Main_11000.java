import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * pq를 이용하여 풀이
 * 1. Comparator를 이용하여 시작시간, 종료시간을 모두 고려하여 정렬
 * 2. pq를 이용하여 한 수업의 종료시간과, 다음 수업의 시작시간을 비교
 * 3. 현재 강의의 시작 시간이 큐의 종료 시간보다 크거가 같다 -> 기존 강의실에서 수업을 이어서 할 수 있음을 이용
 * 
 */

public class Main_11000 {
	static int N;
	static int[][] lectures;
	
	static Comparator<int[]> comparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			if(a[0] == b[0]) {
				// 시작 시간이 같다면, 종료 시간을 기준으로 정렬한다.
				return a[1] - b[1];
			}
			return a[0] - b[0]; // 시작 시간 기준 오름차순
		}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		lectures = new int[N][2];
		
		for(int i=0; i<N; i++) {
			lectures[i][0] = sc.nextInt();	// 시작 시간
			lectures[i][1] = sc.nextInt();	// 종료 시간
		}
		
		Arrays.sort(lectures, comparator);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(lectures[0][1]);
		
		for(int i=1; i<N; i++) {
			if(lectures[i][0] >= pq.peek()) {
				pq.poll();
			}
			pq.add(lectures[i][1]);
		}
	
		
		System.out.println(pq.size());
	}
	
	
}
