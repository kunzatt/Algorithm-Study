import java.util.*;

public class PGS_기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();
        int[] complete = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            complete[i] = (remain + speeds[i] - 1) / speeds[i];
        }

        int count = 1;
        int max = complete[0];

        for (int i = 1; i < complete.length; i++) {
            if (complete[i] <= max) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                max = complete[i];
            }
        }

        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();
    }

}
