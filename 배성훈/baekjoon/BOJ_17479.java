import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ_17479 extends FI {
    public static void main(String[] args) throws IOException {
        initFI();
        int a=nextInt();
        int b=nextInt();
        int c=nextInt();
        Map<String,Integer> menu1=new HashMap<>();
        Map<String,Integer> menu2=new HashMap<>();
        Set<String> menu3=new HashSet<>();
        for(int i=0;i<a;i++){
            String s=next();
            int num=nextInt();
            menu1.put(s,num);
        }
        for(int i=0;i<b;i++){
            String s=next();
            int num=nextInt();
            menu2.put(s,num);
        }
        for(int i=0;i<c;i++){
            String s=next();
            menu3.add(s);
        }
        int n=nextInt();
        long sum1=0;
        long sum2=0;
        int special=0;
        boolean flag=false;
        String[] order=new String[n];
        for(int i=0;i<n;i++){
            String s=next();
            order[i]=s;
            if(menu1.containsKey(s)){
                sum1+=menu1.get(s);
            }else if(menu2.containsKey(s)){
                sum2+=menu2.get(s);
            }else if(menu3.contains(s)){
                flag=true;
                special++;
            }
        }
        if((sum2>0&&sum1<20000)||(sum1+sum2<50000&&flag)||special>1){
            System.out.println("No");
            return;
        }
        System.out.println("Okay");
    }
}