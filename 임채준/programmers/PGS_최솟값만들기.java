import java.util.*;

public class PGS_최솟값만들기 {

    public int solution(int[] A, int[] B){
        int sum = 0;
        int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < len / 2; i++){
            int temp = B[i];
            B[i] = B[len - 1 - i];
            B[len - 1 - i] = temp;
        }

        for(int i = 0; i < len; i++) {
            sum += A[i] * B[i];
        }
        return sum;
    }

}
