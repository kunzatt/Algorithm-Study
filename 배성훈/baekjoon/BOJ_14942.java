import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 14942. 개미 / 플래티넘 5 / 10:21~11:29
// dfs, 경로추적
public class BOJ_14942 extends FI1 {
    static int n;
    static int[] ant;
    static int[] reach;
    static boolean[] visited;
    static List<Node>[] adj;
    static Deque<Node> path;
    static class Node{
        int to;
        int cost;
        Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    public static void main(String[] args) throws IOException {
        initFI();
        n=nextInt();
        ant=new int[n+1];
        reach=new int[n+1];
        visited=new boolean[n+1];
        path=new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            ant[i]=nextInt();
        }
        adj=new List[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            int a=nextInt();
            int b=nextInt();
            int c=nextInt();
            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
        }
        reach[1]=1;
        dfs(1,0);
        for(int i=1;i<=n;i++){
            System.out.println(reach[i]);
        }
    }
    // 다음 갈 번호, 현재 저장돤 굴 길이
    private static void dfs(int cur,int dist){
        visited[cur]=true;
        for(Node next:adj[cur]){
            if(!visited[next.to]){
                path.addLast(next);
                int ndist=dist+next.cost;
                if(ndist<=ant[next.to]){
                    reach[next.to]=1;
                }else{
                    int temp=ndist;
                    Deque<Node> td=new ArrayDeque<>(path);
                    while(!td.isEmpty()){
                        Node node=td.pollFirst();
                        temp-=node.cost;
                        if(temp<=ant[next.to]){
                            reach[next.to]=node.to;
                            break;
                        }
                    }
                }
                dfs(next.to,ndist);
                path.pollLast();
            }
        }
    }
}