import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Map<String, Integer> map;
    static String[] minsikLang = {"a", "b", "k", "d", "e", "g", "h", "i", "l", "m",
                                    "n", "ng", "o", "p", "r", "s", "t", "u", "w", "y"};
    static List<String> words;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        // 각 알파벳 순서를 맵에 저장
        for(int i = 0; i < minsikLang.length; i++) {
            map.put(minsikLang[i], i);
        }

        words = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        Collections.sort(words, (a, b) -> compareWords(a, b));

        for(int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }

    static int compareWords(String a, String b) {
        int i = 0;
        int j = 0;

        while(i < a.length() && j < b.length()) {
            String A = getChar(a, i);
            String B = getChar(b, j);

            if(!A.equals(B)) {
                return map.get(A) - map.get(B);
            }

            i += A.equals("ng") ? 2 : 1;
            j += B.equals("ng") ? 2 : 1;
        }

        return a.length() - b.length();
    }

    static String getChar(String s, int i) {
        if(i + 1 < s.length() && s.substring(i, i+2).equals("ng")) {
            return "ng";
        }

        return s.substring(i, i+1);
    }
}
