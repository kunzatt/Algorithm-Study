import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 16566. 카드 게임 / 플래5 / 38분
public class BOJ_16566 {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static int[] parent;
    static int n,m,k;

    public static void main(String[] args)throws IOException {
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[m];
        parent=new int[m+1];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            parent[i]=i;
        }
        Arrays.sort(arr);
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            int num=Integer.parseInt(st.nextToken());
            int idx=binarySearch(arr,num);
            idx=find(idx);
            sb.append(arr[idx]).append("\n");
            union(idx,idx+1);
        }
        System.out.print(sb);
    }

    private static int binarySearch(int[] arr,int num){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(num>=arr[mid]){
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return left;
    }

    private static int find(int x){
        if(x!=parent[x]){
            return parent[x]=find(parent[x]);
        }
        return x;
    }

    private static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b) return;
        if(a>b) parent[b]=a;
        else parent[a]=b;
    }
}