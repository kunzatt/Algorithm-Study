import java.util.Scanner;

public class Main_1512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        String dna = sc.nextLine();

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= M; i++) {
            int temp = solve(dna, i);
            min = Math.min(min, temp);
        }

        System.out.println(min);
    }

    private static int solve(String dna, int num) {
        int length = dna.length();
        int[] count = new int[num];
        int[][] ccount = new int[num][4];

        for (int i = 0; i < length; i++) {
            int position = i % num;
            char c = dna.charAt(i);

            if (c == 'A') ccount[position][0]++;
            else if (c == 'C') ccount[position][1]++;
            else if (c == 'G') ccount[position][2]++;
            else if (c == 'T') ccount[position][3]++;
        }

        int total = 0;
        for (int i = 0; i < num; i++) {
            int max = 0;
            for (int j = 0; j < 4; j++) {
                max = Math.max(max, ccount[i][j]);
            }

            int pcount = (length + num - 1 - i) / num;
            total += pcount - max;
        }

        return total;
    }
}