import java.util.Scanner;

public class Main_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String[] strlist = new String[N];
		// 문자열 입력 받기
		for(int i=0; i<N; i++) {
			strlist[i] = sc.next();
		}
		// 정렬
		for(int i=0; i<N-1; i++) {
			int minidx = i;
			for(int j=i+1; j<N; j++) {
				if(strlist[minidx].length() > strlist[j].length()) {	// 길이 순 정렬
					minidx = j;
				}
				if(strlist[minidx].length() == strlist[j].length()) {	// 길이가 같을 경우 사전순 정렬
					if(strlist[minidx].compareTo(strlist[j]) > 0) {
						minidx = j;
					}
				}
			}
			
			if(minidx != i) {	// swap
				String temp = strlist[i];
				strlist[i] = strlist[minidx];
				strlist[minidx] = temp;
			}
			
		}
		// 출력
		System.out.println(strlist[0]);
		for(int i=1; i<N; i++) {
			if(strlist[i].equals(strlist[i-1])) {	//중복된 값은 제외하고 출력
				continue;
			}
			System.out.println(strlist[i]);
			
		}
	}
	
}