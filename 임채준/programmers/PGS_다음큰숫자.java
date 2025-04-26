public class PGS_다음큰숫자 {

    class Solution {
        public int solution(int n) {
            int answer = n + 1;
            String originBC = Integer.toBinaryString(n);
            int count1 = 0;
            for(int i = 0; i < originBC.length(); i++){
                if(originBC.charAt(i) == '1') count1++;
            }
            while(true){
                int count2 = 0;
                String temp = Integer.toBinaryString(answer);
                for(int i = 0; i < temp.length(); i++){
                    if(temp.charAt(i) == '1') count2++;
                }
                if(count1 == count2) break;
                else answer++;
            }
            return answer;
        }
    }

}
