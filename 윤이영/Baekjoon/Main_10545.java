import java.util.Scanner;

public class Main_10545 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1: 입력 받기
        int[] brokenKeys = new int[9];
        for (int i = 0; i < 9; i++) {
            brokenKeys[i] = sc.nextInt();
        }

        String message = sc.next();

        // 2: 자판 매핑 정의
        String[] originalMapping = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        // 3: 망가진 자판에서 -> 실제 자판으로 변환
        String[] actualMapping = new String[10];
        for (int i = 0; i < 9; i++) {
            actualMapping[i + 1] = originalMapping[brokenKeys[i]];
        }

        // 4: 입력 문자열 변환
        StringBuilder result = new StringBuilder();
        int lastKey = -1; // 마지막으로 입력한 키

        for (char ch : message.toCharArray()) {
            for (int key = 1; key <= 9; key++) {
                if (actualMapping[key].contains(String.valueOf(ch))) {
                    int index = actualMapping[key].indexOf(ch);
                    if (lastKey == key) {
                        result.append("#"); // 같은 키를 연속해서 사용 시 #으로 구분
                    }
                    for (int i = 0; i <= index; i++) {
                        result.append(key);
                    }
                    lastKey = key;
                    break;
                }
            }
        }

        // Step 5: 결과 출력
        System.out.println(result);
    }
}
