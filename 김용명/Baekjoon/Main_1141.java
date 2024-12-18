import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1141 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		int ans = n;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		
		// 배열을 정렬하고 짧은것 부터 접두사인지 확인해 조건에 부합하면 제거한다.
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(isPrefix(arr[i], arr[j])) {
					 ans--;
					 break;
				}
			}
		}
		System.out.println(ans);

	}
	
	static boolean isPrefix(String str1, String str2) {
		char[] ch1 = new char[str1.length()];
		char[] ch2 = new char[str2.length()];
		for (int i = 0; i < ch1.length; i++) {
			ch1[i] = str1.charAt(i);
		}
		for (int i = 0; i < ch2.length; i++) {
			ch2[i] = str2.charAt(i);
		}
		if(ch1.length <= ch2.length) {
			int count = 0;
			for (int i = 0; i < ch1.length; i++) {
				if(ch2[i] == ch1[i]) {
					count ++;
				}
				if(count == ch1.length) {
					return true;
				}
			}
		}
		if(ch1.length > ch2.length) {
			int count = 0;
			for (int i = 0; i < ch2.length; i++) {
				if(ch2[i] == ch1[i]) {
					count ++;
				}
				if(count == ch2.length) {
					return true;
				}
			}
		}
		return false;
	}

}
