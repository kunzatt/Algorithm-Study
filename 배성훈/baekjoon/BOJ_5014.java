package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5014 {
    static int f,s,g,u,d;
    static int min=Integer.MAX_VALUE;
    static boolean[] visited=new boolean[2211111];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f=sc.nextInt();
        s=sc.nextInt();
        g=sc.nextInt();
        u=sc.nextInt();
        d=sc.nextInt();
        play();
        System.out.println(min==Integer.MAX_VALUE?"use the stairs":min);
    }

    private static void play(){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{s,0});

        while(!q.isEmpty()){
            int[]info=q.poll();
            int cur=info[0];
            int click=info[1];
            if(cur==g){
                min=click;
                break;
            }
            if (cur-d>=1&&!visited[cur - d]) {
                visited[cur-d]=true;
                q.add(new int[]{cur-d,click+1});
            }
            if(cur+u<=f&&!visited[cur+u]){
                visited[cur+u]=true;
                q.add(new int[]{cur+u,click+1});
            }
        }
    }
}
