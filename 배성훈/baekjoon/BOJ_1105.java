package baekjoon;

import java.util.*;

public class BOJ_1105 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        String a=input[0];
        String b=input[1];
        if(a.length()!=b.length()){
            System.out.println(0);
        }else{
            int ans=0;
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!=b.charAt(i))break;
                if(a.charAt(i)==b.charAt(i)&&a.charAt(i)=='8'){
                    ans++;
                }
            }
            System.out.println(ans);
        }

    }
}