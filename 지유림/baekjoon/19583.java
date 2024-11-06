import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main19583_싸이버개강총회 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] S = br.readLine().split(" ");
		String[] start = S[0].split(":");
		String[] end = S[1].split(":");
		String[] quit = S[2].split(":");
		
		int startH = Integer.parseInt(start[0]);
		int startM = Integer.parseInt(start[1]);
		int endH = Integer.parseInt(end[0]);
		int endM = Integer.parseInt(end[1]);
		int quitH = Integer.parseInt(quit[0]);
		int quitM = Integer.parseInt(quit[1]);
		
		HashSet<String> checkIn = new HashSet<>();
		HashSet<String> checkOut = new HashSet<>();
		
		
		String input = "";
		while((input = br.readLine()) != null && !input.isEmpty()) {
			String[] parts = input.split(" ");
			String[] timeParts = parts[0].split(":");
			String name = parts[1];

			int hour = Integer.parseInt(timeParts[0]);
			int minute = Integer.parseInt(timeParts[1]);
			
			// 입장
			if((hour < startH) || (hour == startH && minute <= startM)) {
				checkIn.add(name);
			}
			
			
			// 퇴장
			else if((hour > endH || (hour == endH && minute >= endM)) &&
	                (hour < quitH || (hour == quitH && minute <= quitM))) {
				checkOut.add(name);
			}
		}
		
		// 입장과 퇴장을 한 사람
		checkIn.retainAll(checkOut);
//		System.out.println(checkIn);
//		System.out.println(checkOut);
		System.out.println(checkIn.size());
		
	}
}
