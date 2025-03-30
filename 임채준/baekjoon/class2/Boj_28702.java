package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_28702 {
    static String A, B, C;
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        C = br.readLine();
        
        int num;

        if(C.charAt(0) >= '0' && C.charAt(0) <= '9') {
            num = Integer.parseInt(C) + 1;
        } else if(C.equals("FizzBuzz")) {
            if(B.charAt(0) >= '0' && B.charAt(0) <= '9') {
                num = Integer.parseInt(B) + 2;
            } else {
                num = Integer.parseInt(A) + 3;
            }
        } else {
            if(B.charAt(0) >= '0' && B.charAt(0) <= '9') {
                num = Integer.parseInt(B) + 2;
            } else if(A.charAt(0) >= '0' && A.charAt(0) <= '9') {
                num = Integer.parseInt(A) + 3;
            } else {
                if(C.equals("Fizz")) num = 3 * ((Integer.parseInt(A) / 3) + 1) + 1;
                else num = 5 * ((Integer.parseInt(A) / 5) + 1) + 1;
            }
        }
        
        if(num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if(num % 3 == 0) {
            System.out.println("Fizz");
        } else if(num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }
}