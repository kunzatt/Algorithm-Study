import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String start = st.nextToken();
        String fin = st.nextToken();
        String end = st.nextToken();

        Set<String> sset = new HashSet<>();
        Set<String> fset = new HashSet<>();
        Set<String> eset = new HashSet<>();
        String str = null;

        while((str = br.readLine()) != null) {
            String[] arr = str.split(" ");
            String time = arr[0];
            String name = arr[1];

            eset.add(name);
            if(start.compareTo(time) >= 0) {
                sset.add(name);
            }else if(fin.compareTo(time) <= 0 && end.compareTo(time) >= 0) {
                fset.add(name);
            }
        }

        int ans = 0;
        for(String name : eset) {
            if(sset.contains(name) && fset.contains(name)) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}