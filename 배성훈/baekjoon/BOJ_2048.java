import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2048. Hello, 2048! / 골드4 / 23분
// r>=4부터는 r 이 답임
public class BOJ_2048 {
    static StringBuilder sb=new StringBuilder();
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int t=Integer.parseInt(br.readLine());
        while(t-->0) {
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());

            if(r>=4) {
                sb.append(r).append("\n");
            }else {
                String s="";
                for(int i=l;i<=r;i++) {
                    s+=((1<<i));
                }
                String b=Integer.toBinaryString(Integer.parseInt(s));
                int count=0;
                int len=b.length()-1;
                for(int i=len;i>=0;i--) {
                    if(b.charAt(i)=='1')break;
                    count++;
                }
                sb.append(count).append("\n");
            }
        }
        System.out.print(sb);
    }
}