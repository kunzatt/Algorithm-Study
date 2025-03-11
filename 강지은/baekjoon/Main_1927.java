import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1927 {

    static int N;
    static PriorityQueue heap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        N = Integer.parseInt(br.readLine());
        heap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                heap.add(num);
            } else {
                if (!heap.isEmpty()) {
                    System.out.println(heap.poll());
                } else {
                    System.out.println(0);
                }
            }
        }

    }
}
