import java.util.*;

public class PGS_구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int a = 0;
        int b = people.length - 1;
        while(a < b) {
            if(people[a] + people[b] <= limit) {
                answer++;
                a++;
            }
            b--;
        }

        return people.length - answer;
    }

}
