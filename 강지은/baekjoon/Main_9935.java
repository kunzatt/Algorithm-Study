import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            
            if(stack.size() >= bomb.length()) {
                boolean isBomb = true;
                for(int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                
                if(isBomb) {
                    for(int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(char c : stack) {
            result.append(c);
        }
        
        System.out.println(result.length() == 0 ? "FRULA" : result.toString());
    }
}
