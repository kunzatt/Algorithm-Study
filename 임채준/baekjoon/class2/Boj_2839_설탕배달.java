package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_2839_설탕배달 {
	
	static int N, count, ans;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        System.out.println(cal(N));

    }
    
    public static int cal(int N) {
        count = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                return count + (N / 5);
            }
            N -= 3;
            count++;
        }
        return -1;
    }

}
