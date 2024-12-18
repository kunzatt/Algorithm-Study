package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10811 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tmp;
		
		int[] box = new int[N+1];
		int a;
		int b;
		
		for(int i = 0; i<N+1; i++) {
			box[i] = i;
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());	
			tmp = new int[N+1];
			
			int n = a;
			for(int j = b; j>=a; j--) {
				tmp[n]= box[j];
				n++;
			}
			
			for(int j = a; j<=b; j++) {
				box[j] = tmp[j];
				n++;
			}
			
			
		}
		for(int j=1; j<N+1; j++) {
			System.out.print(box[j] + " ");
		}
		
		
		
	}

}
