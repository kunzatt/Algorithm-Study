import java.util.Scanner;

public class Main_1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt =0;	// 사이클의 길이 저장
		int tmp = N;	// 수를 임시 저장할 함수
		
		// 원래 수로 돌아올 때까지 반복
		while(true) {
			cnt++;	// 사이클 더하기
			int left = tmp/10;	// 왼쪽
			int right = tmp%10;	// 오른쪽
		
			int lr = left+right;	// 왼쪽 + 오른쪽
			int newN = right*10 + (lr%10);	// 새로운 수 = tmp의 왼쪽 + lr의 오른쪽
			if(newN == N)
				break;

			tmp = newN;
		}
		
		System.out.println(cnt);
	}

}
