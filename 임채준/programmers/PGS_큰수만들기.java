public class PGS_큰수만들기 {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);

            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < cur) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(cur);
        }

        sb.setLength(sb.length() - k);

        return sb.toString();
    }

}
