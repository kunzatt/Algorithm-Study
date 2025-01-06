import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
[BOJ] 칵테일 / 골드 2 / 12:11 ~14:39
 */
class BOJ_1033 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Node>[] adj;
    static boolean[] visited;
    static Fraction[] arr;

    static class Node {
        int to;
        long p,q;
        Node(int to, long p, long q){
            this.to =to;
            this.p=p;
            this.q=q;
        }
    }
    static class Fraction{
        long up,down;

        Fraction(long up,long down){
            this.up=up;
            this.down=down;
        }
    }

    public static void main(String[] args)throws IOException {
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        arr=new Fraction[n];
        visited=new boolean[n];
        adj=new List[n+1];
        for (int i=0;i<n;i++) {
            adj[i]=new ArrayList<>();
        }

        arr[0] = new Fraction(1,1);
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            int q=Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b,p,q));
            adj[b].add(new Node(a,q,p));
        }
        arr[0]=new Fraction(1,1);
        visited[0]=true;
        dfs(0);
        long lcm=1;
        for(Fraction f:arr){
            lcm=lcm(lcm,f.down);
        }
        for(Fraction f:arr){
            f.up*=(lcm/f.down);
        }
        long gcd=arr[0].up;
        for(int i=1;i<n;i++){
            gcd=gcd(gcd,arr[i].up);
        }
        for(Fraction f:arr){
            System.out.print(f.up/gcd+" ");
        }
    }

    private static void dfs(int cur){
        for(Node next:adj[cur]){
            if(!visited[next.to]){
                visited[next.to]=true;
                arr[next.to]=new Fraction(arr[cur].up*next.q,arr[cur].down*next.p);
                dfs(next.to);
            }
        }
    }

    private static long lcm(long a,long b){
        return a/gcd(a,b)*b;
    }

    private static long gcd(long a,long b) {
        if(b==0)return a;
        return gcd(b,a%b);
    }
}