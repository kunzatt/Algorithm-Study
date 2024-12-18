import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main1181_단어정렬 {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 중복값 제거를 위해서 map의 key값으로 받아오기!
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), i);
		}
		
		
		// 정렬을 위해서 map -> list로 변경~
		List<String> list = new ArrayList<>(map.keySet());
		
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 같은 길이가 아니면 size를 return~
				int size = s1.length() - s2.length();
				if(size != 0) return size;
				return s1.compareTo(s2);
			}
		});
		
		for(String key: list) {
			System.out.println(key);
		}
	}
}
