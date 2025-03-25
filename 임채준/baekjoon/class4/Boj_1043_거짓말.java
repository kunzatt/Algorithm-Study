package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1043_거짓말 {

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // 사람 수
        M = Integer.parseInt(st.nextToken());
        // 파티 수

        parent = new int[N + 1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }
        // 모든 참가자들에 대하여 union find를 하기 위해 자신의 부모를 자신으로 초기화

        st = new StringTokenizer(br.readLine());
        int knownum = Integer.parseInt(st.nextToken());
        if(knownum == 0){
            System.out.println(M);
            return;
        }
        // 만약 아는 사람이 없다면 참가하는 모든 파티에서 거짓말을 할 수 있다
        // main도 함수인지라 retrun을 써도 여기서 종료되는지 몰랐다

        int knowperson = 0;
        for(int i = 0; i < knownum; i++){
            int person = Integer.parseInt(st.nextToken());
            if(i == 0) knowperson = person;
            else union(knowperson, person);
        }
        // 주어진 정보로 아는 사람들을 첫 번째로 아는 사람을 Parent로 하여 union을 만든다

        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
        // 각 파티에 대한 정보를 저장하기 위한 arraylist 안에 arraylist 선언 및 생성

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int participant_num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> party = new ArrayList<>();
            int first_participant = Integer.parseInt(st.nextToken());
            party.add(first_participant);
            for(int j = 1; j < participant_num; j++){
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
                union(first_participant, person);
            }
            parties.add(party);
            // 모든 파티들에 대하여 각 파티들에서 첫 번째 있는 사람을 그 파티의 Union의 parent로 둔다
        }

        int ans = 0;
        for(ArrayList<Integer> party : parties){
            boolean temp = true;
            for(int person : party){
                if(find(person) == find(knowperson)){
                    temp = false;
                    break;
                }
            }
            if(temp) ans++;
        }
        // 이제 아는 사람이 포함된 파티를 찾는 과정인데 해당 파티의 parent와 아는 사람의 parent가 같다면
        // 그 파티에서는 거짓말을 할 수 없다.
        System.out.println(ans);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

}

// 처음에는 수가 작아서 브루트포스로 각 파티에 아는 사람이 있는지 확인하고 있다면 set에다가 그 파티 일월 모두를 저장하고 넘어가서
// 한 번더 반복문을 돌아 set에 없는 사람들로만 구성된 파티를 찾아내려 했으나 앞쪽에는 해당이 안되었는데 뒤에서는 해당이 되어 계산이 잘못되는 경우가 있다
// 따라서 아는 사람 union, 각 파티의 union에 대하여 각각의 파티의 일원을 돌면서 너의 부모는 아는 사람 union안에 있니? 계산만 하면 해결된다
