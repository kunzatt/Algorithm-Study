import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25206 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] gradeList = new String[] {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "P", "F"};
		double [] gpaList = new double[] {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
		double gpasum = 0.0;
		double totalsum = 0.0;
		
		
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			String sub = st.nextToken();
			double gpa = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			for (int j = 0; j < 10; j++) {
				if(grade.equals(gradeList[j])) {
					totalsum += gpa * gpaList[j];
					if(!grade.equals(gradeList[8])) {
						gpasum += gpa;
					}
				}			
			}			
		}
		double avg = totalsum / gpasum;
		System.out.println(avg);
	}
}
