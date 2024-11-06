import java.io.IOException;
import java.util.*;

public class BOJ_4196 extends FI {
    static int n,m,id;
    static int[] d;
    static boolean[] finished;
    static Stack<Integer> stack;
    static List<Integer>[] adj;
    static List<Set<Integer>> SCC;
    static int[] inDegree;
    static int[] sccId;

    public static void main(String[] args)throws IOException {
        initFI();
        int t=nextInt();
        while(t-->0){
            n=nextInt();
            m=nextInt();
            id=0;
            d=new int[n+1];
            finished=new boolean[n+1];
            stack=new Stack<>();
            adj=new List[n+1];
            SCC=new ArrayList<>();
            sccId=new int[n+1];

            for(int i=0;i<=n;i++){
                adj[i]=new ArrayList<>();
            }
            for(int i=0;i<m;i++){
                adj[nextInt()].add(nextInt());
            }
            for(int i=1;i<=n;i++){
                if(d[i]==0)dfs(i);
            }
            for(int i=0;i<SCC.size();i++){
                for(int a:SCC.get(i)){
                    sccId[a]=i;
                }
            }
            inDegree=new int[SCC.size()];
            for(int i=1;i<=n;i++){
                int curscc=sccId[i];
                for(int next:adj[i]){
                    int nextscc=sccId[next];
                    if(curscc!=nextscc)inDegree[nextscc]++;
                }
            }
            int count=0;
            for(int i=0;i<inDegree.length;i++){
                if(inDegree[i]==0)count++;
            }
            System.out.println(count);
        }
    }

    private static int dfs(int v) {
        d[v]=++id;
        stack.push(v);
        int p=d[v];
        for(int next:adj[v]){
            if(d[next]==0){
                p=Math.min(p,dfs(next));
            }else if(!finished[next]){
                p=Math.min(p,d[next]);
            }
        }
        if(p==d[v]){
            Set<Integer> scc=new HashSet<>();
            while(true){
                int t=stack.pop();
                scc.add(t);
                finished[t]=true;
                if(t==v)break;
            }
            SCC.add(scc);
        }
        return p;
    }
}
