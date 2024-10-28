import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 배열로 푸려고 했더니 시간초과가 났다.
// 배열 -> 해쉬맵으로 풀이 변경 

public class Main_17479 {
	static int general, special, service;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Integer> menu =  new HashMap<>();
		HashMap<String, String> kind = new HashMap<String, String>();
		
		// 각 메뉴의 개수 
		general = Integer.parseInt(st.nextToken());
		special = Integer.parseInt(st.nextToken());
		service = Integer.parseInt(st.nextToken());
		
		// 메뉴 입력 받기 
		for(int i=0; i<general; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			menu.put(s, Integer.parseInt(st.nextToken()));
			kind.put(s, "general");
		}
		
		for(int i=0; i<special; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			menu.put(s, Integer.parseInt(st.nextToken()));
			kind.put(s, "special");
		}
		
		for(int i=0; i<service; i++) {
			String s = br.readLine();
			menu.put(s, 0);
			kind.put(s, "service");
		}
		
		long generalp = 0;
		long specialp = 0;	//스페셜 메뉴는 일반에서 20000 이상 주문해야 가능 
		int specialo = 0;
		int serviceo = 0;	// 서비스 메뉴는 1개만 가능 / 50000 이상 주문해야 가능 
		boolean flag = true;
		
		// 주문
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String order = br.readLine();
			String k = kind.get(order);
			
			if(k.equals("general")) {
				generalp += menu.get(order);
			}
			else if(k.equals("special")) {
				specialp += menu.get(order);
				specialo++;
			}
			else {
				serviceo++;
			}
			
			
		}
		
		if((generalp <20000 && specialo > 0) 
				|| (serviceo > 0 && generalp + specialp < 50000)
				|| serviceo > 1) {
			System.out.println("No");
		} else {
			System.out.println("Okay");
		}
	}
}
