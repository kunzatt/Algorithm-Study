import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 공장 12:40~14:54
public class BOJ_7578 {
    static class SegTree{
        long[] tree;
        int size;
        SegTree(int n){
            tree=new long[n*4];
            size=n;
        }
        void update(int node,int start,int end,int idx){
            if(end<idx||idx<start)return;
            if(start==end){
                tree[node]++;
                return;
            }
            int mid=(start+end)>>1;
            update(node<<1,start,mid,idx);
            update(node<<1|1,mid+1,end,idx);
            tree[node]=tree[node<<1]+tree[node<<1|1];
        }
        long query(int node,int start,int end,int left,int right){
            if(right<start||end<left)return 0;
            if(left<=start&&end<=right)return tree[node];
            int mid=(start+end)>>1;
            return query(node<<1,start,mid,left,right)+
                    query(node<<1|1,mid+1,end,left,right);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n+1];
        int[] b=new int[n+1];
        int[]bpos=new int[1000001];

        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            a[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            b[i]=Integer.parseInt(st.nextToken());
            bpos[b[i]]=i;
        }
        SegTree t=new SegTree(n);
        long inversion=0;
        // a의값이 b에어디에위치한지 ㅇ찾고
        //b 이후에 처리된inversion만큼 더해야함
        for(int i=1;i<=n;i++){
            int idx=bpos[a[i]];
            inversion+=t.query(1,1,n,idx+1,n);
            t.update(1,1,n,idx);
        }
        System.out.println(inversion);
    }
}