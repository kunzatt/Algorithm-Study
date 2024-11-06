import java.io.IOException;
import java.util.Arrays;

public class BOJ_23322 extends FI {
    public static void main(String[] args) throws IOException {
        initFI();
        int n=nextInt();
        int k=nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nextInt();
        }
        int choco=0;
        int day=0;
        Arrays.sort(arr);
        for(int i=1;i<n;i++){
            if(arr[i]>arr[0]){
                choco+=arr[i]-arr[0];
                day++;
            }
        }
        System.out.println(choco+" "+day);
    }
}
