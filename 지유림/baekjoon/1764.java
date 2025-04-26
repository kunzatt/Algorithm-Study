import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        HashSet<String> noHear = new HashSet<>();
        for(int i = 0; i < N; i++) {
            noHear.add(br.readLine());
        }
        
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            if(noHear.contains(name)) {
                result.add(name);
            }
        }
        
        Collections.sort(result);
        
        sb.append(result.size()).append("\n");
        
        for(String name : result) {
            sb.append(name).append("\n");
        }
        
        System.out.println(sb);
        
    }
}
