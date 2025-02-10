import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_1248_공통조상 {
    static int T;
    static int V, E, A, B;
    static ArrayList<Integer>[] tree;
    static int[] par;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            par = new int[V+1];
            tree = new ArrayList[V+1];
            	
            for(int i=1; i<=V; i++){
                tree[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<E; i++){
                int p = Integer.parseInt(st.nextToken());
                int ch = Integer.parseInt(st.nextToken());
                tree[p].add(ch);
                par[ch] = p;
            }

            int anc = findCommon(A, B);
            int size = getSubTree(anc);

            System.out.println("#"+tc+" "+anc+" "+size);
        }


    }

	private static int getSubTree(int node) {
		int size = 1;
		for(int child: tree[node]) {
			size += getSubTree(child);
		}
		return size;
	}

	private static int findCommon(int a, int b) {
		Set<Integer> aAnc = new HashSet<Integer>();
		while(a != 0) {
			aAnc.add(a);
			a = par[a];
		}
		
		while(b != 0) {
			if(aAnc.contains(b)) {
				return b;
			}
			b = par[b];
		}
		return 1;
	}
}
