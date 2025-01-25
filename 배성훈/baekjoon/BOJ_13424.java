package baekjoon;

import java.util.*;

public class BOJ_13424 {
    static int n,m,k;
    static List<Node>[] adj;
    static List<Integer> friends;
    static int ans;
    static int ansIdx;
    static int[][] dist;

    static class Node implements Comparable<Node>{
        int to,dist;
        Node(int to,int dist){
            this.to=to;
            this.dist=dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist-o.dist;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            ans=Integer.MAX_VALUE;
            ansIdx=-1;
            n=sc.nextInt();
            m=sc.nextInt();
            adj=new List[n+1];
            for(int i=1;i<=n;i++){
                adj[i]=new ArrayList<>();
            }
            friends=new ArrayList<>();
            for(int i=0;i<m;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                adj[a].add(new Node(b,c));
                adj[b].add(new Node(a,c));
            }
            k=sc.nextInt();
            dist=new int[k][n+1];
            for(int i=0;i<k;i++){
                friends.add(sc.nextInt());
            }
            for(int i=0;i<k;i++){
                dijkstra(i);
            }
            for(int i=1;i<=n;i++){
                int total=0;
                boolean possible=true;
                for(int j=0;j<k;j++){
                    if(dist[j][i]==Integer.MAX_VALUE){
                        possible=false;
                        break;
                    }
                    total+=dist[j][i];
                }
                if(ans>total&&possible){
                    ans=total;
                    ansIdx=i;
                }
            }
            System.out.println(ansIdx);
        }
    }

    private static void dijkstra(int idx){
        int[] d=new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        PriorityQueue<Node>pq=new PriorityQueue<>();
        int start=friends.get(idx);
        d[start]=0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node=pq.poll();
            if(node.dist>d[node.to]) continue;
            for(Node next:adj[node.to]){
                if(d[next.to]>d[node.to]+next.dist){
                    d[next.to]=d[node.to]+next.dist;
                    pq.add(new Node(next.to,d[next.to]));
                }
            }
        }
        dist[idx]=d;
    }
}
