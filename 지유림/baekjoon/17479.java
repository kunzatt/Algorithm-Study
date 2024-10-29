import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main17479_정식당 {
    static int A, B, C, N;
    static HashMap<String, Integer> nMenu;  // 일반메뉴
    static HashMap<String, Integer> speMenu;    //  특별메뉴
    static HashMap<String, Integer> serMenu;    // 서비스메뉴
    static String[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        nMenu = new HashMap<>();
        speMenu = new HashMap<>();
        serMenu = new HashMap<>();

        // 일반메뉴
        for(int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());

            String menu = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            nMenu.put(menu, price);
        }

        // 특별메뉴
        for(int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            speMenu.put(menu, price);
        }

        // 서비스메뉴
        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();

            serMenu.put(menu, 1);
        }

        // 손님 주문 확인
        N = Integer.parseInt(br.readLine());
        order = new String[N];
        for(int i = 0; i < N; i++) {
            order[i] = br.readLine();
        }

        boolean flag = false;
        long s = searchMenu(serMenu);
        if(s == 1) {   // 서비스 메뉴가 단 1개일 때
            long normal = searchMenu(nMenu); // 일반메뉴 총 금액
            long special = searchMenu(speMenu); // 특별메뉴 총 금액

            // 일반 메뉴 20000원 이상, 특별메뉴+일반메뉴 50000원 이상이다
            if(normal >= 20000 && special+normal >= 50000) {
                flag = true;
            }
        } else if(s == 0) { // 서비스 메뉴 없을 때
            long special = searchMenu(speMenu);
            if(special <= 0) flag = true;
            else {
                if(searchMenu(nMenu) >= 20000) flag = true;
            }
        }

        if(flag) System.out.println("Okay");
        else System.out.println("No");

    }

    static long searchMenu(HashMap<String, Integer> map) {
        long count = 0;
        for(int i = 0; i < N; i++) {
            if(map.containsKey(order[i])) {
                count += map.get(order[i]);
            }
        }

        return count;
    }
}
