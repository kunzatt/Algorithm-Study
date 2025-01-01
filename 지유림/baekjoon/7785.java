import java.io.*;
import java.util.*;

public class Main7785_회사에있는사람 {
    static int N;
    static Map<String, String> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String access = st.nextToken();

            if(!map.containsKey(name)) {
                map.put(name, access);
            } else {
                map.remove(name);
            }
        }

        List<String> names = new ArrayList<>(map.keySet());
        Collections.sort(names, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < names.size(); i++) {
            sb.append(names.get(i) + "\n");
        }

        System.out.println(sb.toString());

    }
}
