import java.util.*;

class PGS_올바른괄호 {

    boolean solution(String s) {

        boolean answer = true;
        char[] c = s.toCharArray();
        int len = c.length;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < len; i++){
            if(c[i] == '('){
                stack.push(c[i]);
            } else {
                if(stack.isEmpty()){
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }

}