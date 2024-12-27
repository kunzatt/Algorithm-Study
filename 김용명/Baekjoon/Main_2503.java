import java.io.*;
import java.util.*;

public class Main_2503{
	
    static int N;
    static boolean[] check = new boolean[988];

    public static void main(String[] args) throws Exception{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 123;i <= 987; i++){
            String str = Integer.toString(i);

            if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') continue;	// 0이 들어가는 숫자는 패스

            if(str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)) continue;	//중복되는 숫자는 패스
            check[i] = true;
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken()); 	// 물어보는 숫자
            int s = Integer.parseInt(st.nextToken());	// 스트라이크 입력값
            int b = Integer.parseInt(st.nextToken());	// 볼 입력값

            for(int num = 123; num <= 987; num++){
                if(check[num]){
                    int ns = 0;		// 새로운 스트라이크                    
                    int nb = 0;		// 새로운 볼

                    for(int k = 0; k < 3; k++){
                        char qc = Integer.toString(q).charAt(k);	

                        for(int l = 0; l < 3; l++){
                            char ac = Integer.toString(num).charAt(l);

                            if(qc == ac && k == l ) ns++;
                            else if(qc == ac && k  != l ) nb++;
                        }
                    }

                    if(ns == s && nb == b) check[num] = true;
                    else check[num] = false;
                }
            }
        }

        int count = 0;
        for(int i = 123; i <= 987; i++){
            if(check[i]) count++;
        }

        System.out.println(count);
    }
}