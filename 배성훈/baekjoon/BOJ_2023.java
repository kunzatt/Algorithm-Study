package baekjoon;

import java.util.*;

public class BOJ_2023 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=9;i++){
            play(String.valueOf(i));
        }
    }

    private static void play(String cur){
        int num=Integer.parseInt(cur);
        if(!isPrime(num))return;
        if(cur.length()==n){
            System.out.println(num);
            return;
        }
        for(int i=1;i<=9;i+=2){
            play(cur+i);
        }
    }

    private static boolean isPrime(int num){
        while(num>0){
            if(num==2)return true;
            if(num<2||num%2==0)return false;
            int sqrt=(int)Math.sqrt(num);
            for(int i=3;i<=sqrt;i+=2){
                if(num%i==0)return false;
            }
            num/=10;
        }
        return true;
    }
}