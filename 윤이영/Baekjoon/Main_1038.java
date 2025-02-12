import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_1038 {
    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 감소하는 수를 모두 생성
        list = new ArrayList<>();
        if(N <= 10) System.out.println(N);
        else if(N >= 1023) System.out.println(-1);
        else {
        	for(int i=0; i<10; i++) {
        		descending(1, i);
        	}
        	Collections.sort(list);
        	System.out.println(list.get(N));
        }
       
    }

	private static void descending(int idx, long num) {
		if(idx > 10) return;
		
		list.add(num);
		for(int i=0; i< num % 10; i++) {
			descending(idx+1 , (num*10)+i);
		}
		
	}


}
