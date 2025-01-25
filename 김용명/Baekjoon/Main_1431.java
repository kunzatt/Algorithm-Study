import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length() != b.length())
                    return a.length() - b.length();

                int sumA = 0, sumB = 0;
                for(char c : a.toCharArray())
                    if(Character.isDigit(c))
                        sumA += c - '0';
                for(char c : b.toCharArray())
                    if(Character.isDigit(c))
                        sumB += c - '0';

                if(sumA != sumB)
                    return sumA - sumB;

                return a.compareTo(b);
            }
        });

        for(String s : arr)
            System.out.println(s);
    }
}