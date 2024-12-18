import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String s = br.readLine();
		if(s.equals("\"")) {
			System.out.println("CE");
		} else {
			boolean prefix = s.startsWith("\"");
			
			StringBuffer sb = new StringBuffer(s);
			String rs = sb.reverse().toString();
			
			boolean suffix = rs.startsWith("\"");
			
			if(prefix && suffix) {
				String str = s.substring(1, s.length()-1);
				
				if(str.equals("")) {
					System.out.println("CE");
				} else {
					System.out.println(str);
				}
			} else {
				System.out.println("CE");
			}
		}
		
	}
}
