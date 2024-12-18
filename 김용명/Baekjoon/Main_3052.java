package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mod = new int[42];
		int num;
		int cnt = 0;
		
		for(int i = 0; i<10; i++) {
			num = Integer.parseInt(br.readLine()) % 42;
			mod[num]+=1;
		}
		
		for(int i = 0; i<mod.length; i++) {
			if(mod[i] != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
	}

}
