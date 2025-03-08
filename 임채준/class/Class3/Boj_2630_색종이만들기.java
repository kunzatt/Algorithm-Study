package class3;

import java.io.*;
import java.util.*;

public class Boj_2630_색종이만들기 {
	
	static int N, w, b;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0 ,0, N);
		
		System.out.println(w);
		System.out.println(b);
		
	}
	
	static void divide(int row, int col, int size) {
		if(check(row, col, size)) {
			if(map[row][col] == 0) w++;
			else b++;
			return;
		}
		int newSize = size / 2;
		divide(row, col, newSize);
		divide(row, col + newSize, newSize);
		divide(row + newSize, col, newSize);
		divide(row + newSize, col + newSize, newSize);
	}
	
	static boolean check(int row, int col, int size) {
		int color = map[row][col];
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}

}
