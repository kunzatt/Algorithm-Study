import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 14715. 전생했더니 슬라임 연구자였던 건에 대하여(Easy) / 골드5 / 37분
public class BOJ_14715 extends FastInput {
    public static void main(String[] args) throws IOException {
        initFI();
        boolean[] sieve=new boolean[1111111];
        Arrays.fill(sieve,true);
        for(int i=2;i*i<=1000000;i++){
            if(sieve[i]){
                for(int j=i*i;j<=1000000;j+=i){
                    sieve[j]=false;
                }
            }
        }
        int k=nextInt();
        if(sieve[k]){
            System.out.println(0);
            return;
        }
        List<Integer>soinsu=new ArrayList<>();
        for(int i=2;i<=1000000;i++){
            if(k==1)break;
            while(k%i==0){
                soinsu.add(i);
                k/=i;
            }
        }
        System.out.println((int)Math.ceil(Math.log(soinsu.size())/Math.log(2)));
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    protected static double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9')
            ret += (c - '0') / (div *= 10);
        return ret;
    }

    protected static long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    protected static String next() throws IOException {
        StringBuilder sb = new StringBuilder();
        byte c = read();

        while (c <= ' ') c = read();

        while (c > ' ') {
            sb.append((char) c);
            c = read();
        }
        return sb.toString();
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}