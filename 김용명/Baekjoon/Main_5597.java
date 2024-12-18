package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5597 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] students = new int[30];
		int student;
		int[] min_max = new int[2];
		int idx = 0;
		
		
		for(int i = 0; i<28; i++) {
			student = Integer.parseInt(br.readLine());
			students[student-1] = student;
		}

		for(int i = 0; i<30; i++) {
			if(students[i] == 0) {
				min_max[idx] = i+1;
				idx++;
			}
		}
		
		if(min_max[0] > min_max[1]) {
			System.out.println(min_max[1]);
			System.out.println(min_max[0]);
		}else {
			System.out.println(min_max[0]);
			System.out.println(min_max[1]);
		}
		
	}

}
