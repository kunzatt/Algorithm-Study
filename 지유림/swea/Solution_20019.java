import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
    static String s;
    static int T;
    static char[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
         
        for(int t = 1; t <= T; t++) {
            s = br.readLine();

            // 문자열 길이 만큼 char 배열 초기화
            arr = new char[s.length()];

            // char로 담아버려
            for(int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i);
            }
             
            boolean isS = palindrome(s.length(), arr);
            if(isS) System.out.println("#" + t + " " + "YES");
            else System.out.println("#" + t + " " + "NO");
        }
    }

    // 회문의 회문까지 검색하는 로직
    public static boolean palindrome(int n, char[] arr) {
        String first= "";
        String last = "";

        // 회문인지 검색하는 로직
        for(int i = 0; i < n / 2; i++) {
            if(arr[i] != arr[n - i - 1]) {
                return false;
            }
        }

      // 여기 타면 무조건 회문인거 -> 회문의 회문 검사!
        for(int i = 0; i < ((n-1)/2); i++) {
            first += arr[i];
        }
         
        for(int i = ((n-1)/2) + 1; i < n; i++) {
            last += arr[i];
        }
 
        if(first.equals(last)) return true;
        else return false;
    }
}
