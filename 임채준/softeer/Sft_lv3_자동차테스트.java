package sft;

import java.io.*;
import java.util.*;

public class Sft_lv3_자동차테스트 {
	
	static int n, q, target, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while (q > 0) {
            int target = Integer.parseInt(br.readLine());
            
            int idx = Arrays.binarySearch(arr, target);
            if (idx < 0) {
                System.out.println(0);
                q--;
                continue;
            }
            
            int left = lower(arr, target);
            int right = n - upper(arr, target);
            long count = (long) left * right;
            System.out.println(count);
            q--;
        }
    }

    static int lower(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int upper(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }

}
