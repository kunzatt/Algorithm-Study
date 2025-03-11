import java.io.*;
import java.util.*;

public class Main_1105 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String second = st.nextToken();

        int count = 0;

        if (first.length() == second.length()){
            for (int i = 0; i < second.length(); i++) {
                if (second.charAt(i) != first.charAt(i)) break;
                else {
                    if (first.charAt(i) == '8') count++;
                }
            }
        }

        System.out.println(count);

    }
}
