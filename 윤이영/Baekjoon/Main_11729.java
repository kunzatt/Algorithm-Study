import java.util.Scanner;

public class Main_11729 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 총 이동 횟수
        sb.append((int) Math.pow(2, N) - 1).append("\n");

        // 하노이
        Hanoi(N, 1, 2, 3);
        System.out.println(sb.toString());
    }

    private static void Hanoi(int n, int first, int second, int third) {
        // 원판이 1개일 때
        if (n == 1) {
            sb.append(first).append(" ").append(third).append("\n");
            return;
        }

        // 1) n-1개의 원판을 첫 번째 기둥에서 두 번째 기둥으로
        Hanoi(n - 1, first, third, second);

        // 2) 가장 큰 원판을 첫 번째 기둥에서 세 번째 기둥으로 이동
        sb.append(first).append(" ").append(third).append("\n");

        // 3) n-1개의 원판을 두 번째 기둥에서 세 번째 기둥으로 이동
        Hanoi(n - 1, second, first, third);
    }
}
