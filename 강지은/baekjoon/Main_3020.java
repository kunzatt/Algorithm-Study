import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3020 {
    
	static int N, H;
	static int[] ob, down, up;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ob = new int[N];
        down = new int[N/2];
        up = new int[N/2];       
        	
        for (int i = 0; i < N/2; i++) {
			down[i] = Integer.parseInt(br.readLine());
			up[i] = Integer.parseInt(br.readLine());
		}
        
        Arrays.sort(down);
        Arrays.sort(up);
                
        int min = N;
        int cnt = 0;
        
        for (int i = 1; i <= H; i++) {
			int conflict = binarySearch(0, N/2, i, down) + binarySearch(0, N/2, H-i+1, up);
			
			if (min == conflict) {
				cnt++;
				continue;
			}
			
			if (min > conflict) {
				min = conflict;
				cnt = 1;
			}
		}
        
        System.out.println(min+" "+cnt);
        
    }

	private static int binarySearch(int lo, int hi, int H, int[] arr) {
		while (lo < hi) {
			int mid = (lo+hi)/2;
			
			if (arr[mid] >= H) {
				hi = mid;
			} else {
				lo = mid+1;
			}
		}
		return arr.length-hi;
	}
    
}
