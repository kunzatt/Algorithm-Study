import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1360. 되돌리기 / / 11:11 ~ 12:34 
// 쓰레기문제 맞왜틀 ㄹㅇ
public class BOJ_1360 extends FI1 {
    static class Info{
        String command;
        char value;
        int back;
        int time;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder answer=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        Info[] info=new Info[n];
        boolean[] states=new boolean[n];

        for(int i=0;i<n;i++){
            info[i]=new Info();
            st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            info[i].command=command;
            if(command.equals("type")){
                char value=st.nextToken().charAt(0);
                int time=Integer.parseInt(st.nextToken());
                info[i].value=value;
                info[i].time=time;
            }else{
                int back=Integer.parseInt(st.nextToken());
                int time=Integer.parseInt(st.nextToken());
                info[i].back=back;
                info[i].time=time;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(states[i])continue;
            if(info[i].command.equals("type"))continue;

            states[i]=true;
            int newTime=info[i].time-info[i].back;

            for(int j=i-1;j>=0;j--){
                if(info[j].time<newTime)break;
                states[j]=true;
            }
        }
        for(int i=0;i<n;i++){
            if(states[i])continue;
            answer.append(info[i].value);
        }
        System.out.println(answer);
    }
}