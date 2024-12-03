package PermCombSub;

public class PowerSet {
	
	static int[] p = {1, 2, 3, 4, 5}; // 부분 집합을 구할 전체 숫자들 
	static int N, count; // 전체 숫자들 갯수, 부분 집합 갯수
	static boolean[] visited; // 사용기록을 저장할 배열 

	public static void main(String[] args) {
		
		N = p.length; // 전체 숫자들의 갯수
		count = 0; // 부분 집합 갯수를 저장할 변수 
		visited = new boolean[N]; // 사용 기록을 저장할 전체 숫자 갯수 크기의 배열 
		subset(0); // 함수에 탐색 시작 인자 전달
		System.out.println(count); // 부분집합 갯수 출력 

	}

	static void subset(int cnt) {
		if(cnt == N) { // 부분집합을 구하기 위한 인덱스가 최대 길이보다 넘었으면 
			count++; // 부분 집합 갯수 1 증가 
			for(int i = 0; i < N; i++) { // 전체 숫자들의 모든 인덱스에 대해 
				if(visited[i]) { // 방문이 참인 것들이 각 부분집합의 요소에 해당한다 
					System.out.print(p[i] + " "); // 참인 요소 즉 부분집합 출력 
				}
			}
			System.out.println();
			return; // 함수 종료 
		}
		visited[cnt] = true; // 들어온 인덱스의 값은 방문 참
		subset(cnt + 1); // 다음 함수 실행
		visited[cnt] = false; // 들어온 인덱스의 값은 방문 거짓 
		subset(cnt + 1); // 다음 함수 실행
		
		
	}

}
