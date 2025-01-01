import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 수열과 쿼리 15 / 골드 3 / 13:16 ~ 14:46
public class BOJ_14427 {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int n;

    static class SegTree{
        int[] tree;

        SegTree(){
            tree=new int[n*4];
            init(1,1,n);
        }

        void init(int node,int start,int end){
            if(start==end){
                tree[node]=start;
                return;
            }
            int mid=(start+end)/2;
            init(node*2,start,mid);
            init(node*2+1,mid+1,end);
            if(arr[tree[node*2]]<arr[tree[node*2+1]]){
                tree[node]=tree[node*2];
            }else if(arr[tree[node*2]]>arr[tree[node*2+1]]){
                tree[node]=tree[node*2+1];
            }else{
                tree[node]=Math.min(tree[node*2],tree[node*2+1]);
            }
        }

        void update(int node,int start,int end,int idx){
            if(idx<start||end<idx)return;
            if(start==end){
                tree[node]=idx;
            }else{
                int mid=(start+end)/2;
                update(node*2,start,mid,idx);
                update(node*2+1,mid+1,end,idx);
                if(arr[tree[node*2]]<arr[tree[node*2+1]]){
                    tree[node]=tree[node*2];
                }else if(arr[tree[node*2]]>arr[tree[node*2+1]]){
                    tree[node]=tree[node*2+1];
                }else{
                    tree[node]=Math.min(tree[node*2],tree[node*2+1]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        SegTree t=new SegTree();
        int q=Integer.parseInt(br.readLine());
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int c=Integer.parseInt(st.nextToken());
            if(c==1){
                int idx=Integer.parseInt(st.nextToken());
                int num=Integer.parseInt(st.nextToken());
                arr[idx]=num;
                t.update(1,1,n,idx);
            }else{
                System.out.println(t.tree[1]);
            }
        }
    }
}
