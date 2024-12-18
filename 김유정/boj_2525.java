import java.util.Scanner;

public class boj_2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int time = sc.nextInt();
		int tmp;
		
		if(time + min < 60) {
			System.out.println(hour + " " + (time+min));
		}else {
			
			tmp = (time+min)/60;
			hour = hour + tmp;
			min = (time+min)%60;
			
			if (hour >= 24) {
				hour = hour%24;
			}
			System.out.println(hour + " " + min);
		}
		
	}
}
