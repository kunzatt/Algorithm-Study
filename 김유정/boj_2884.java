import java.util.Scanner;

public class boj_2884{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int tmp;
		if (min < 45) {
			if (hour == 0) {
				tmp = 45-min;
				min = 60-tmp;
				hour = 23;
				System.out.println(hour + " " + min);				
				
			}else {
				tmp = 45-min;
				min = 60-tmp;
				hour--;
				System.out.println(hour + " " + min);				
			}

			
			
		}else {
			System.out.println(hour + " " + (min-45));
		}
	}
}
