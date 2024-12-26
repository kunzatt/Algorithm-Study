import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_2870 {
    static int N;
    static List<BigInteger> nums = new ArrayList<>(); // 숫자 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            String temp = ""; 
            boolean isNumber = false; 

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= '0' && c <= '9') {
                    temp += c;
                    isNumber = true;
                } else {

                	if (isNumber) {
                        nums.add(new BigInteger(temp));
                        temp = "";
                        isNumber = false;
                    }
                }
            }

            if (isNumber) {
                nums.add(new BigInteger(temp));
            }
        }

        Collections.sort(nums);

        for (BigInteger num : nums) {
            System.out.println(num);
        }
    }
}
