package class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Boj_3052 {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            set.add(num % 42);
        }
        
        System.out.println(set.size());
    }
}