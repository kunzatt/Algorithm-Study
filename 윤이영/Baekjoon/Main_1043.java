import java.util.ArrayList;
import java.util.Scanner;

// 80분 소요
// Uinon-Find 알고리즘을 활용해서 풀이
// 1. 진실을 아는 사람들을 하나의 그룹으로 묶는다. (union 메서드를 활용)
// 2. 각 파티의 참석자들을 하나의 그룹으로 묵는다.(union 메서드를 활용)
// 3. 입력이 끝나면, 파티를 순회하면서 findset연산을 통해 진실을 아는 사람이 파티에 있는지 확인한다.

public class Main_1043 {
    static int N, M;
    static int[] p;
    static int[] truth;
    static ArrayList<Integer>[] party;
    static int ans = 0;
    static int firsttruthp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 사람의 수 N
        M = sc.nextInt();   // 파티의 수
        p = new int[N+1];

        // makeset - 처음엔 각자가 자기 자신을 부모로 설정
        for(int i=1; i<=N; i++){
            p[i] = i;
        } 
        

        // 이야기의 진실을 아는 사람의 수와 번호
        int t = sc.nextInt();
        firsttruthp = 0;
        if(t > 0){
            firsttruthp = sc.nextInt();
            for(int i=1; i<t; i++){
                int nexttruthp = sc.nextInt();
                union(firsttruthp, nexttruthp);
            }
        }

        // 파티의 정보 입력;
        party = new ArrayList[M];
        for(int i=0; i<M; i++){
            party[i] = new ArrayList<>();
            int num = sc.nextInt();
            int firstp = sc.nextInt();
            party[i].add(firstp);
            for(int j=1; j<num; j++){
                int nextp = sc.nextInt();
                union(firstp, nextp);
                party[i].add(nextp);
            }
        }   // 입력 끝

        // 파티를 순회하면서 진실을 아는 사람과 다른 집합이라면
        // 거짓말을 해도 됨
        for(int i=0; i<M; i++){
            boolean flag = true;
            for(int p : party[i]){
                if(findset(p) == findset(firsttruthp)){
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans++;
        }


        System.out.println(ans);    // 정답 출력

    }

    private static void union(int x, int y) {
        p[findset(y)] = p[findset(x)];
    }

    private static int findset(int x) {
        if(p[x] == x){
            return x;
        }
        return p[x] = findset(p[x]);
    }
}