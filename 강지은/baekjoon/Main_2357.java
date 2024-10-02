import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2357 {

	static long[] minTree, maxTree;
	static int treeSize;
	static long[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		int h = (int)Math.ceil(Math.log(N)/Math.log(2));
		treeSize = (int)Math.pow(2, h+1);
		minTree = new long[treeSize];
		maxTree = new long[treeSize];
		
		minInit(arr, 1, 0, N-1);
		maxInit(arr, 1, 0, N-1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			long min = minFind(1, 0, N-1, a, b);
			long max = maxFind(1, 0, N-1, a, b);
			sb.append(min+" "+max+"\n");
		}
		
		System.out.println(sb.toString());

	}

	private static long minFind(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return Long.MAX_VALUE;
		
		if (left <= start && end <= right) return minTree[node];
		else {
			return Math.min(minFind(node*2, start, (start+end)/2, left, right),
					minFind(node*2+1, (start+end)/2+1, end, left, right));
		}
	}
	
	private static long maxFind(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return Long.MIN_VALUE;
		
		if (left <= start && end <= right) return maxTree[node];
		else {
			return Math.max(maxFind(node*2, start, (start+end)/2, left, right),
					maxFind(node*2+1, (start+end)/2+1, end, left, right));
		}
	}

	private static long minInit(long[] arr, int node, int start, int end) {
		if (start == end) return minTree[node] = arr[start];
		else {
			return minTree[node] = Math.min(minInit(arr, node*2, start, (start+end)/2),
					minInit(arr, node*2+1, (start+end)/2+1, end));
		}
		
	}

	private static long maxInit(long[] arr, int node, int start, int end) {
		if (start == end) return maxTree[node] = arr[start];
		else {
			return maxTree[node] = Math.max(maxInit(arr, node*2, start, (start+end)/2),
					maxInit(arr, node*2+1, (start+end)/2+1, end));
		}
		
	}

	

}
