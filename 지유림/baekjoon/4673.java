
public class Main {
	public static void main(String[] args) {
		int[] num = new int[10000];
    
		int sum = 0;
		int cnt = 0;
		

    // 합계가 10000 이 넘으면 끝!
		while(sum < 10000) {
			cnt++;
			sum = 0;
			int cnt2 = cnt;
			while(cnt2 > 0) {
				sum += cnt2 % 10;
				cnt2 /= 10;
			}
			sum += cnt;
			if(sum < 10000) num[sum]++;
		}
		
		
		for(int i = 1; i < sum - 5; i++) {
			if(num[i] == 0) {
				System.out.print(i + " " );
			}
		}
	}
}
