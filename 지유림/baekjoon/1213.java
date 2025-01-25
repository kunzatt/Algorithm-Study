import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        
        // 각 알파벳 개수 세기
        int[] alpha = new int[26];
        for(int i = 0; i < name.length(); i++) {
            alpha[name.charAt(i) - 'A']++;
        }
        
        // 홀수 개수인 알파벳 확인
        int oddCount = 0;
        int oddIndex = -1;
        for(int i = 0; i < 26; i++) {
            if(alpha[i] % 2 == 1) {
                oddCount++;
                oddIndex = i;
            }
        }
        
        // 팰린드롬 가능 여부 확인
        if(oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        // 팰린드롬 만들기
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        
        // 짝수 개수인 알파벳 처리
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < alpha[i]/2; j++) {
                front.append((char)(i + 'A'));
            }
        }
        
        // 뒷부분은 앞부분을 뒤집은 것
        back.append(front).reverse();
        
        // 홀수 개수인 알파벳이 있다면 가운데에 추가
        if(oddIndex != -1) {
            front.append((char)(oddIndex + 'A'));
        }
        
        System.out.println(front.toString() + back.toString());
    }
}
