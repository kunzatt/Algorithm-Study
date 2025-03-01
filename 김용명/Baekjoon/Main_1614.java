import java.io.*;

public class Main_1614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long count = Long.parseLong(br.readLine());
        long ans = 0;

        if (num == 1) {
            ans = (long) (count * 8);
        } else if (num == 2) {
            ans = (long) (1 + (count / 2) * 8 + (count % 2) * 6);
        } else if (num == 3) {
            ans = (long) (2 + (count / 2) * 8 + (count % 2) * 4);
        } else if (num == 4) {
            ans = (long) (3 + (count / 2) * 8 + (count % 2) * 2);
        } else {
            ans = (long) (4 + count * 8);
        }

        System.out.println(ans);
    }
}