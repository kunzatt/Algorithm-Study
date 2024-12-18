import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Integer> l_list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			l_list.add(i);
		}
		
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if(num == 0 || i == 0) continue;
			l_list.remove(i);
			l_list.add(i - num, i + 1);
		}
		
		for(int i : l_list) {
			System.out.println(i);
		}
	}
}
