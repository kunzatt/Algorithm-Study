import java.io.*;
import java.util.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        
        while(true) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == -1) break;
            
           
            if (num == 0) {
                que.poll();
            } else if (num >= 1) {
                if (que.size() < N) {
                    que.offer(num);
                }
            }
        }
   
        if(que.isEmpty()) {
            System.out.println("empty");
            return;
        }
        
        while(!que.isEmpty()) {
            System.out.print(que.poll() + " ");
        }
    }
}
