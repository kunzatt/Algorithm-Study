import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> arr;
	static int d[];
    static int N, M, R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken())-1;
		
		d = new int[N];
	    arr=new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr.add(new ArrayList<>());
			d[i] = -1;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		
		for(int i = 0; i < N; i++) {
			Collections.sort(arr.get(i), Collections.reverseOrder() );
		}
		
		d[R]=0;
		dfs(R);
        StringBuilder sb = new StringBuilder();                                                                     
                                          
		for(int i = 0; i < N; i++) {
            sb.append(d[i] + "\n");
		}
        
        System.out.println(sb);                                      
		
                                              
	}

	private static void dfs(int r) {
		for(int i=0; i<arr.get(r).size(); i++) {
			if(d[arr.get(r).get(i)]==-1) {
				d[arr.get(r).get(i)]=d[r]+1;
				dfs(arr.get(r).get(i));
			}
		}
	}
}
