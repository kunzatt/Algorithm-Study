import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[BOJ] 디지털 카운터 / 플래티넘 2 / 5시간58분
 */
//dp[i][j] => 길이가 i 이면서 자릿수의합이 j인 최솟값
class BOJ_1020 {
    static final String MAX="9999999999999999999";
    static final int[] count={6,2,5,5,4,5,6,3,7,5};
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args)throws IOException {
        String s=br.readLine();
        n=s.length();
        String[][] dp=new String[17][111];
        for(int i=1;i<=16;i++){
            Arrays.fill(dp[i],MAX);
        }
        for(int i=0;i<=9;i++){
            String num=String.valueOf(i);
            if (dp[1][count[i]].compareTo(num) > 0)
                dp[1][count[i]] = num;
        }
        for(int i=2;i<=s.length();i++){
            for(int j=1;j<=110;j++){
                if(!dp[i-1][j].equals(MAX)) {
                    for (int k=0;k<=9;k++) {
                        int num=count[k];
                        String target=dp[i-1][j]+k;
                        if (dp[i][j+num].compareTo(target)>0){
                            dp[i][j+num]=target;
                        }
                    }
                }
            }
        }
        long maxNum=1;
        for(int i=0;i<n;i++){
            maxNum*=10;
        }
        long time=maxNum;
        StringBuilder sb=new StringBuilder(s);
        int len=1;
        int idx=0;
        if(n==1){
            idx=count[sb.charAt(0)-'0'];
            for(int j=0;j<=9;j++){
                if(count[j]==idx){
                    long t1=Long.parseLong(s);
                    long t2=j;
                    if(t1<t2){
                        time=Math.min(time,t2-t1);
                    }else if(t1>t2){
                        time = Math.min(time, maxNum - t1 + t2);
                    }
                }
            }
            System.out.println(time);
            return;
        }
        for(int i=n-1;i>=0;i--){
            idx+=count[sb.charAt(i)-'0'];

            if(i!=n-1){
                for(char num='0';num<='9';num++){
                    int ii=idx-(count[num-'0']);
                    if(ii<0)continue;
                    sb.setCharAt(i,num);
                    if(!dp[len][ii].equals(MAX)){
                        String ans= sb+dp[len][ii];
                        long t1=Long.parseLong(s);
                        long t2=Long.parseLong(ans);
                        if(t1<t2){
                            time=Math.min(time,t2-t1);
                        }else if(t1>t2){
                            time = Math.min(time, maxNum - t1 + t2);
                        }
                    }
                }
                len++;
            }else{
                for(char num='0';num<='9';num++){
                    if(idx==count[num-'0']){
                        sb.setCharAt(i,num);
                        String ans=sb.toString();
                        long t1=Long.parseLong(s);
                        long t2=Long.parseLong(ans);
                        if(t1<t2){
                            time=Math.min(time,t2-t1);
                        }else if(t1>t2){
                            time = Math.min(time, maxNum - t1 + t2);
                        }
                    }
                }
            }
            sb.deleteCharAt(i);
        }
        System.out.println(time);
    }
}