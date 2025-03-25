package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1620_나는야포켓몬마스터이다솜 {
	
	static int N, M;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> nameToNumber = new HashMap<>();
        HashMap<Integer, String> numberToName = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            nameToNumber.put(pokemon, i);
            numberToName.put(i, pokemon);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            if (Character.isDigit(line.charAt(0))) {
                int number = Integer.parseInt(line);
                sb.append(numberToName.get(number)).append('\n');
            } else {
                sb.append(nameToNumber.get(line)).append('\n');
            }
        }
       
        System.out.print(sb);
    }
}