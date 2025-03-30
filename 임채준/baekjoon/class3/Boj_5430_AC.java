package class3;

import java.io.*;
import java.util.*;

public class Boj_5430_AC {

    static int T, n;
    static String p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());

            String line = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            
            line = line.substring(1, line.length() - 1);
            if (!line.isEmpty()) {
                String[] nums = line.split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }
            
            String result = process(deque, p);
            sb.append(result).append("\n");
        }
        
        System.out.print(sb);
    }

    public static String process(Deque<Integer> deque, String commands) {
        boolean isReversed = false;
        
        for (char cmd : commands.toCharArray()) {
            if (cmd == 'R') {
                isReversed = !isReversed;
            } else if (cmd == 'D') {
                if (deque.isEmpty()) {
                    return "error";
                }
                if (isReversed) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }
        
        return dequeToString(deque, isReversed);
    }

    public static String dequeToString(Deque<Integer> deque, boolean isReversed) {
        StringBuilder result = new StringBuilder("[");
        
        if (!deque.isEmpty()) {
            if (isReversed) {
                Iterator<Integer> it = deque.descendingIterator();
                result.append(it.next());
                while (it.hasNext()) {
                    result.append(",").append(it.next());
                }
            } else {
                Iterator<Integer> it = deque.iterator();
                result.append(it.next());
                while (it.hasNext()) {
                    result.append(",").append(it.next());
                }
            }
        }
        
        result.append("]");
        return result.toString();
    }
}