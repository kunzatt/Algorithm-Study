import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String str;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int open = 0;
        int result = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                open++;
            } else {
                open--;

                if(str.charAt(i-1) == '(') {
                    result += open;
                } else result++;
            }
        }

        System.out.println(result);
    }
}
