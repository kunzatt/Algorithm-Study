import java.util.Scanner;

public class Main_26070 {
    static long A, B, C;  // 각 음식의 필요 개수
    static long X, Y, Z;  // 각 종류의 식권 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();


        X = sc.nextLong();
        Y = sc.nextLong();
        Z = sc.nextLong();

        // 세 가지 경우의 최대 값을 계산
        // A -> B -> C
        // B -> C -> A
        // C -> A -> B
        long ans1 = calculateMax(A, B, C, X, Y, Z);
        long ans2 = calculateMax(B, C, A, Y, Z, X);
        long ans3 = calculateMax(C, A, B, Z, X, Y);

        // 최종 최대 값 출력
        System.out.println(Math.max(ans1, Math.max(ans2, ans3)));
    }

    private static long calculateMax(long a, long b, long c, long x, long y, long z) {
        long answer = 0;

        long served = Math.min(a, x);
        answer += served;
        x -= served;
        y += x / 3;

        // 두 번째 음식 제공
        served = Math.min(b, y);
        answer += served;
        y -= served;
        z += y / 3;

        // 세 번째 음식 제공
        served = Math.min(c, z);
        answer += served;

        return answer;
    }
}
