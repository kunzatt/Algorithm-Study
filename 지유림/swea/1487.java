import java.util.Scanner;
public class Solution {
    static int N, S;
    static int[] arr;
    static int count;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            S = sc.nextInt();
            
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            count = 0;
            combi(0, 0, 0);
            
            System.out.println(count);
        }
    }
    
    static void combi(int start, int sum, int cnt) {
        // 가지치기: 현재 합이 이미 S를 초과한 경우 더 이상 진행할 필요 없음
        if(sum > S) {
            return;
        }
        
        if(sum == S) {
            count++;
            return;
        }
        
        // start부터 시작하여 남은 원소들 중에서 선택
        for(int i = start; i < N; i++) {
            combi(i + 1, sum + arr[i], cnt + 1);
        }
    }
}
