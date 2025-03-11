package baekjoon;

import java.util.Scanner;

public class BOJ_15668 {
    static long n;
    static boolean found;
    static int used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextLong();

        for(int i=1;i<=9;i++){
            used|=(1<<i);
            dfs(i,i);
            used&=~(1<<i);
            if(found)return;
        }
        System.out.println(-1);
    }


    private static void dfs(long num, long sum) {
        if (found || sum >= n) return;

        long remain=n-sum;
        if (check(remain)) {
            System.out.println(num+" + "+remain);
            found=true;
            return;
        }

        for (int i=0;i<=9;i++) {
            if ((used&(1<<i))!=0)continue;
            used|=(1<<i);
            dfs(num*10+i, sum*10+i);
            used&=~(1<<i);
        }
    }

    private static boolean check(long num) {
        int temp=used;
        while (num>0) {
            int d = (int)(num%10);
            if ((temp&(1<<d))!=0)return false;
            temp|=(1<<d);
            num/=10;
        }
        return true;
    }
}
