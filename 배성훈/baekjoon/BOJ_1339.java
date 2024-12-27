import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1339. 단어 수학 / 골드4 / 18분
public class BOJ_1339 {
    static int n;
    static String[] arr;
    static String[] encoded;
    static Set<Character> set;
    static int[] alpha;
    static boolean[] used;
    static long max =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new String[n];
        encoded=new String[n];
        set=new HashSet<>();
        for(int i=0;i<n;i++){
            arr[i]=br.readLine();
            for(char c:arr[i].toCharArray()){
                set.add(c);
            }
        }
        alpha=new int[26];
        used=new boolean[10];
        play(0,new ArrayList<>(set));
        System.out.println(max);
    }

    /*
    set에 있는 character들을 9부터 시작해서 내려가는순으로 매핑해서 하기
    encoded 배열에 딱 매핑시키고
    다 더한 값을 최댓값으로 계속 갱신 ㄱㄱ
     */
    private static void play(int idx,List<Character> list) {
        if(idx==list.size()){
            long sum=0;
            for(String s:arr){
                long num=0;
                for(char c:s.toCharArray()){
                    num=num*10+alpha[c-'A'];
                }
                sum+=num;
            }
            max =Math.max(max,sum);
            return;
        }
        char cur=list.get(idx);
        for (int i=9;i>=0;i--){
            if (!used[i]){
                used[i]=true;
                alpha[cur-'A']=i;
                play(idx+1,list);
                used[i]=false;
            }
        }
    }
}