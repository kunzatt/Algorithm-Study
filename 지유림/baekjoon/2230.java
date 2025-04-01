import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int start = 0; // 시작 포인터
        int end = 0;   // 끝 포인터
        int result = Integer.MAX_VALUE;
        
        while (start < N && end < N) {
            int mid = arr[end] - arr[start]; // 현재 두 수의 차이
            
            if (mid >= M) { // 차이가 M 이상인 경우
                result = Math.min(result, mid); // 최소 차이 갱신
                start++; 
            } else { // 차이가 M 미만인 경우
                end++; 
            }
        }
        
        System.out.println(result);
    }
}
