import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1360 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static ArrayList<Node> list;
    
    static class Node {
        String str;
        int time;
        
        public Node(String str, int time) {
            this.str = str;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        System.out.print(list.get(N).str);
    }
    
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        list.add(new Node("", 0));
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("type")) {
                Node pre = list.get(i - 1);
                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                list.add(new Node(pre.str + c, n));
            } else {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                undo(i, end - start - 1, end);
            }
        }
        
    }
    
    static void undo(int cur_idx, int target_time, int cur_time) {
        boolean flag = false;
        for (int i = cur_idx - 1; i >= 0; i--) {
            if (target_time < 0) break;
            Node cur = list.get(i);
            if (cur.time <= target_time) {
                list.add(new Node(cur.str, cur_time));
                flag = true;
                break;
            }
        }
        if (!flag) {
            list.add(new Node("", cur_time));
        }
    }
    
}