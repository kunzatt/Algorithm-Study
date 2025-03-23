package baekjoon;

import java.util.Scanner;

public class BOJ_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        int[] arr=new int[k];
        long end=0;
        for(int i=0;i<k;i++){
            arr[i]=sc.nextInt();
            end=Math.max(end,arr[i]);
        }
        long start=1;
        long ans=0;
        while(start<=end){
            long mid=(start+end)/2;
            long count=0;
            for(int i=0;i<k;i++){
                count+=arr[i]/mid;
            }
            if(count<n){
                end=mid-1;
            }else{
                ans=mid;
                start=mid+1;
            }
        }
        System.out.println(ans);
    }
}
