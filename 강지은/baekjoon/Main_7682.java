import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_7682 {
	
    static char[] t;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
        	String str = br.readLine();
        	
        	if (str.equals("end")) return;
        	
        	t = str.toCharArray();
        	
        	int oCnt = 0;
        	int xCnt = 0;
        	
        	for (int i = 0; i < 9; i++) {
				if (t[i]=='O') oCnt++;
				if (t[i]=='X') xCnt++;
			}
        	
        	if (oCnt > xCnt || oCnt+xCnt==0) {
        		System.out.println("invalid");
        		continue;
        	}
        	
        	boolean oWin = false;
        	boolean xWin = false;
        	
        	// 가로 빙고
        	for (int i = 0; i < 9; i+=3) {
				if (t[i]==t[i+1] && t[i]==t[i+2]) {
					if (t[i]=='O') oWin = true;
					if (t[i]=='X') xWin = true;
				}
			}
        	
        	// 세로 빙고
        	for (int i = 0; i < 3; i++) {
				if (t[i]==t[i+3] && t[i]==t[i+6]) {
					if (t[i]=='O') oWin = true;
					if (t[i]=='X') xWin = true;
				}
			}
        	
        	// 대각선 빙고
        	if (t[0]==t[4] && t[0]==t[8]) {
        		if (t[0]=='O') oWin = true;
				if (t[0]=='X') xWin = true;
        	}
        	
        	if (t[2]==t[4] && t[2]==t[6]) {
        		if (t[2]=='O') oWin = true;
				if (t[2]=='X') xWin = true;
        	}
        	
        	//  --------------
        	// 둘다 빙고
        	if (oWin && xWin) {
        		System.out.println("invalid");
        		continue;
        	}
        	
        	// o만 빙고
        	if (oWin) {
        		if (oCnt==xCnt) {
        			System.out.println("valid");
        		} else {
        			System.out.println("invalid");
        		}
        		continue;
        	}
        	
        	// x만 빙고
        	if (xWin) {
        		if (xCnt==oCnt+1) {
        			System.out.println("valid");
        		} else {
        			System.out.println("invalid");
        		}
        		continue;
        	}
        	
        	// 둘다 빙고 실패
        	if (!oWin && !xWin) {
        		if (oCnt+xCnt==9 && xCnt==oCnt+1) {
        			System.out.println("valid");
        		} else {
        			System.out.println("invalid");
        		}
        		continue;
        	}
        	
        	System.out.println("invalid");
        }
        
    }
}
