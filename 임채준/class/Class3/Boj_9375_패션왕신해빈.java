package class3;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_9375_패션왕신해빈 {
    
    static int T, N;
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            Map<String, Integer> clothesMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken(); 
                String type = st.nextToken();
                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
            }
            long result = 1;
            for (int count : clothesMap.values()) {
                result *= (count + 1);
            }
            result -= 1;
            System.out.println(result);
        }
    }
}