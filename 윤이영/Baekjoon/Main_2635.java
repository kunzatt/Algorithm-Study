import java.util.ArrayList;
import java.util.Scanner;
public class Main_2635 {
	
	static ArrayList<Integer> maxlist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		
		for(int i=0; i<N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(N-i);
			int idx = 2;
			while(true) {
				int n1 = list.get(idx-2);
				int n2 = list.get(idx-1);
				if(n1-n2 <0)	// 만약 음수가 나오면 반복문 탈출
					break;
				list.add(n1-n2);	// 앞의 앞의 수 - 앞의 수
				idx++;
				if(idx > max) {
					max = idx;	// 최대 개수 저장
					maxlist = new ArrayList<>();
					maxlist.addAll(list);	// 최대 개수의 리스트 저장
				}
			}
		}
		// 정답 출력
		System.out.println(max);
		for(Integer m: maxlist) {
			System.out.print(m+" ");
		}
		
	}

}
