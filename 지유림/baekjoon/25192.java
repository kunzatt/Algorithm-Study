import java.io.*;
import java.util.*;

public class Main25192_인사성밝은곰곰이 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.equals("ENTER")) {
                map.clear();
            } else if(!map.containsKey(str)) {
                map.put(str, 1);
                result++;
            } else if(map.containsKey(str)) continue;
        }

        System.out.println(result);
    }
}
