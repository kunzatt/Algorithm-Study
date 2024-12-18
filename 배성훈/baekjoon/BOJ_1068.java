import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1068. 트리 / 골드5 / 26분
// 간선 배열과 DFS 를 활용해 쉽게 해결할 수 있다
public class BOJ_1068 {
    static class Node {
        int parent;
        List<Integer> child;

        Node(int parent) {
            this.parent = parent;
            child = new ArrayList<>();
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, d, root;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(play());
    }

    private static int play() {
        int p = tree[d].parent;
        if (p == -1) {
            return 0;
        }
        for (int i = 0; i < tree[p].child.size(); i++) {
            if (tree[p].child.get(i) == d) {
                tree[p].child.remove(i);
                break;
            }
        }
        int leaf = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int count = 0;
            for (int next : tree[cur].child) {
                count++;
                q.add(next);
            }
            if (count == 0) {
                leaf++;
            }
        }
        return leaf;
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        tree = new Node[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = new Node(0);
        }
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            tree[i].parent = parent;
            if (parent != -1) {
                tree[parent].child.add(i);
            } else {
                root = i;
            }
        }
        d = Integer.parseInt(br.readLine());
    }
}