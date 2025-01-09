import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// [BOJ] 무한 수열 / 골드 5 / 13:15 ~ 13:30
public class BOJ_1351 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static HashMap<Long,Long> map=new HashMap<>();

    public static void main(String[] args)throws IOException {
        st=new StringTokenizer(br.readLine());

        long n=Long.parseLong(st.nextToken());
        int p=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        System.out.println(play(n,p,q));
    }

    private static long play(long n,int p,int q){
        if(n==0)return 1;
        if(map.containsKey(n))return map.get(n);

        long a=play(n/p,p,q);
        long b=play(n/q,p,q);
        long result=a+b;

        map.put(n,result);

        return result;
    }
}
