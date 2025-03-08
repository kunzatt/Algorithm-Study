import java.io.*;
import java.util.*;

class Main {
    static int N;
    static HashSet<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        
        for(int i = 0; i < arr.size(); i++) {
             System.out.print(arr.get(i) + " ");   
        }
    }
}
