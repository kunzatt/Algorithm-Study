import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static int N, T, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 상대평가 인원 -> 10의 배수 이니까 무조건 정수
			int num = N / 10;
			
			// 평점 배열
			String[] gradeScore = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			
			
			Map<Integer, Double> score = new HashMap<>();	// 총점과 학생 번호를 저장
			Map<Integer, String> grade = new HashMap<>();	// 상대평가에 따라서 학생의 평점 저장
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				double midterm = Integer.parseInt(st.nextToken()) * 0.35;	// 중간고사
				double finterm = Integer.parseInt(st.nextToken()) * 0.45;	// 기말고사
				double project = Integer.parseInt(st.nextToken()) * 0.2;	// 과제
				
				double sum = midterm + finterm + project;	// 총점
				
				score.put(i+1, sum);	// 학생 번호랑 총점을 저장		
			}
			
			
			// map 정렬을 위한 List
			List<Integer> keys = new ArrayList<>(score.keySet());
			
			// 내림차순으로 정렬
			Collections.sort(keys, (v1, v2) -> (score.get(v2).compareTo(score.get(v1))));

			

			int cnt = -1; // 등급 넣을 인덱스
			// 등급 저장
			for(int i = 0; i < N; i+=num) {
				cnt++;
				for(int j = 0; j < num; j++) {
					grade.put(keys.get(i+j), gradeScore[cnt]);
				}
			}
			

			
			System.out.println("#" + t + " " + grade.get(K));
		}
		
		
		
		
	}
}
