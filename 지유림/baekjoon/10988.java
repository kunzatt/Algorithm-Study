import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length();
		boolean isS = true;
		
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != s.charAt(len - i - 1)) {
				isS = false; 
				break;
			}
		}
		
		if(isS) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
