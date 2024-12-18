import java.util.Scanner;

public class Main_2609 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	
    	System.out.println(findMax(n,m));
    	System.out.println(findMin(n,m));
    }
    
    // 최대공약수
    public static int findMax(int n, int m) {
    	int result = n<m ? n: m;
    	
    	for(int i=result; i>=1; i--) {
    		if(n%i == 0 && m%i==0) {
    			result = i;
    			break;
    		}
    	}
    	
    	return result;
    }
    
    // 최소공배수
    public static int findMin(int n, int m) {
    	int result = n<m ? m: n;
    	
    	for(int i=result; i<=n*m; i++) {
    		if(i%n==0 && i%m == 0) {
    			result = i;
    			break;
    		}
    	}
    	
    	return result;
    }
}