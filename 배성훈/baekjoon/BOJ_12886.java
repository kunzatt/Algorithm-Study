import java.io.IOException;
import java.util.*;

// 12886. 돌 그룹 / 골드 4 / 16:15~16:56
public class BOJ_12886 extends FI1 {
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        initFI();
        set=new HashSet<>();
        int[] arr=new int[3];
        arr[0]=nextInt();
        arr[1]=nextInt();
        arr[2]=nextInt();
        int total=arr[0]+arr[1]+arr[2];
        if(total%3!=0){
            System.out.println(0);
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{arr[0],arr[1],arr[2]});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            Arrays.sort(cur);
            int a=cur[0];
            int b=cur[1];
            int c=cur[2];
            String key=a+","+b+","+c;
            if(!set.add(key)){
                continue;
            }
            if(a==b&&b==c){
                System.out.println(1);
                return;
            }
            if(a!=b){
                q.add(new int[]{a+a,b-a,c});
            }
            if(a!=c){
                q.add(new int[]{a+a,b,c-a});
            }
            if(b!=c){
                q.add(new int[]{a,b+b,c-b});
            }
        }
        System.out.println(0);
    }
}