import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15353 {
    
	static List<Integer> ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		ans = new ArrayList<>();
		
		int sum = 0;
		int carry = 0;
		if (A.length() >= B.length()) {
			String tmpA = A.substring(A.length()-B.length());
			for (int i = B.length()-1; i >= 0; i--) {
				sum = (tmpA.charAt(i)-'0')+(B.charAt(i)-'0')+carry;
				ans.add(sum%10);
				carry = sum/10;
			}
			
			tmpA = A.substring(0, A.length()-B.length());
			for (int i = tmpA.length()-1; i >= 0; i--) {
				sum = carry+(tmpA.charAt(i)-'0')+carry;
				ans.add(sum%10);
				carry = sum/10;
			}
			
			if (carry > 0) ans.add(carry);
			System.out.println(tmpA);
		} else {
			String tmpB = B.substring(B.length()-A.length());
			for (int i = A.length()-1; i >= 0; i--) {
				sum = (tmpB.charAt(i)-'0')+(A.charAt(i)-'0')+carry;
				ans.add(sum%10);
				carry = sum/10;
			}
			
			tmpB = B.substring(0, B.length()-A.length());
			for (int i = tmpB.length()-1; i >= 0; i--) {
				sum = carry+(tmpB.charAt(i)-'0')+carry;
				ans.add(sum%10);
				carry = sum/10;
			}
			
			if (carry > 0) ans.add(carry);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = ans.size()-1; i >= 0; i--) {
			sb.append(ans.get(i));
		}
		
		System.out.println(sb.toString());
		
	}
}
