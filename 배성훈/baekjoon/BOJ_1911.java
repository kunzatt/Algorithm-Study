import java.io.IOException;
import java.util.Arrays;

// 1911. 흙길 보수하기 / 골드 5 / 11:40 ~ 12:43
// 스위핑
class BOJ_1911 extends FI1 {
    public static void main(String[] args) throws IOException {
        initFI();
        int n=nextInt();
        int l=nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++) {
            arr[i][0]=nextInt();
            arr[i][1]=nextInt();
        }
        Arrays.sort(arr,(a, b)->a[0]-b[0]);

        int count=0;
        int cover=0;

        for(int i = 0; i < n; i++) {
            if(cover<arr[i][0]) {
                cover=arr[i][0];
            }
            while(cover<arr[i][1]) {
                cover += l;
                count++;
            }
        }
        System.out.println(count);
    }
}