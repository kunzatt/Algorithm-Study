import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 이렇게 풀지 마세요..
public class Main_2635 {
	
	// arr[0]을 N, arr[1]을 i로 놓고 계산을 해보면
	// N+0*i  0*N+i  N-i  -1*N+2*i  2*N-3*i ....
	// N과 i의 각각 계수의 절대값이 피보나치 수열로 나타난다는 것을 알 수 있음.(N이 한번 늦게 나타남)
	// N계수의 절댓값 -> fib(num-1)
	// i계수의 절댓값 -> fib(num)
	static int fibo(int num) {
		int[] arr = new int[num + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= num; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[num];
	}	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int[] arr = new int[30000]; // 적당히 큰 수..?
		
		// max값 구하기 
		for (int i = 1; i <= N; i++) { // 첫번째 수는 항상 양의 정수 
			Arrays.fill(arr, -1); // 이따가 출력할때 0이상의 정수만 출력할 것이기 때문에 처음에 전체를 -1로 초기화 
			arr[0] = N; 
			arr[1] = i;
			int count = 1; // 위에 배열의 값을 두개 지정했는데도 1인 이유? 밑 for문에서 처음 나오는 음수까지 배열에 넣을 거라서..
			for (int j = 2; j <= arr.length; j++) { // 이미 앞에 두 값을 지정해줬기 때문에 피보나치에 영향x , 배열에 넣을거라 배열 길이만큼 순회 
				// 계수를 피보나치 수열로 나타내고 그 계수의 절대값 풀기. 
				if(j%2 == 1) { 
					arr[j] = fibo(j)*i - fibo(j-1)*N;
					count++;
					if(arr[j] < 0) { // 뺀 값이 음수가 되면 break
						break;
					}
				}else if(j%2 == 0) {
					arr[j] = fibo(j-1)*N - fibo(j)*i;
					count++;
					if(arr[j] < 0) {  // 뺀 값이 음수가 되면 break
						break;
					}
				}
			}
			if(max < count) {
				max = count;
			}
		}
		
		// max값에 일치하는 배열 구하기 
		// 위에 반복문 그대로 활용 
		for (int i = 1; i <= N; i++) {
			int count = 1;
			Arrays.fill(arr, -1);
			arr[0] = N;
			arr[1] = i;
			for (int j = 2; j <= arr.length; j++) {
				if(j%2 == 1) {
					arr[j] = fibo(j)*i - fibo(j-1)*N;
					count++;
					if(arr[j] < 0) {
						break;
					}
				}else if(j%2 == 0) {
					arr[j] = fibo(j-1)*N - fibo(j)*i;
					count++;
					if(arr[j] < 0) {
						break;
					}
				}
			}
			if(count == max) {
				break;
			}
		}
		
		// 출력 
		System.out.println(max);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= 0) {
				System.out.print(arr[i] + " ");					
			}		
		}
	}
}
