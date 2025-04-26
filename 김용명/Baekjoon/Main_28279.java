import java.io.*;
import java.util.*;

public class Main_28279 {

    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            switch (order){
                case 1 :
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2 :
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3 :
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case 4 :
                    // backPop
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case 5 :
                    sb.append(deque.size()).append("\n");
                    break;
                case 6 :
                    sb.append(deque.isEmpty()? 1 : 0).append("\n");
                    break;
                case 7 :
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case 8 :
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}