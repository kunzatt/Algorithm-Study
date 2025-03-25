package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1966_프린터큐 {
	
    static int T, N, M, count;
    static int[] nums;
    static Queue<Document> que;  
    static class Document {
        int index;
        int priority;       
        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());    
        
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());           
            que = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                que.offer(new Document(i, priority));
            }
            
            count = 0;
            
            while(!que.isEmpty()) {
                Document cur = que.poll();
                boolean max = true;

                for(Document doc : que) {
                    if(doc.priority > cur.priority) {
                        max = false;
                        break;
                    }
                }
                
                if(max) {
                    count++;
                    if(cur.index == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    que.offer(cur);
                }
            }
        }
    }
}