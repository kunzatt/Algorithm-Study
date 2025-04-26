public class PGS_정수삼각형 {

    public int solution(int[][] triangle) {

        int answer = 0;
        int height = triangle.length;

        for(int floor = height - 2; floor >= 0; floor--) {
            for(int i = 0; i <= floor; i++) {
                triangle[floor][i] += Math.max(triangle[floor + 1][i], triangle[floor + 1][i + 1]);
            }
        }

        answer = triangle[0][0];
        return answer;
    }

}
