import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 10425. 피보나치 인버스 / 실버2 / 10:17 ~ 10:22
public class BOJ_10425 extends FI1 {
    public static void main(String[] args)throws IOException {
        initFI();
        int t=nextInt();
        String[] q=new String[t+1];
        for(int i=0;i<t;i++){
            q[i]=next();
        }
        Map<BigInteger,Integer> map=new HashMap<>();
        List<BigInteger> dp=new ArrayList<>();
        dp.add(BigInteger.ZERO);
        dp.add(BigInteger.ONE);
        for(int i=2;i<=100000;i++){
            dp.add(dp.get(i-2).add(dp.get(i-1)));
            map.put(dp.get(i),i);
        }
        for(int i=0;i<t;i++){
            BigInteger num=new BigInteger(q[i]);
            System.out.println(map.get(num));
        }
    }
}