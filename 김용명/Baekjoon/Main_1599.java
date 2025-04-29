import java.io.*;
import java.util.*;

public class Main_1599 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] alphabet = {"a", "b", "k", "d", "e", "g", "h", "i", "l", "m", "n", "ng", "o", "p", "r", "s", "t", "u", "w", "y"};
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < alphabet.length; i++) {
            map.put(alphabet[i], i);
        }

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (s1, s2) -> {
            List<String> c1 = split(s1);
            List<String> c2 = split(s2);

            int len = Math.min(c1.size(), c2.size());
            for (int i = 0; i < len; i++) {
                int o1 = map.get(c1.get(i));
                int o2 = map.get(c2.get(i));

                if (o1 != o2) {
                    return o1 - o2;
                }
            }

            return c1.size() - c2.size();
        });

        for (String word : words) {
            System.out.println(word);
        }
    }

    static List<String> split(String word) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (i < word.length() - 1 && word.charAt(i) == 'n' && word.charAt(i + 1) == 'g') {
                list.add("ng");
                i++;
            } else {
                list.add(String.valueOf(word.charAt(i)));
            }
        }

        return list;
    }
}