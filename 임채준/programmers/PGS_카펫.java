public class PGS_카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        for(int i = 1; i <= total; i++){
            if(total % i == 0){
                int j = total / i;
                if((i - 2) * (j - 2) == yellow) {
                    answer = new int[] {j, i};
                    break;
                }
            }
        }

        return answer;
    }

}
