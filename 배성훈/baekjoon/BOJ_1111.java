package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1111 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        //ax+b
        //a=(y2-y1)/(x2-x1)

        if(n==1){
            System.out.println("A");
            return;
        }
        if(n==2){
            if(arr[0]==arr[1]){
                System.out.println(arr[0]);
            }else{
                System.out.println("A");
            }
            return;
        }

        int a=0;
        int b=0;
        if(arr[0]!=arr[1]){
            a=(arr[2]-arr[1])/(arr[1]-arr[0]);
        }
        b=arr[1]-arr[0]*a;
        for(int i=0;i<n-1;i++){
            int num=a*arr[i]+b;
            if(arr[i+1]!=num){
                System.out.println("B");
                return;
            }
        }
        System.out.println(arr[n-1]*a+b);


    }
}