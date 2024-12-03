import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1038. 감소하는 수 / 골드 5 / 10:20 ~ 10:32
// 구현
class BOJ_1038 extends FI1 {
    public static void main(String[] args) throws IOException {
        initFI();
        int n=nextInt();
        if(n<=10){
            System.out.println(n);
            return;
        }
        String[] init={"0","1","2","3","4","5","6","7","8","9"};
        List<String> list=new ArrayList<>(Arrays.asList(init));
        int count=9;
        while(!list.isEmpty()){
            List<String> temp=new ArrayList<>();
            for(String s:list){
                for(String num:init){
                    if(s.charAt(s.length()-1)-'0'<=num.charAt(0)-'0'){
                        break;
                    }
                    String newStr=s+num;
                    temp.add(newStr);
                    count++;
                    if(count==n){
                        System.out.println(newStr);
                        return;
                    }
                }
            }
            list=temp;
        }
        System.out.println(-1);
    }
}