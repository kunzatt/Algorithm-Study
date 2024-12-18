import java.util.ArrayList;
import java.util.Scanner;

public class Main_16987 {
	
    static int N;
    static ArrayList<int[]> list = new ArrayList<>();
    static int result = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        for(int i = 0 ;i < N; i++) {
            list.add(new int[] {sc.nextInt(), sc.nextInt()});
        }
        
        dfs(0,0);
        System.out.println(result);

    }
    static void dfs(int idx, int cnt) {
        if(idx == N) {
            result = Math.max(result, cnt);
            return;
        }
        
        if(list.get(idx)[0]<= 0 || cnt == N-1) {
			dfs(idx + 1, cnt);
			return;
		}
        
        int nCnt = cnt;
        for(int i = 0; i <N; i++) {
            if(i == idx || list.get(i)[0] <= 0) continue;
            
            list.get(i)[0] -= list.get(idx)[1];
            if(list.get(i)[0] <= 0) nCnt++;
            list.get(idx)[0] -= list.get(i)[1];
            if(list.get(idx)[0] <= 0) nCnt++;
            dfs(idx+1, nCnt); 
            list.get(i)[0] += list.get(idx)[1];
            list.get(idx)[0] += list.get(i)[1];           
            nCnt = cnt;
        }
    }

}