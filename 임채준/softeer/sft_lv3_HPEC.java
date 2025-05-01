package src.sft;

import java.io.*;
import java.util.*;

public class sft_lv3_HPEC {

    static int N, P, C, X;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<int[]> que = new LinkedList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int[] celeb = new int[2];
            celeb[0] = P;
            celeb[1] = C;
            que.offer(celeb);
        }

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int p = cur[0];
            int c = cur[1];
            if(Math.abs(p - X) <= c){
                X++;
            }
        }

        System.out.println(X);
    }
}