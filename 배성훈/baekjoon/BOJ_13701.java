package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_13701 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        Set<Integer> numbers=new HashSet<>();
        while(st.hasMoreTokens()){
            int num=Integer.parseInt(st.nextToken());
            if(numbers.add(num)){
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb);
    }
}
