import java.io.*;

// 백준 5639. 이진 검색 트리 / 골드4 / 50분
// 노드 클래스와, 특정 노드를 삽입하는 테크닉, 그리고 전위/중위/후위 순회의 개념을 알고 있다면 굉장히 쉬운 문제이다.
public class BOJ_5639 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.value) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String input = "";
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            input = br.readLine();
            if (input == null || input == "") {
                break;
            }
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void postOrder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        bw.write(node.value + "\n");
    }
}
