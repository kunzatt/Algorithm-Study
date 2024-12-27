import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            String result = "";
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if(Character.isDigit(c)) {
                    result += c;
                } else {
                    if(result != "") {
                        list.add(new BigInteger(result));
                        result = "";
                    }
                }
            }

            if(result != "") {
                list.add(new BigInteger(result));
            }
        }

        Collections.sort(list);
        for(BigInteger i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
}
