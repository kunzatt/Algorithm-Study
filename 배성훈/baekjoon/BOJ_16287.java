import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//MITM
public class BOJ_16287 extends FI1 {

    public static void main(String[] args) throws IOException {
        initFI();
        int w=nextInt();
        int n=nextInt();
        Map<Integer,int[]> map1=new HashMap<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int key=arr[i]+arr[j];
                int[] value=new int[]{i,j};
                map1.put(key,value);
            }
        }




        for(int i:map1.keySet()){
            int[] value1=map1.get(i);
            if(map1.containsKey(w-i)){
                int[] value2=map1.get(w-i);

                if(value1[0]==value2[0]||value1[1]==value2[0]||value1[0]==value2[1]||value1[1]==value2[1]){
                    continue;
                }

                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}