import java.io.*;
import java.util.*;

// 시간 제한때문에 ListIterator를 사용해야하는 문제.
public class Main_1406 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Character> list = new LinkedList<Character>();
		String str = br.readLine();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		ListIterator<Character> iter = list.listIterator();
		
		// 커서를 제일 오른쪽으로 이동 
		while(iter.hasNext()) {
			iter.next();
		}
		
		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			char c = input.charAt(0);
			switch(c) {
			case 'L':
				if(iter.hasPrevious())
					iter.previous();

				break;
			case 'D':
				if(iter.hasNext())
					iter.next();

				break;
			case 'B':
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P':
				char t = input.charAt(2);
				iter.add(t);

				break;
			}
		}
		
		
		for (Character character : list) {
			bw.write(character);
		}
		
		bw.flush();
		bw.close();
			
	}

}
