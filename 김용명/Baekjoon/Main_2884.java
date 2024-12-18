import java.util.Scanner;

public class Main_2884 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if(M>=45) {
			System.out.print(H);
			System.out.printf(" %d", M-45);
		}else if (H!=0 && M<45) {
			System.out.print(H-1);
			System.out.printf(" %d", M+15);
		}else if (H==0 && M<45){
			System.out.print(23);
			System.out.printf(" %d", M+15);
		}

	}
}
