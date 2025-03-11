import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1689 {

    static int N;

    static class Node implements Comparable<Node> {
        int point;
        int val;

        public Node(int point, int val) {
            this.point = point;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (point == o.point) {
                return val - o.val;
            }
            return point - o.point;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        N = Integer.parseInt(br.readLine());
        List<Node> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr.add(new Node(start, 1));
            arr.add(new Node(end, -1));
        }

        Collections.sort(arr);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            Node cur = arr.get(i);

            sum += cur.val;
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
