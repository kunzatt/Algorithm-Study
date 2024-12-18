import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			
			if(str.equals("0")) {
				break;
			}
			else if(isPlaindrome(arr)){
				System.out.println("yes");
			}
			else if(!isPlaindrome(arr)){
				System.out.println("no");
			}
		}

	}
	
	static boolean isPlaindrome(char[] map) {
		for (int i = 0; i < map.length/2; i++) {
			if(map[i] != map[map.length-i-1]) {
				return false;
			}	
		}
		return true;
	}
}
