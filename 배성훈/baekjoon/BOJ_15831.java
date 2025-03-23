package baekjoon;

import java.util.Scanner;

public class BOJ_15831 {
    static int n,b,w;
    static char[] s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        b=sc.nextInt();
        w=sc.nextInt();
        sc.nextLine();
        s=sc.nextLine().toCharArray();
        int bcount=0;
        int wcount=0;
        int ans=0;
        int left=0;
        for(int right=0;right<n;right++){
            if(s[right]=='W'){
                wcount++;
            }else{
                bcount++;
            }
            while(bcount>b){
                if(s[left]=='B')bcount--;
                else wcount--;
                left++;
            }
            if(wcount>=w){
                ans=Math.max(ans,right-left+1);
            }
        }
        System.out.println(ans);
    }
}
