import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 수열과 쿼리 21 / 플래티넘 4 / 11:00 ~ 11:32
public class BOJ_16975 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static long[] arr;

    static class SegTree {
        long[] tree;
        long[] lazy;

        SegTree() {
            tree = new long[n*4];
            lazy = new long[n*4];
            init(1,1,n);
        }

        void init(int node,int start,int end){
            if(start==end){
                tree[node]=arr[start];
                return;
            }
            int mid=(start+end)/2;
            init(node*2,start,mid);
            init(node*2+1,mid+1,end);
            tree[node]=tree[node*2]+tree[node*2+1];
        }

        void propagate(int node,int start,int end){
            if(lazy[node]!=0){
                tree[node]+=(end-start+1)*lazy[node];
                if(start!=end){
                    lazy[node*2]+=lazy[node];
                    lazy[node*2+1]+=lazy[node];
                }
                lazy[node]=0;
            }
        }

        void update(int node,int start,int end,int left,int right,long num){
            propagate(node,start,end);
            if(right<start||end<left)return;
            if(left<=start&&end<=right){
                tree[node]+=(end-start+1)*num;
                if(start!=end){
                    lazy[node*2]+=num;
                    lazy[node*2+1]+=num;
                }
                return;
            }
            int mid=(start+end)/2;
            update(node*2,start,mid,left,right,num);
            update(node*2+1,mid+1,end,left,right,num);
            tree[node]=tree[node*2]+tree[node*2+1];
        }

        long query(int node,int start,int end,int idx){
            propagate(node,start,end);
            if(idx<start||end<idx){
                return 0;
            }
            if(start==end){
                return tree[node];
            }
            int mid=(start+end)/2;
            if(idx<=mid){
                return query(node*2,start,mid,idx);
            }else{
                return query(node*2+1,mid+1,end,idx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n=Integer.parseInt(br.readLine());
        arr=new long[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        SegTree t=new SegTree();
        int m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int command=Integer.parseInt(st.nextToken());
            if(command==1){
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                long c=Long.parseLong(st.nextToken());
                t.update(1,1,n,a,b,c);
            }else{
                int idx=Integer.parseInt(st.nextToken());
                System.out.println(t.query(1,1,n,idx));
            }
        }
    }
}
