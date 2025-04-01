import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static String[] titles;
    static long[] powers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        titles = new String[N];
        powers = new long[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < M; i++) {
            long characterPower = Long.parseLong(br.readLine());
            
            int idx = binarySearch(characterPower);
            sb.append(titles[idx]).append("\n");
        }

        System.out.println(sb);
    }
    
    static int binarySearch(long target) {
        int left = 0;
        int right = powers.length-1;
        int result = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(target <= powers[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
}
