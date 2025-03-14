import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1991 {
	
    static int N;
    static List<Node> list;
    static StringBuilder sb;
    
    static class Node implements Comparable<Node> {
    	char root;
    	char left;
    	char right;
    	public Node(char root, char left, char right) {
    		this.root = root;
    		this.left = left;
    		this.right = right;
    	}
		@Override
		public int compareTo(Node o) {
			return this.root-o.root;
		}
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			list.add(new Node(root, left, right));
		}
        
        Collections.sort(list);
        sb = new StringBuilder();
        
        front(list.get(0));
        System.out.println(sb.toString());
        
        middle(list.get(0));
        System.out.println(sb.substring(N, N*2).toString());
        
        back(list.get(0));
        System.out.println(sb.substring(N*2, N*3).toString());
    }

	private static void middle(Node node) {
		char left = node.left;
		char right = node.right;
				
		if (left != '.') {
			middle(list.get(left-65));
		}
		
		sb.append(node.root);
		
		if (right != '.') {
			middle(list.get(right-65));
		}
	}

	private static void back(Node node) {
		char left = node.left;
		char right = node.right;
		
		if (left != '.') {
			back(list.get(left-65));
		}
		
		if (right != '.') {
			back(list.get(right-65));
		}
		
		sb.append(node.root);
	}

	private static void front(Node node) {
		sb.append(node.root);
		
		char left = node.left;
		char right = node.right;
		
		if (left != '.') {
			front(list.get(left-65));
		}
		
		if (right != '.') {
			front(list.get(right-65));
		}
	}
}
