import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] strs=br.readLine().split(" ");
        String[] s=strs[0].split(":");
        String[] e=strs[1].split(":");
        String[] q=strs[2].split(":");
        int sh=Integer.parseInt(s[0]);
        int sm=Integer.parseInt(s[1]);
        int eh=Integer.parseInt(e[0]);
        int em=Integer.parseInt(e[1]);
        int qh=Integer.parseInt(q[0]);
        int qm=Integer.parseInt(q[1]);
        int count=0;
        Set<String> set=new HashSet<>();
        Set<String> check=new HashSet<>();
        while(true){
            String ss=br.readLine();
            if(ss==null||ss.trim().isEmpty())break;
            st=new StringTokenizer(ss);
            String time=st.nextToken();
            String[] times=time.split(":");
            int h=Integer.parseInt(times[0]);
            int m=Integer.parseInt(times[1]);
            String name=st.nextToken();

            if((h<sh)||(h==sh&&m<=sm)){
                set.add(name);
            }
            if ((h>eh||(h==eh&&m>=em))&&(h<qh||(h==qh&&m<=qm))) {
                if(set.contains(name)){
                    check.add(name);
                }
            }
        }
        System.out.println(check.size());
    }
}
