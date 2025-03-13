package class3;

import java.io.*;
import java.util.*;

public class Boj_5525_IOIOI {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int result = findpattern(S, N);
        System.out.println(result);
    }

    public static int findpattern(String s, int n) {
        int count = 0;
        int patternCount = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
                patternCount++;
                if (patternCount >= n) {
                    count++;
                }
                i++;
            } else {
                patternCount = 0;
            }
        }
        return count;
    }
}
