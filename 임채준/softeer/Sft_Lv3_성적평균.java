package sft;

import java.io.*;
import java.util.*;

public class Sft_Lv3_성적평균 {
	
	static int N, K, start, end, sum;
	static int[] score;
	static double avg;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		score = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			sum = 0;
			for(int i = start; i <= end; i++) {
				sum += score[i];
			}
			avg = (double)sum / (end - start + 1);
            sb.append(String.format("%.2f", avg)).append("\n");

		}
		
		System.out.println(sb.toString());

	}

}
