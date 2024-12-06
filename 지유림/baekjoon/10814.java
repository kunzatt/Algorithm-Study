import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[][] arr = new String[N][2];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            arr[i][0] = st.nextToken().toString();
            arr[i][1] = st.nextToken().toString();
        }
        
        Arrays.sort(arr, new Comparator<String[]>() {
            // 나이순으로 먼저 정렬
            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        for(int i = 0; i < N; i++) {
               System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
