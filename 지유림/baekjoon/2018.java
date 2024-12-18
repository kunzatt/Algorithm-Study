import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		// 연속적인 자연수를 구해야 하기 때문에, 1+2+3+4+... 인지 확인해야함
		// N - (1+2) % 2 일때 0이면 OK 나머지 있으면 NO
		// (1 + 2 + 3)에 동일한 수를 더했을 때 N이 나와야한다... 
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 처음 시작 1
		int num = 1;
		
		// 뒤에 추가될 2
		int plus = 2;
		
		// N + 0 도 포함했기 때문에 1부터 시작
		int cnt = 1;
		while(true) {
			// 1 + 2 + 3 + 4 + ... 순으로 나가기 위해서
			num += plus;
			if(num > N) break;
			else if((N - num) % plus == 0) cnt++;
			plus++;
		}
		
		System.out.println(cnt);
		
	}
}
