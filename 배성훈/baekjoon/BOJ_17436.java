package baekjoon;

import java.util.Scanner;

public class BOJ_17436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //포배
        //홀수의 최소공배수는 더하고 짝수의 최소공배수는 빼라
        int n=sc.nextInt();
        long m=sc.nextLong();
        int[] sosu=new int[n];
        for(int i=0;i<n;i++){
            sosu[i]=sc.nextInt();
        }
        long result=0;
        for(int i=1;i<(1<<n);i++){
            long multiple=1;
            int bits=Integer.bitCount(i);

            for (int j=0; j<n;j++) {
                if ((i&(1 << j))!=0) {
                    multiple=lcm(multiple,sosu[j]);
                    if (multiple>m) break;
                }
            }
            if (multiple>m) continue;
            long count=m/multiple;
            if (bits%2 == 1) {
                result+=count;
            } else {
                result-=count;
            }
        }
        System.out.println(result);
    }

    private static long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    private static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
}
