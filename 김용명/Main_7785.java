import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7785 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String condition = st.nextToken();
            
            if (condition.equals("enter")) {
                set.add(name);
            } else if (condition.equals("leave")) {
                set.remove(name);
            }
        }
        
        List<String> result = new ArrayList<>(set);
        Collections.sort(result, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : result) {
            sb.append(s).append('\n');
        }
        
        System.out.print(sb);
    }
}