import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1141 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] str = new String[N];
		for(int i=0; i<N; i++) {
			str[i] = sc.next();
		}
		Arrays.sort(str, Comparator.comparing(String::length));	// 길이가 짧은 순으로 정렬

		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				String temp = str[j].substring(0, str[i].length());		// j를 앞에서부터 i의 길이만큼 자름
				if(str[i].equals(temp)) {	// 만약 앞부분이 같다면
					str[i]=null;	// null로 바꿈
					break;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(str[i] != null)
				cnt++;
		}
		System.out.println(cnt);
	}

}
