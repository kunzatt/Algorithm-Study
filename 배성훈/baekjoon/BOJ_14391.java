package baekjoon;

import java.util.Scanner;

public class BOJ_14391 {

    static int n,m;
    static int[][] arr;
    static int max=0;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();
        arr=new int[n][m];
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            for(int j=0;j<m;j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }
        int full=1<<(n*m);
        for(int bit=0;bit<full;bit++){
            max=Math.max(max,play(bit));
        }
        System.out.println(max);
    }

    private static int play(int bit){
        int sum=0;
        //가로계산(0)
        for(int i=0;i<n;i++){
            int row=0;
            for(int j=0;j<m;j++){
                int idx=i*m+j;
                if((bit&(1<<idx))==0){
                    row=row*10+arr[i][j];
                }else{
                    sum+=row;
                    row=0;
                }
            }
            sum+=row;
        }
        //세로계산(1)
        for(int j=0;j<m;j++){
            int col=0;
            for(int i=0;i<n;i++){
                int idx=i*m+j;
                if((bit&(1<<idx))!=0){
                    col=col*10+arr[i][j];
                }else{
                    sum+=col;
                    col=0;
                }
            }
            sum+=col;
        }
        return sum;
    }
}
