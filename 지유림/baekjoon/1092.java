import java.io.*;
import java.util.*;

public class Main1092_배 {
    static int N, M;
    static ArrayList<Integer> weight;
    static ArrayList<Integer> box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        weight = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            weight.add(Integer.parseInt(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());
        box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(weight, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if(box.get(0) > weight.get(0)) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        while(!box.isEmpty()) {
            int cnt = 0;
            for(int i = 0; i < N;) {
                if(cnt == box.size()) break;
                else if(weight.get(i) >= box.get(cnt)) {
                    box.remove(cnt);
                    i++;
                } else cnt++;
            }

            result++;
        }

        System.out.println(result);


    }
}
