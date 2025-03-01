import java.util.Scanner;
import java.util.Stack;

public class Main_4889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=1;
        while(true) {
            String s = sc.next();
            if(s.contains("-")) break;

            int cnt = 0;
            Stack<Character> stack = new Stack<Character>();

            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(c == '{') {
                    stack.add(c);
                }
                else {
                    if(stack.isEmpty()) {
                        cnt++;
                        stack.add('{');
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            cnt += stack.size()/2;
            System.out.println(t++ +". "+cnt);
        }
    }
}
