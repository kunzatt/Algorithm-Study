import java.io.*;
import java.util.*;

public class Main_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ex = br.readLine();

        Stack<Character> stack = new Stack<>();

        char lastChar = ex.charAt(ex.length() - 1);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);

            if (c == lastChar && stack.size() >= ex.length()) {
                boolean flag = true;

                for (int j = 0; j < ex.length(); j++) {
                    if (stack.get(stack.size() - ex.length() + j) != ex.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < ex.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}