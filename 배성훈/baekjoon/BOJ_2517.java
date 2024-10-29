import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 좌표압축+세그먼트트리
// 10:26~2:12
public class BOJ_2517 {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] arr;
    static int[] sorted;
    static Map<Integer,Integer>compressed=new HashMap<>();
    static int[] tree;

    public static void main(String[] args)throws IOException {
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1];
        sorted=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(br.readLine());
            sorted[i]=arr[i];
        }
        Arrays.sort(sorted);
        for(int i=1;i<=n;i++){
            compressed.put(sorted[i],i);
        }
        for(int i=1;i<=n;i++){
            arr[i]=compressed.get(arr[i]);
        }

        tree=new int[4*n];
        for(int i=1;i<=n;i++){
            sb.append(i-query(1,1,n,1,arr[i])).append("\n");
            update(1,1,n,arr[i]);
        }
        System.out.print(sb);
    }

    private static int query(int node,int start,int end,int left,int right){
        if(right<start||end<left)return 0;
        if(left<=start&&end<=right)return tree[node];
        int mid=(start+end)/2;
        return query(node*2,start,mid,left,right)+
                query(node*2+1,mid+1,end,left,right);
    }

    private static void update(int node,int start,int end,int idx){
        if(idx<start||end<idx)return;
        if(start==end){
            tree[node]++;
            return;
        }
        int mid=(start+end)/2;
        update(node*2,start,mid,idx);
        update(node*2+1,mid+1,end,idx);
        tree[node]=tree[node*2]+tree[node*2+1];
    }
}