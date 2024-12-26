import java.io.IOException;

// 1790. 수 이어 쓰기 2 / 골드5 / 31분
public class BOJ_1790 extends FastInput {
    public static void main(String[] args) throws IOException {
        initFI();
        long n=nextLong();
        long k=nextLong();

        long total=0;
        int num=1;
        long start=1;

        while(start<=n){
            long cnt=Math.min(n-start+1, 9L*start);
            long digit=cnt*num;

            if(total+digit>=k){
                k-=total;
                long target=start+(k-1)/num;
                if (target>n) {
                    System.out.println(-1);
                    return;
                }
                int idx=(int)((k-1)%num);
                System.out.println(String.valueOf(target).charAt(idx));
                return;
            }
            total+=digit;
            start*=10;
            num++;
        }
        System.out.println(-1);
    }
}