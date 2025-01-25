package baekjoon;

import java.util.*;

public class BOJ_4358 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String,Integer>map=new TreeMap<>();
        int n=0;
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            map.merge(s,1,Integer::sum);
            n++;
        }
        for(String s:map.keySet()){
            double num=((double) map.get(s) /n)*100;
            System.out.printf("%s %.4f\n",s,num);
        }
    }
}
