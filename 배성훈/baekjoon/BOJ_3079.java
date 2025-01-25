import java.util.*;

// [BOJ] 입국심사 / 골드 5 / 35분
class BOJ_3079 {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int n=sc.nextInt();
        int m = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        long low=1;
        long high=(long)arr[n-1]*m;
        while(low<=high){
            long mid=(low+high)/2;
            long sum=0;
            for(int i=0;i<n;i++){
                sum+=(mid/arr[i]);
                if(sum>=m)break;
            }
            if(sum<m){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        System.out.println(low);
    }

}