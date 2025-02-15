package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_1541_잃어버린괄호 {
	
	static int result, sum;
	static String line;
	static String[] tokens, numbers;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        tokens = line.split("-");
        result = sum(tokens[0]);
        
        for (int i = 1; i < tokens.length; i++) {
            result -= sum(tokens[i]);
        }
        
        System.out.println(result);
    }
    
    private static int sum(String exp) {
    	numbers = exp.split("\\+");
        sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
