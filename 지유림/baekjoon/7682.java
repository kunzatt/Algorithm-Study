import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            
            char[] board = input.toCharArray();

            if (isValid(board)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }
    

    private static boolean isValid(char[] board) {
        // X와 O의 개수 세기
        int countX = 0;
        int countO = 0;
        
        for (char c : board) {
            if (c == 'X') countX++;
            else if (c == 'O') countO++;
        }
        
        // 1. X는 선공이므로 X의 개수는 O의 개수와 같거나 1개 더 많아야 함
        if (countX < countO || countX > countO + 1) {
            return false;
        }
        
        // 승리 조건 확인
        boolean xWin = isWin(board, 'X');
        boolean oWin = isWin(board, 'O');
        
        // 2. 둘 다 승리한 경우는 불가능
        if (xWin && oWin) {
            return false;
        }
        
        // 3. X가 이겼을 때 
        if (xWin && countX != countO + 1) {
            return false;
        }
        
        // 4. O가 이겼을 때 
        if (oWin && countX != countO) {
            return false;
        }
        
        // 5. 게임이 진행 중인 경우 (승자도 없고 빈칸이 있는 경우)
        int countEmpty = 9 - countX - countO;
        if (!xWin && !oWin && countEmpty > 0) {
            return false;
        }
        
        return true;
    }
    

    private static boolean isWin(char[] board, char player) {
        // 가로 
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == player && board[i+1] == player && board[i+2] == player) {
                return true;
            }
        }
        
        // 세로 
        for (int i = 0; i < 3; i++) {
            if (board[i] == player && board[i+3] == player && board[i+6] == player) {
                return true;
            }
        }
        
        // 대각선
        if (board[0] == player && board[4] == player && board[8] == player) {
            return true;
        }
        if (board[2] == player && board[4] == player && board[6] == player) {
            return true;
        }
        
        return false;
    }
}
