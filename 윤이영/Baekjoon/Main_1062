import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, K, ans = 0;
    static int know;
    static int[] words;
    static char[] antatica = {'a', 'n', 't', 'i', 'c'};
    static Set<Character> candidateSet = new HashSet<>();
    static List<Character> candidates;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt(); // 가르칠 단어의 수
        words = new int[N];
        
        // a, n, t, i, c는 무조건 읽을 줄 알아야 함
        for(int i=0; i<5; i++){
            know |= (1 << (antatica[i] - 'a'));
        }
        for(int i=0; i<N; i++){
            String S = sc.next();
            for(char c : S.toCharArray()){
                words[i] |= (1 << (c-'a'));
                // 후보군 만들기
                if((know & ( 1 << (c-'a'))) == 0) {
                	candidateSet.add(c);
                }
            }
        }
        
        if( K < 5) {
            System.out.println(0);  
            return;
        }else if(K == 26 || candidateSet.size() < K-5){
            System.out.println(N);
            return;
        }
        
        candidates = new ArrayList<>(candidateSet);
        
        comb(0, 0);
        System.out.println(ans);
    }

    public static void comb(int depth, int strt){
        if(depth == K-5){
            // 단어의 수를 세기
            int cnt = 0;
            for(int i=0; i<words.length; i++){
                if( (words[i] & know) == words[i]){
                    cnt++;
                }
            }
            ans = Math.max(cnt, ans);
            return;
        }

        // 조합을 활용하여 배워야 하는 단어를 선택
        for(int i = strt; i< candidates.size(); i++){
            char c = candidates.get(i);
            // 배우기
            know |= (1 << (c-'a'));
            comb(depth+1, i+1);
            // 되돌리기
            know &= ~(1 << (c-'a'));
        }
    }
    
}
