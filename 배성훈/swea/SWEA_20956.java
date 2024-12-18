package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

// swea 20956. XY 문자열 2 / D5 / 55분
// 문자열 연산 특히, StringBuilder는 append 연산보다 삭제 연산이 훨씬 빠름을 확인
public class SWEA_20956 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String s, answer;
    static StringBuilder e;

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            s = br.readLine();
            e = new StringBuilder(br.readLine());
            answer = "No";
            dfs(new StringBuilder(e));
            bw.write("#" + i + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(StringBuilder str) {
        if (str.length() == s.length()) {
            if (str.toString().equals(s)) {
                answer = "Yes";
            }
            return;
        }

        if (str.charAt(str.length() - 1) == 'X') {
            dfs(new StringBuilder(str).deleteCharAt(str.length() - 1));
        }
        if (str.charAt(0) == 'Y') {
            dfs(new StringBuilder(str).reverse().deleteCharAt(str.length() - 1));
        }
    }
}
