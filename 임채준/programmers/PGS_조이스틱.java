public class PGS_조이스틱 {

    public int solution(String name) {

        int answer = 0;
        int len = name.length();
        int leftRight = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int upDown = Math.min(c - 'A', 'Z' - c + 1);
            answer += upDown;

            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            int movePattern = Math.min(
                    i * 2 + len - next,
                    (len - next) * 2 + i
            );

            leftRight = Math.min(leftRight, movePattern);
        }

        return answer + leftRight;
    }

}
