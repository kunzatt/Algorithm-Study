package baekjoon;

import java.util.*;

// 45분
public class BOJ_1092 {
    static Scanner sc = new Scanner(System.in);
    static int n,m;
    static int[] a;

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Integer> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        m=sc.nextInt();
        List<Integer> box=new ArrayList<>();
        for(int i=0;i<m;i++){
            box.add(sc.nextInt());
        }
        a.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());
        if(box.get(0) > a.get(0)) {
            System.out.println(-1);
            return;
        }
        int time = 0;
        while(!box.isEmpty()) {
            time++;
            for(int d :a) {
                for(int i=0;i<box.size();i++) {
                    if(d>=box.get(i)) {
                        box.remove(i);
                        break;
                    }
                }
            }
        }

        System.out.println(time);
    }
}