import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2108 {

    static int N;
    static List<Integer> list;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;
            if (map.containsKey(num)) {
                cnt = map.get(num);
            }
            list.add(num);
            map.put(num, cnt + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        Collections.sort(list);

        double sum = 0;
        int max = 0;
        int idx = 4001;
        boolean flag = false;
        for (Integer key : keySet) {
            sum += key * map.get(key);

            if (max == map.get(key) && !flag) {
                idx = key;
                flag = true;
            }

            if (max < map.get(key)) {
                max = map.get(key);
                idx = key;
                flag = false;
            }

        }

        int size = keySet.size();
        System.out.println(Math.round(sum / N));
        System.out.println(list.get(N / 2));
        System.out.println(idx);
        System.out.println(keySet.get(size - 1) - keySet.get(0));

    }
}
