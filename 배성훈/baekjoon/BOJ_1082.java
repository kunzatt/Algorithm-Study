import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

// 1082. 방 번호 / 골드3 / 93분
public class BOJ_1082 extends FastInput {
    static int n,m;
    static int[] price;
    static String ans="";

    public static void main(String[] args) throws IOException {
        initFI();
        n=nextInt();
        price=new int[n];
        for(int i=0;i<n;i++){
            price[i]=nextInt();
        }
        m=nextInt();
        String[] dp=new String[m+1];
        Arrays.fill(dp,"");
        for(int p=0;p<=m;p++){
            for(int i=n-1;i>=0;i--){
                if(p>=price[i]){
                    BigInteger newstr=new BigInteger(dp[p-price[i]]+i);
                    if(dp[p].isEmpty()||newstr.compareTo(new BigInteger(dp[p]))>0){
                        dp[p]=String.valueOf(newstr);
                    }
                }
            }
        }
        System.out.println(dp[m]);
    }

    private static void play(String s,int p,int idx){
        if(p>m){
            return;
        }
        if(ans.isEmpty()||s.length()>ans.length()||s.compareTo(ans)>0){
            ans=s;
        }
        if(idx==0){
            return;
        }
        for(int i=idx;i>=0;i--){
            play(s+i,p+price[i],i);
        }
    }
}