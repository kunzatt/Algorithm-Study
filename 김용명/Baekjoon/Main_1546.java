package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.xml.sax.helpers.AttributeListImpl;

public class Main_1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double max = 0;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		double[] score = new double[N];
		double sum=0;
		for(int i = 0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if (max < score[i]) {
				max = score[i];
			}
		}
		for(int i = 0; i<N; i++) {
			score[i] = score[i]/max*100;
			sum += score[i];
		}
		System.out.println(sum/N);
		
		
		
	}
}
