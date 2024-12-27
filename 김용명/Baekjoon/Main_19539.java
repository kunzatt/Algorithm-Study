import java.io.*;
import java.util.*;

public class Main_19539 {
	
  public static void main(String[] args) throws Exception {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  int N = Integer.parseInt(br.readLine());
	  int[] arr = new int[N];
	  int sum = 0;
      int one = 0;
      int two = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum += arr[i];
      one += arr[i] % 2;
      two += arr[i] / 2;
    }

    if (sum % 3 > 0 || one > two) {
      System.out.println("NO");
    }else {
    	System.out.println("YES");
    }
    
  }
  
}