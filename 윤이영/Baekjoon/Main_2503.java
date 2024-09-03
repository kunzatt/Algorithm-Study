import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2503 {
	static int N;
	static int strike, ball;
	static boolean[] check = new boolean[988];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 맞춰야 하는 숫자
		for(int i=123; i<=987; i++) {
			String temp = ""+i;
			if(temp.charAt(0) == '0' || temp.charAt(1) == '0' || temp.charAt(2) == '0') continue;
			if(temp.charAt(0) == temp.charAt(1) || temp.charAt(0) == temp.charAt(2) || temp.charAt(1) == temp.charAt(2))
				continue;
			
			check[i] = true;
		}
		
		
		for(int t=0; t<N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] nums = st.nextToken().toCharArray();
			strike = Integer.parseInt(st.nextToken());
			ball = Integer.parseInt(st.nextToken());

			
			for(int i=123; i<=987; i++) {
				if(!check[i]) continue;
				String temp = ""+i;
				int scnt = 0;
				int bcnt = 0;
				
				for(int j=0; j<3; j++) {
					for(int k=0; k<3; k++) {
						if(j==k && temp.charAt(j) == nums[k]) scnt++;
						if(j!= k && temp.charAt(j) == nums[k]) bcnt++;
					}
					
				}
				if (bcnt != ball || scnt != strike) check[i] = false;
			}
		}
		
		int count = 0;
		for(int i=123; i<=987; i++) {
			if(check[i]) count++;
		}
		System.out.println(count);
	}

}
