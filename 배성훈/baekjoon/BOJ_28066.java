package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_28066 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size()!=1){
            if(q.size()<k){
                System.out.println(q.peekFirst());
                return;
            }
            int num=q.poll();
            int temp=k;
            while(temp-->1){
                q.poll();
            }
            q.add(num);
        }
        System.out.println(q.peekFirst());
    }
}