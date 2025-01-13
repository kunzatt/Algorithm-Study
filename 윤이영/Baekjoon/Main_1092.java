import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main_1092 {
	public static int N,M;
	public static ArrayList<Integer> crain = new ArrayList<>();
	public static ArrayList<Integer> box = new ArrayList<>();
	public static int answer = 0 ;
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 크레인 입력
    	N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		crain.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	
    	// 박스 입력
        M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<M;i++) {
    		box.add(Integer.parseInt(st.nextToken()));
    	}
    	
   
    	Collections.sort(crain, Collections.reverseOrder());
    	Collections.sort(box, Collections.reverseOrder());
    	
    	// 가장 무거운 박스를 가장 큰 크레인이 들 수 없으면 -1 출력
    	if( crain.get(0) < box.get(0)) {
    		System.out.println("-1"); 
    		return;
    	}
    	
    	while(box.size() > 0) {
    		int boxIdx = 0;
    		for(int i=0;i<crain.size(); ) {
    			if(crain.get(i) >= box.get(boxIdx)) {
    				i++;
    				box.remove(boxIdx);
    			}
    			else if(crain.get(i) < box.get(boxIdx)) {
    				boxIdx++;
    			}
    			if(boxIdx == box.size()) break;
    		}
    		answer += 1;
    	}
    	
    	System.out.println(answer);
    	
    }
}