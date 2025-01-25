import java.util.*;

// [BOJ] 구간 나누기 2 / 골드 4 / 43분
public class BOJ_13397 {
    static Scanner sc = new Scanner(System.in);
    static int n,m;
    static int[] arr;

    public static void main(String[] args) {
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
        }
        int low=0;
        int high=max;
        while(low<high){
            int mid=(low+high)/2;
            if(play(mid)<=m){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        System.out.println(high);
    }

    private static int play(int mid){
        int cnt=1;
        int min=11111;
        int max=0;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
            if(max-min>mid){
                cnt++; //구간 증가
                min=11111;
                max=0;
                i--;
            }
        }
        return cnt;
    }
}