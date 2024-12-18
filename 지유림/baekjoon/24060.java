import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main24060_알고리즘수업_병합정렬1 {
	static int N, K;
	static int[] arr;
	static int count, result;
	static int[] tmp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		tmp = new int[N];
		count = 0;
		result = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		 
		mergeSort(0, N-1);
		
		if(count < K) result = -1;
		System.out.println(result);
	}
	
	static void mergeSort(int left, int right) {
		
		// 저장횟수가 K보다 넘어가면 할 필요없음
		if(count > K) return;
		
		// 왼쪽구간이 오른쪽 구간보다 커지면 -> 오른쪽과 왼쪽이 변경된 거니까 stop
		if(left < right) {
			int mid = (left + right) / 2; // 가운데를 알아야하니까
			mergeSort(left, mid);		// 전반부 정렬
			mergeSort(mid+1, right);	// 후반부 정렬
			merge(left, mid, right);	// 병합
		}
	}
	
	
	static void merge(int left, int mid, int right) {
		int L = left;	// 왼쪽구간의 시작 포인트
		int R = mid+1;	// 중간부분+1
		
		int idx = left;
		
		// 시작 인덱스가 중간 인덱스보다 작고
		// 중간 인덱스가 마지막 인덱스보다 작을때까지 반복
		while(L <= mid && R <= right) {
			if(arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		
		// 정렬 다 했는데 왼쪽 구간이 남았을 때
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else { // 오른쪽 구간 값이 남음
			for(int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		
		
		// 원본 배열에 반영!
		// 원본 배열에 반영할 때 K번째로 저장한 값을 출력
		for(int i = left; i <= right; i++) {
			count++;
			
			if(count == K) {
				result = tmp[i];
				break;
			}
			arr[i] = tmp[i];
		}
	}
}
