import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11729 {
    
	static int N, cnt;
	static StringBuilder sb;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        hanoi(N, 1, 2, 3);
        
        System.out.println(cnt);
        System.out.println(sb.toString());
        
    }

	private static void hanoi(int n, int start, int mid, int end) {
		cnt++;
		
		if (n==1) {
			sb.append(start+" "+end+"\n");
			return;
		}
		
		hanoi(n-1, start, end, mid);
		
		sb.append(start+" "+end+"\n");
		
		hanoi(n-1, mid, start, end);
		
	}

}
