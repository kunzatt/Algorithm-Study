import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {
	static int N; //스위치 개수
	static int[] arr;
	static int student;
	static int s;	// 성별
	static int snum; // 스위치
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];	// 스위치 번호와 인덱스 번호의 일치를 위해서 +1
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		student = Integer.parseInt(br.readLine());
		for(int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			snum = Integer.parseInt(st.nextToken());
			
			if(s==1) {	// 남학생 - 배수인 스위치를 끄기
				for (int j = 0; j < arr.length; j++) {
					if(j % snum == 0)	// 배수 확인
						changeSwitch(j);	
				}
			}	
			if(s == 2) {	//  여학생 - 대칭인지 확인
				int si=1;
				changeSwitch(snum);
				while(snum-si >= 1 && snum+si <= N ) {	// 범위 내에 있는지 확인
					if(arr[snum-si] == arr[snum+si]) {
						changeSwitch(snum-si);
						changeSwitch(snum+si);
						//System.out.println(snum-si);
					}else 
						break;
					si++;	
				}			
			}	
		}
		// 결과 출력 - StringBuilder 사용
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(arr[i]+" ");
			if(i%20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	// 스위치 켜고 끄기
	private static void changeSwitch(int i) {
		if(arr[i] == 1)
			arr[i] = 0;
		else
			arr[i] = 1;
		
	}

}
