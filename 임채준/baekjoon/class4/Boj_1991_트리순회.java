package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node{
    char data;
    Node left;
    Node right;
    Node(char data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Boj_1991_트리순회 {

    static BufferedReader br;
    static int N;
    static Node[] tree;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new Node[26];

        for(int i = 0; i < 26; i++){
            tree[i] = new Node((char)('A' + i));
        }

        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            char parent = input[0];
            char left = input[2];
            char right = input[4];

            if(left != '.'){
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if(right != '.'){
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);

    }

    private static void preorder(Node node) {
        if(node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }


}